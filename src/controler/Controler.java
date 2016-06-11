package controler;

import java.io.FileNotFoundException;

import io.SimpleStripReader;
import io.SimpleStripSave;
import model.Strip;
import rules.GenMaker;
import view.WireWorld;

public class Controler{
	private Strip strip;
	private WireWorld wireWorld;
	boolean flaga;
	private Switcher switcher;
	
	private class Switcher implements Runnable {
		public Thread t;
		private volatile boolean stop = false;
		private boolean suspended = false;
		private boolean finished = false;
        @Override
		public void run() {
		        	try {
				        for(int i=0;i<15;i++)
				        {
				        	if(this.stop) {
				        		break;
				        	}
				        	GenMaker genMaker = new GenMaker();
				        	strip=genMaker.doGen(strip);
				        	strip.show();
			        		wireWorld.getPanel().updateStrip(strip);
			        		Thread.sleep(500);
			                synchronized(this) {
			                    while(suspended) {
			                       wait();
			                    }
			                }
				        }
					} catch (InterruptedException e1) {
						
					}
		        	finished=true;
        }
        public void newThreadStart(Switcher switcher) {
            t = new Thread (switcher);
            t.start();
        }
        public void start()
        {
           System.out.println("Starting t1");
           if (t == null)
           {
             newThreadStart(this);
           }
        }
        public boolean isSuspended() {
        	if(suspended) {
        		return true;
        	}
        	return false;
        }
        public boolean isFinished() {
        	if(finished) {
        		return true;
        	}
        	return false;
        }
        void suspend() {
           suspended = true;
        }
        synchronized void resume() {
           suspended = false;
           notify();
        }
        boolean isAlive() {
        	if(t != null && t.isAlive()) {
        		return true;
        	}
        	return false;
        }
        boolean isInterrupted() {
        	if(t.isInterrupted()) {
        		return true;
        	}
        	return false;
        }
	}
	
	public Controler(Strip strip, WireWorld wireWorld) {
		this.wireWorld = wireWorld;
		this.strip = strip;
		
		flaga=false;
		switcher = new Switcher();
		handlers();
	}
	
	private void handlers() {
		
		wireWorld.getLoad().addActionListener(e -> {
			SimpleStripReader load = new SimpleStripReader();
			try {
				strip = load.loadStrip(wireWorld.getLoadDestination());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			wireWorld.getPanel().updateStrip(strip);
			if(switcher.isAlive()) {
				switcher.t.interrupt();
			}
			
		});
		wireWorld.getSave().addActionListener(e -> {
			if(switcher.isSuspended() || switcher.isFinished() || !switcher.isAlive()) {
				SimpleStripSave save = new SimpleStripSave();
				try {
					save.saveStrip(strip, wireWorld.getSaveDestination());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("DUPA");
			}

		});
		wireWorld.getStart().addActionListener(e -> {
			if(switcher.isAlive()) {
				switcher.resume();
			}
			else {
				if(switcher.t!=null) {
					switcher = new Switcher();
					switcher.start();
				}
				else {
					switcher.start();
				}
			}
		});
		wireWorld.getStop().addActionListener(e -> {
			switcher.suspend();
		});
		
	}
}
