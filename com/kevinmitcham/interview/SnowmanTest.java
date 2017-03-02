package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SnowmanTest {
	Snowman s;
	@Before
	public void setUp() throws Exception {
		s = new Snowman();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	public void testSimple() {
		int[] input = {1,1,2,2,2,3};
		double exp = 71.1;
		double result = s.snowmen(input);
		if (Math.abs(exp-result) > 1){
			fail("to big a change "+ exp+ " "+result);
		}
	}

//snowballs: [3, 1, 3, 1, 1, 1, 2, 1, 5, 2]
	public void testManyOnes() {
		int[] input = {3, 1, 3, 1, 1, 1, 2, 1, 5, 2};
		double exp = 16.75;
		double result = s.snowmen(input);
		if (Math.abs(exp-result) > 0.1){
			fail("to big a change "+ exp+ " "+result);
		}
	}
	public void testManyNotJustBiggest() {
		int[] input = {1, 1, 1, 2, 3, 4, 5, 6, 7};
		double exp = 0;
		double result = s.snowmen(input);
		if (Math.abs(exp-result) > 0.1){
			fail("to big a change "+ exp+ " "+result);
		}
	}
	//////////////////////////////////////////////////
	@Test
	public void testManFromBalls(){
		int[] balls = { 1,2,3,4,4,5};
		Integer[] man = {3,4,5};
		int[] expected = { 1,2,4};
		assertEquals("subtract", Arrays.toString(expected),Arrays.toString(s.subtractManFromBalls(balls, man)));
	}
	@Test
	public void testMakeBestA() {
		int[] input = {1, 4, 6, 3, 6, 6};
		int[] expected = {3,4,6};
		int[] actual = s.makeBestSnowman(input);
		assertEquals("made best", Arrays.toString(expected), Arrays.toString(actual));
	}
	@Test
	public void testMakeBestB() {
		int[] input = {1, 2, 6, 97,98, 99};
		int[] expected = {97,98,99};
		int[] actual = s.makeBestSnowman(input);
		assertEquals("made best", Arrays.toString(expected), Arrays.toString(actual));
	}	
	@Test
	public void testMakeAllBestA() {
		int[] input = {1, 2, 4, 6, 3, 6, 6};
		Snowman.SnowMen men = s.makeAllBestSnowmen(input);
		assertEquals("Made all", "T:532.0 [1, 2, 6] [3, 4, 6]", men.toString());
	}
	@Test
	public void testMakeAllBestB() {
		int[] input = {1, 2, 6, 97,98, 99};
		Snowman.SnowMen men = s.makeAllBestSnowmen(input);
		assertEquals("Made all", "T:2824389.0 [1, 2, 6] [97, 98, 99]", men.toString());
	}
	//[]
	@Test
	public void testMakeAllBestC() {
		int[] input = {1, 1, 1, 2, 3, 4, 5, 6, 7};
		Snowman.SnowMen men = s.makeAllBestSnowmen(input);
		assertEquals("Made all", "T:786.0 [1, 2, 3] [3, 4, 5] [5, 6, 7]", men.toString());
		assertEquals("remainder OK", 0.0, s.snowmen(input), 0.5);
	}
	@Test
	public void testMakeAllBestMany() {
		int[] input = {1, 1, 1, 1,1,2,2,2,2,2,3,3,3,3,3,1, 1, 1, 1,1,2,2,2,2,2,3,3,3,3,3,1, 1, 1, 1,1,2,2,2,2,2,3,3,3,3,3,1, 1, 1, 1,1,2,2,2,2,2,3,3,3,3,3};
		Snowman.SnowMen men = s.makeAllBestSnowmen(input);
		assertEquals("remainder OK", 0.0, s.snowmen(input), 0.5);
	}
	@Test
	public void testMakeAllBestD() {
		int[] input = {1, 1, 1};
		Snowman.SnowMen men = s.makeAllBestSnowmen(input);
		assertNull("Made none illegally", men);
		assertEquals("remainder OK", 12.566, s.snowmen(input), 0.5);
	}
	@Test
	public void testMakeBestNull() {
		int[] input = {1, 1, 6, 6, 6};
		int[] actual = s.makeBestSnowman(input);
		assertNull("none made", actual);

	}
	
	
	//1, 1, 1, 2, 3, 4, 5, 6, 7
}
