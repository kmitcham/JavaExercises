package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpiralOrderingTest {
	SpiralOrdering s;
	@Before
	public void setUp() throws Exception {
		s = new SpiralOrdering();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleOrder() {
		int[][] input = {
				{1,2},
				{3,4}
		};
		int[] output = {1,2,4,3};
		Assert.assertArrayEquals(output, s.spiralOrder(input));
	}
	@Test
	public void testThreeOrder() {
		int[][] input = {
				{1,2,3},
				{4,5,6},
				{6,7,8}
		};
		int[] output = {1,2,3,6,8,7,6,4,5};
		Assert.assertArrayEquals(output, s.spiralOrder(input));
	}
	@Test
	public void testFourOrder() {
		int[][] input = {
				{ 1, 2, 3, 4},
				{ 5, 6, 7, 8},
				{ 9,10,11,12},
				{13,14,15,16}
		};
		int[] output = {1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10};
		Assert.assertArrayEquals(output, s.spiralOrder(input));
	}
	@Test
	public void testNotSquare() {
		int[][] input = {
				{ 1, 2, 3},
				{ 5, 6, 7},
				{ 9,10,11},
				{13,14,15}
		};
		int[] output = {1,2,3,7,11,15,14,13,9,5,6,10};
		Assert.assertArrayEquals(output, s.spiralOrder(input));
	}

}
