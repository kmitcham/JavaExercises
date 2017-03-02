package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextJustifyTest {
	TextJustify tj;
	@Before
	public void setUp() throws Exception {
		tj = new TextJustify();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testA() {
		String[] words = {"This","is","some","words","and","some", "exceptionally","or","extravagently", "long","ones."};
		String[] out = tj.textJustification(words, 13);
		assertEquals("baisc test", "[This..is.some, words.....and, some........., exceptionally, or..........., "
				+ "extravagently, long....ones.]", 
				Arrays.toString(out));
	}
	@Test
	public void testB() {
		String[] words = {"This","is","some","word"};
		tj.debug =true;
		String[] out = tj.textJustification(words, 9);
		assertEquals("baisc test", "[This...is, some.word]", Arrays.toString(out));
	}
	@Test
	public void testc() {
		String[] words = {"This","is","some","word", "dogpiles"};
		tj.debug =true;
		String[] out = tj.textJustification(words, 12);
		assertEquals("baisc test", "[This.is.some, word........, dogpiles....]", Arrays.toString(out));
	}
}
