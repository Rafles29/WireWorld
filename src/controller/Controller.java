package controller;

import java.io.FileNotFoundException;

import javax.swing.JSlider;

import io.SimpleStripReader;
import io.SimpleStripWriter;
import model.Strip;
import rules.GenMaker;
import view.GUI;

public class Controller
{
	private Strip strip;
	private GUI wireWorld;
	private boolean flaga;
	private Switcher switcher;
	
	private class Switcher implements Runnable {
		private Thread thread;
		private boolean suspended = false;
		private boolean finished = false;
		private Integer millis = new Integer(1000);
        @Override
		public void run() 
        {
		        	try 
		        	{
				        for(int i=0;i<15;i++)
				        {
				        	GenMaker genMaker = new GenMaker();
				        	strip=genMaker.doGen(strip);
			        		wireWorld.getPanel().updateStrip(strip);
			        		Thread.sleep(millis.intValue());
			                synchronized(this) 
			                {
			                    while(suspended) 
			                    {
			                       wait();
			                    }
			                }
				        }
					} catch (InterruptedException e1) 
		        	{
						
					}
		        	finished=true;
        }
        private void newThreadStart(Switcher switcher) 
        {
            thread = new Thread (switcher);
            thread.start();
        }
        public void start()
        {
           if (thread == null)
           {
             newThreadStart(this);
           }
        }
        public boolean isSuspended() {
        	if(suspended) 
        	{
        		return true;
        	}
        	return false;
        }
        public boolean isFinished() {
        	if(finished) 
        	{
        		return true;
        	}
        	return false;
        }
        public void suspend() {
           suspended = true;
        }
        synchronized void resume() {
           suspended = false;
           notify();
        }
        public boolean isAlive() {
        	if(thread != null && thread.isAlive()) 
        	{
        		return true;
        	}
        	return false;
        }
        public boolean isInterrupted() 
        {
        	if(thread.isInterrupted()) 
        	{
        		return true;
        	}
        	return false;
        }
        public void interrupt()
        {
        	thread.interrupt();
        }
        public Integer getMillis() {
			return millis;
		}
        public void setMillis(int millis) {
			this.millis = millis;
		}
	}
	
	public Controller(Strip strip, GUI wireWorld) {
		this.wireWorld = wireWorld;
		this.strip = strip;
		
		flaga=false;
		switcher = new Switcher();
		handlers();
	}
	
	private void handlers() {
		
		wireWorld.getLoad().addActionListener(e -> 
		{
			SimpleStripReader load = new SimpleStripReader();
			try {
				strip = load.loadStrip(wireWorld.getLoadDestination());
			} catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			wireWorld.getPanel().updateStrip(strip);
			if(switcher.isAlive()) 
			{
				switcher.interrupt();
			}
			switcher = new Switcher();
			switcher.setMillis(wireWorld.getSlider().getValue());
		});
		wireWorld.getSave().addActionListener(e -> 
		{
			if(switcher.isSuspended() || switcher.isFinished() || !switcher.isAlive())
			{
				SimpleStripWriter save = new SimpleStripWriter();
				try 
				{
					save.saveStrip(strip, wireWorld.getSaveDestination());
				} catch (FileNotFoundException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		wireWorld.getStart().addActionListener(e -> 
		{
			if(switcher.isAlive()) 
			{
				switcher.resume();
			}
			else
			{
				if(switcher.thread!=null) 
				{
					switcher = new Switcher();
					switcher.start();
				}
				else
				{
					switcher.start();
				}
			}
		});
		wireWorld.getStop().addActionListener(e ->
		{
			switcher.suspend();
		});
		
		wireWorld.getSlider().addChangeListener(e1 ->
		{
			JSlider source = (JSlider) e1.getSource();
			if (!source.getValueIsAdjusting())
			{
				switcher.resume();
				switcher.setMillis(source.getValue());
				wireWorld.getTempoValueTextField().setText(switcher.getMillis().toString());
			}
			else {
				switcher.suspend();
			}
		});
	}
}
