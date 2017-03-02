package com.kevinmitcham.codefight;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SumSubsetsTest {
	SumSubsets ss;
	@Before
	public void setUp() throws Exception {
		ss = new SumSubsets();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSumSubsets() {
		//fail("Not yet implemented");
	}

	@Test
	public void testMatchingSubsets1() {
		int[] arr = {1,2,3,4,5};
		int num = 5;
		assertEquals("test 1","[[1, 4], [2, 3], [5]]", str(ss.sumSubsets(arr, num)));
	}
	@Test
	public void testMatchingSubsets2() {
		int[] arr = {1,2,2,3,4,5};
		int num = 5;
		assertEquals("test 1","[[1, 2, 2], [1, 4], [2, 3], [5]]", str(ss.sumSubsets(arr, num)));
	}
	String  str(int[][] result){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i=0; i< result.length; i++){
			sb.append(Arrays.toString(result[i]) );
			if (result.length > (i+1)){
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
