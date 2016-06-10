package controler;

import java.awt.event.ItemEvent;

import io.SimpleStripReader;
import io.SimpleStripSave;
import model.Strip;
import rules.GenMaker;
import view.WireWorld;

public class Controler{
	private Strip strip;
	private WireWorld wireWorld;
	boolean flaga;
	
	public Controler(Strip strip, WireWorld wireWorld) {
		this.wireWorld = wireWorld;
		this.strip = strip;
		
		flaga=false;
		handlers();
	}
	
	private void handlers() {
		wireWorld.getLoad().addActionListener(e -> {
			SimpleStripReader load = new SimpleStripReader();
			strip = load.loadStrip(wireWorld.getLoadDestination());
			
		});
		wireWorld.getSave().addActionListener(e -> {
			SimpleStripSave save = new SimpleStripSave();
			save.saveStrip(wireWorld.getSaveDestination());

		});
		wireWorld.getStart().addActionListener(e -> {
        	GenMaker genMaker = new GenMaker();
        	strip=genMaker.doGen(strip);
        	strip.show();
        	wireWorld.getPanel().updateStrip(strip);
			
        	//this.strip.changeField(3, 4, 1);
			//wireWorld.getPanel().updateStrip(strip);
			
	
		});
		wireWorld.getStop().addActionListener(e -> {
			strip.changeField(3, 4, 0);
			wireWorld.getPanel().updateStrip(strip);
		});
		wireWorld.getTglbtnOnoff().addItemListener(e -> {
			if (e.getStateChange()==ItemEvent.SELECTED)
			{
				wireWorld.getTglbtnOnoff().setText("OFF");
		        System.out.println("button is selected");
		        for(int i=0;i<15;i++)
		        {
		        	GenMaker genMaker = new GenMaker();
		        	strip=genMaker.doGen(strip);
		        	strip.show();
	        		wireWorld.getPanel().updateStrip(strip);
		        	try {
						Thread.sleep(100);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
		    }
			else if (e.getStateChange()==ItemEvent.DESELECTED)
			{
				wireWorld.getTglbtnOnoff().setText("ON");
		        System.out.println("button is not selected");
		    }
		});
		
	}
}
