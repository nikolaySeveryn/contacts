package nks.contacts.web;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaskTest {

	@Test
	public void equlasLengthMaskTest(){
		Mask mask = new Mask("(99) 99-99");
		String result = mask.cast("353535");
		assertEquals("(35) 35-35", result);
	}
	
	@Test
	public void largerInputTest(){
		Mask mask = new Mask("(99) 99-99");
		String result = mask.cast("3535351");
		assertEquals("(35) 35-351", result);
	}
	
	@Test
	public void shorterInput(){
		Mask mask = new Mask("(99) 99-99");
		String result = mask.cast("35353");
		assertEquals("(35) 35-3", result);
	}
}