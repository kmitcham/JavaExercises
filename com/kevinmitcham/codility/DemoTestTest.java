package com.kevinmitcham.codility;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoTestTest {
	DemoTest dt;
	@Before
	public void setUp() throws Exception {
		dt = new DemoTest();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] A = {1,1,1};
		assertEquals(" case null ", 1, dt.solution(A));
	}
	@Test
	public void testA() {
		int[] A = {1,1,1,0,0,0,0};
		assertEquals(" case A ", 1, dt.solution(A));
	}
	@Test
	public void testB() {
		int[] A = {1,3,5};
		assertEquals(" case B ", -1, dt.solution(A));
	}
	@Test
	public void testC() {
		int[] A = {1,-1,1};
		assertEquals(" case C ", 0, dt.solution(A));
	}
	@Test
	public void testE() {
		int[] A = {1,0};
		assertEquals(" case C ", 0, dt.solution(A));
	}
	@Test
	public void testD1() {
		int[] A = {Integer.MAX_VALUE,50,50, 50,Integer.MAX_VALUE};
		assertEquals(" case D ", 2, dt.solution(A));
	}
	@Test
	public void testD2() {
		int[] A = {Integer.MIN_VALUE,50,50, 50,Integer.MIN_VALUE};
		assertEquals(" case D ", 2, dt.solution(A));
	}
	@Test
	public void test1() {
		int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};
		assertEquals(" case 1", 1, dt.solution(A));
	}
	
}
