package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DutchFlagSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testSwap() {
		int[] a = { 1,2,3,10,20,21,21};
		int[] result = DutchFlagSort.swap(a, 0, 1);
		Assert.assertEquals(result[0], 2);
		Assert.assertEquals(result[1], 1);
	}
	@Test
	public void testGetNext(){
		int[] a = { 20,21,21,10,1,2,30};
		int exp = 5;
		int res = DutchFlagSort.getIndexOfNextSmall(a, 10, 6);
		Assert.assertEquals(exp, res);
	}
	@Test
	public void testNoActionSort() {
		int[] a = { 1,2,3,10,22,33,44};
		int[] exp = a;
		int[] result = DutchFlagSort.sort(a, 3);
		Assert.assertEquals( exp, result );
	}
	@Test
	public void testActionSort() {
		int[] a = { 44,33,22,10,4,2,1};
		int pivot = 2;
		int[] result = DutchFlagSort.sort(a, pivot);
		for (int i=0; i < result.length; i++){
			if (i < pivot){
				Assert.assertTrue( "fail at result index "+i+":"+result[i]+" vs "+a[pivot], result[i] <= a[pivot]);
			} else  {
				Assert.assertTrue( "fail at result index "+i+":"+result[i]+" vs "+a[pivot],result[i] >= a[pivot]);
			}
		}
	}
	@Test
	public void testActionPivotSort() {
		int[] a = { 10,33,22,10,6,2,10};
		int pivot = 2;
		int[] result = DutchFlagSort.sort(a, pivot);
		for (int i=0; i < result.length; i++){
			if (i < pivot){
				Assert.assertTrue( "fail at result index "+i+":"+result[i]+" vs "+a[pivot]+" "+Arrays.toString(result), result[i] <= a[pivot]);
			} else  {
				Assert.assertTrue( "fail at result index "+i+":"+result[i]+" vs "+a[pivot],result[i] >= a[pivot]);
			}
		}
	}
}