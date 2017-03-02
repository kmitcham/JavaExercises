package com.kevinmitcham.lagunita.course;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
	QuickSort qs;
	@Before
	public void setUp() throws Exception {
		qs= new QuickSort();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChoosePartitionA() {
		int[] a = {0,10,20,30};
		assertEquals("cp ", 0, qs.choosePartition(a, 0, 3, QuickSort.PType.first));
		assertEquals("cp ", 3, qs.choosePartition(a, 0, 3, QuickSort.PType.last));
		assertEquals("cp ", 1, qs.choosePartition(a, 0, 3, QuickSort.PType.median));
	}
	@Test
	public void testChoosePartitionB() {
		int[] a = {0,10,20,30, 40};
		assertEquals("cp ", 0, qs.choosePartition(a, 0, 4, QuickSort.PType.first));
		assertEquals("cp ", 4, qs.choosePartition(a, 0, 4, QuickSort.PType.last));
		assertEquals("cp ", 2, qs.choosePartition(a, 0, 4, QuickSort.PType.median));
	}

	@Test
	public void testSwap() {
		int[] a = {0,10,20};
		qs.swap(a, 0, 1);
		assertEquals("cp ", 10, a[0]);
		qs.swap(a, 0, 0);
		assertEquals("cp ", 10, a[0]);
		qs.swap(a, 0, 2);
		assertEquals("cp ", 20, a[0]);
	}

	@Test
	public void testQuickSortA() {
		int[] a = {0,1,2,3};
		qs.quickSort(a, 0, 3, QuickSort.PType.first);
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.first);
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}	
	@Test
	public void testQuickSortA2() {
		int[] a = {0,1,2,1,2,3,3};
		qs.quickSort(a, 0, 3, QuickSort.PType.first);
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.first);
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}
	@Test
	public void testQuickSortB() {
		int[] a = {3,2,1,0};
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.first);
		assertEquals("sorting", "[0, 1, 2, 3]", Arrays.toString(a));		
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}
	@Test
	public void testQuickSortC() {
		int[] a = {3,2,4,1,0};
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.first);
		assertEquals("sorting", "[0, 1, 2, 3, 4]", Arrays.toString(a));		
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}
	@Test
	public void testQuickSortD() {
		int[] a = {3,2,4,1,0,6,5,7,8};
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.first);
		assertEquals("sorting", "[0, 1, 2, 3, 4, 5, 6, 7, 8]", Arrays.toString(a));		
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}
	@Test
	public void testQuickSortVeryLongF() {
		testVeryLong(QuickSort.PType.first);
	}
	@Test
	public void testQuickSortVeryLongL() {
		testVeryLong(QuickSort.PType.last);
	}
	@Test
	public void testQuickSortVeryLongM() {
		testVeryLong(QuickSort.PType.median);
	}
	public void testVeryLong(QuickSort.PType type){
		int[] a = new int[25600];
		for (int i=0; i < a.length; i++){
			a[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		qs.quickSort(a, 0, a.length-1, type);
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}	
	@Test
	public void testQuickSortLongBm() {
		testLong(QuickSort.PType.median);
	}
	@Test
	public void testQuickSortLongBf() {
		testLong(QuickSort.PType.first);
	}
	@Test
	public void testQuickSortLongBl() {
		testLong(QuickSort.PType.last);
	}
	public void testLong(QuickSort.PType type){
		for ( int k = 2800; k < 5000; k+=100){
				System.out.print(".");
				int[] a = new int[k];
				int min=0, max=0;
				for (int i=1; i < a.length; i++){
					a[i] = (int) (Math.random() * Integer.MAX_VALUE);
					if (a[i] > max){
						max = a[i];
					}
				}
				qs.quickSort(a, 0, a.length-1, type);
				assertEquals("is sorted length="+k, -1, qs.isSorted(a));
		}
	}
	@Test
	public void testQuickSortLongA() {
		int[] a = new int[256];
		int min=0, max=0;
		for (int i=1; i < a.length; i++){
			a[i] = (int) (Math.random() * Integer.MAX_VALUE);
			if (a[i] > max){
				max = a[i];
			}
		}
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.first);
		assertEquals("is sorted ", -1, qs.isSorted(a));
		assertEquals("sorting "+(a.length), 0, a[0]);		
		assertEquals("sorting "+(a.length), max, a[ a.length-1 ]);		
	}
	@Test
	public void testQuickSortAm() {
		int[] a = {0,1,2,3};
		qs.quickSort(a, 0, 3, QuickSort.PType.first);
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.median);
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}
	@Test
	public void testQuickSortBm() {
		int[] a = {3,2,1,0};
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.median);
		assertEquals("sorting", "[0, 1, 2, 3]", Arrays.toString(a));		
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}
	@Test
	public void testQuickSortCm() {
		int[] a = {3,2,4,1,0};
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.median);
		assertEquals("sorting", "[0, 1, 2, 3, 4]", Arrays.toString(a));		
		assertEquals("is sorted ", -1, qs.isSorted(a));
	}
	@Test
	public void testQuickSortDm() {
		int[] a = {3,2,4,1,0,6,5,7,8};
		//qs.debug = true;
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.median);
		assertEquals("sorting", "[0, 1, 2, 3, 4, 5, 6, 7, 8]", Arrays.toString(a));		
	}
	@Test
	public void testQuickSortRealA() {
		int[] a = {5973, 5975, 5976, 5974, 5965, 5967, 5970, 5971, 5966, 5972, 5968, 5969};
		qs.debug = false;
		qs.quickSort(a, 0, a.length-1, QuickSort.PType.median);
		assertEquals("sorting", -1, qs.isSorted(a));		
	}
	
	//5973, 5975, 5976, 5974, 5965, 5967, 5970, 5971, 5966, 5972, 5968, 5969
}
