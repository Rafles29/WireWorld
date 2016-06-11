package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import model.Strip;

public class SimpleStripSave {
	
	private String estimateCell(int state)
	{
		switch(state)
		{
		case 1: return "H";
		case 2: return "T";
		case 3: return "C";
		default: return "";
		}
	}
	
	public void saveStrip(Strip strip, String fileSave) throws FileNotFoundException
	{
		int size = strip.getSize();
		File file = new File(fileSave);
		PrintWriter print = new PrintWriter(file);	
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(strip.getState(j, i) == 0)
				{
					continue;
				}
				else
				{
					print.println(estimateCell(strip.getState(j, i)) + " " + j + " " + i + " ");
				}
			}			
		}
		print.close();
	}

}
