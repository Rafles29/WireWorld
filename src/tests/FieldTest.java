package tests;
import model.Field;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest 
{

	@Test
	public void test() 
	{
		Field field = new Field(5);
		assertEquals(5, field.getState());
		field.changeState(7);
		assertEquals(7, field.getState());	
	}

}
