package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.*;

public class StripTest 
{

	@Test
	public void test() 
	{
		Strip strip1 = new Strip(10);
		assertEquals(strip1.getSize(), 10);
		
		strip1.changeField(3, 4, 2);
		assertEquals(2, strip1.getState(3, 4));
		
		strip1.show();
		
		Field[][] test = strip1.duplicateGrid();
		assertEquals(2, test[4][3].getState());	
				
		strip1.clearStrip();
		assertEquals(0, strip1.getState(3, 4));	
		assertEquals(0, strip1.getState(3, 5));	
		
		Strip strip2 = strip1.duplicateStrip();
		assertEquals(strip2.getState(3, 5), strip1.getState(3, 5));
	}

}
