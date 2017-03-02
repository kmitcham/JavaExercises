package com.kevinmitcham.codefight;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlmostIncreasingTest {
	AlmostIncreasing ai;
	@Before
	public void setUp() throws Exception {
		ai= new AlmostIncreasing();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAlmostIncreasingSequenceA() {
		int[] s= { 1,2,3,4,5};
		assertTrue("works on valid", ai.almostIncreasingSequence(s));
	}
	@Test
	public void testAlmostIncreasingSequenceB() {
		int[] s= { 1,6,2,3,4,5};
		assertTrue("works on valid", ai.almostIncreasingSequence(s));
	}
	@Test
	public void testAlmostIncreasingSequenceC() {
		int[] s= { 1,6,2,3,8,4,5};
		assertTrue("fail for 6 and 8", !ai.almostIncreasingSequence(s));
	}
	@Test
	public void testAlmostIncreasingSequenceD() {
		int[] s= { 1,3,2,1};
		assertTrue("fail for 3 and 1", !ai.almostIncreasingSequence(s));
	}
	@Test
	public void testAlmostIncreasingSequenceE() {
		int[] s= { 2,3,4,1};
		assertTrue("works bad last value", ai.almostIncreasingSequence(s));
	}	
	@Test
	public void testAlmostIncreasingSequenceF() {
		int[] s= { 2,3,6,4,1};
		assertTrue("fail for 6 and 1", !ai.almostIncreasingSequence(s));
	}
	
	@Test
	public void testK(){
		ai.killKthBit(31, 3);
		ai.killKthBit(27, 3);
		assertEquals("37 4 37", 37,ai.killKthBit(37, 4));
		assertTrue("ffooo",true);
	}

	@Test
	public void testAlmostIncreasingSequence3() {
		int[] s= { 1,2,1,2};
		assertTrue("fails for 2 and 1", !ai.almostIncreasingSequence(s));
	}
}
