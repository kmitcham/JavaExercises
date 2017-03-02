package com.kevinmitcham.codility;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SwapperTest {
	Swapper sw;
	@Before
	public void setUp() throws Exception {
		sw = new Swapper();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		int[] A = {1,5,3,3,7};
		assertTrue( "case one pass", sw.solution(A));
	}
	@Test
	public void test2() {
		int[] A = {1,3,5,3,4};
		assertFalse( "cast two fail", sw.solution(A));
	}
	@Test
	public void test3() {
		int[] A = {1,3,5,7};
		assertTrue( "case 3 pass", sw.solution(A));
	}
	@Test
	public void test4() {
		int[] A = {1,7,3,4,5,6,2,8};
		assertTrue( "case 4 pass", sw.solution(A));
	}	
	@Test
	public void test5A() {
		int[] A = new int[1000];
		for (int i=0; i < A.length;i++){
			A[i] = i;
		}
		A[200] = A[1];
		A[1] = 200;
		assertTrue( "case 5 long pass", sw.solution(A));
		A[2] = 2000;
		assertTrue( "case 5 long fail ", !sw.solution(A));

	}

}
