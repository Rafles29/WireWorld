package controler;

import io.SimpleStripReader;
import io.SimpleStripSave;
import model.Strip;
import view.WireWorld;

public class Controler {
	private Strip strip;
	private WireWorld wireWorld;
	
	public Controler(Strip stip, WireWorld wireWorld) {
		this.wireWorld = wireWorld;
		this.strip = strip;
		
		//handlers();
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
	
		});
		wireWorld.getStop().addActionListener(e -> {
	
		});
	}
}
