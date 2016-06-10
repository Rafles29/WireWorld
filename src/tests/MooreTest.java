package tests;
import rules.Moore;
import model.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MooreTest {

	@Test
	public void test() {
		Strip strip = new Strip(10);
		strip.changeField(5, 4, 1);
		strip.changeField(5, 5, 1);
		strip.changeField(7, 4, 1);
		Moore mur = new Moore();
		assertEquals(3, mur.countHeads(strip, 6, 4));	
		
	}

}
