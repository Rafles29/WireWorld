package main;

import controller.Controller;
import model.Strip;
import view.GUI;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strip strip = new Strip(10);
		
		GUI wireWorld = new GUI(strip);
		Controller controller = new Controller(strip, wireWorld);
	}

}
