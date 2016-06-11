package io;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Strip;

public class SimpleStripReader {
	
	private int estimateCell(String s)
	{
		switch(s)
		{
			case "h": return 1;
			case "head": return 1;
			case "H": return 1;
			case "Head": return 1;
			
			case "t": return 2;
			case "tail": return 2;
			case "T": return 2;
			case "Tail": return 2;
			
			case "c": return 3;
			case "conductor": return 3;
			case "C": return 3;			
			case "Conductor": return 3;
			
			default: return -1;
		}
	}
	
	public Strip loadStrip(String fileLoad) throws FileNotFoundException
	{
		Strip strip = new Strip(10);
		String temp;
		int x, y;
		System.out.println(fileLoad);
		File fr;
			fr = new File(fileLoad);
			Scanner scaner = new Scanner(fr);
			 while(scaner.hasNext()) {
                 temp = scaner.next();
                 x = scaner.nextInt();
                 y = scaner.nextInt();
                 
                 if(x>strip.getSize() || y>strip.getSize())
                 {
                	 continue;
                 }
                 else
                 {
                	 strip.changeField(x, y, estimateCell(temp));
                 }
			 }
			 scaner.close();
			
		return strip;
	}

}
