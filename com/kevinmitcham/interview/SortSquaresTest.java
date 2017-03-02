package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortSquaresTest {
	SortSquares ss;
	@Before
	public void setUp() throws Exception {
		ss = new SortSquares();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testA() {
		int[] a = { 1,2,3,4};
		assertEquals("all pos", "[1, 4, 9, 16]", Arrays.toString(ss.sortedSquaredArray(a)));
	}
	@Test
	public void testB() {
		int[] a = {-6,0, 1};
		assertEquals("all pos", "[0, 1, 36]", Arrays.toString(ss.sortedSquaredArray(a)));
	}
	@Test
	public void testC() {
		int[] a = {-6,-3,-1};
		ss.debug = true;
		assertEquals("all pos", "[1, 9, 36]", Arrays.toString(ss.sortedSquaredArray(a)));
	}
	@Test
	public void testD() {
		int[] a = {-6,-3,-1, 0, 2};
		assertEquals("all pos", "[0, 1, 4, 9, 36]", Arrays.toString(ss.sortedSquaredArray(a)));
	}
}