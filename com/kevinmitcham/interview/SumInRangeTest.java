package com.kevinmitcham.interview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SumInRangeTest {
	SumInRange sir;
	@Before
	public void setUp() throws Exception {
		sir = new SumInRange();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test0() {
		int[] nums = {0, 1,2,3, 4, 5,6,7,8};
		int[][] queries = { {0,0}, {1,1}, { 0,8}};
		assertEquals(" first simple case", 37, sir.sumInRange(nums, queries) );
	}
	@Test
	public void test1() {
		int[] nums = {3, 0, -2, 6, -3, 2};
		int[][] queries = { {0,2}, {2,5}, { 0,5}};
		sir.debug = true;
		assertEquals(" first simple case", 10, sir.sumInRange(nums, queries) );
	}
	@Test
	public void test2() {
		int[] nums = {0, 1,2,3, 4, 5,6,7,8};
		int[][] queries = { {0,0}, {3,4}, { 3,5}};
		assertEquals(" first simple case", 19, sir.sumInRange(nums, queries) );
	}
	@Test
	public void test3() {
		int[] nums = {0, 1,2,3, 4, 5,6,7,8};
		int[][] queries = { {0,8}, {0,8}, { 0,8}};
		assertEquals(" first simple case", 36*3, sir.sumInRange(nums, queries) );
	}
	@Test
	public void visible3() {
		int[][] points = { {3,3}, {-4,-4}, { -2,-2}, {1,-1}, {10,-10}};
		assertEquals(" first simple case", 2, sir.visiblePoints(points) );
	}
	@Test
	public void visible1() {
		int[][] points ={{1,1}, 
				 {3,1}, 
				 {3,2}, 
				 {3,3}, 
				 {1,3}, 
				 {2,5}, 
				 {1,5}, 
				 {-1,-1}, 
				 {-1,-2}, 
				 {-2,-3}, 
				 {-4,-4}};
		assertEquals(" first simple case", 6, sir.visiblePoints(points) );
	}
	/*
	 * 
points: {{1,1}, 
 {3,1}, 
 {3,2}, 
 {3,3}, 
 {1,3}, 
 {2,5}, 
 {1,5}, 
 {-1,-1}, 
 {-1,-2}, 
 {-2,-3}, 
 {-4,-4}}
	 */
}
