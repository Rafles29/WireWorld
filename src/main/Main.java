package main;

import controler.Controler;
import model.Strip;
import view.WireWorld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strip strip = new Strip(10);
		strip.changeField(0, 5, 3);
		strip.changeField(1, 5, 3);
		strip.changeField(2, 5, 3);
		strip.changeField(3, 5, 3);
		strip.changeField(4, 5, 3);
		strip.changeField(5, 5, 2);
		strip.changeField(6, 5, 1);
		strip.changeField(7, 4, 3);
		strip.changeField(7, 6, 3);
		strip.changeField(8, 4, 3);
		strip.changeField(8, 5, 3);
		strip.changeField(8, 6, 3);
		//strip.changeField(9, 5, 3);
		strip.show();		
		
		WireWorld wireWorld = new WireWorld(strip);
		Controler controler = new Controler(strip, wireWorld);
	}

}
