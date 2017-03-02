package com.kevinmitcham.lagunita.course;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FindInversionsTest {
	FindInversions fi;
	@Before
	public void setUp() throws Exception {
		fi = new FindInversions();
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testOne() {
		Integer[] a = { 1 };
		FindInversions.Results r= fi.countInversions(a, 0, 0);
		assertEquals("ordered a no inversions", 0, r.inversions, 0.001);
	}
	@Test
	public void testTwo() {
		Integer[] a = { 1,2 };
		FindInversions.Results r= fi.countInversions(a, 0, 1);
		assertEquals("ordered a no inversions", 0, r.inversions, 0.001);
	}
	@Test
	public void testA() {
		Integer[] a = { 1,2,3,4,5,6,7,8};
		fi.debug = false;
		FindInversions.Results r= fi.countInversions(a, 0, 7);
		assertEquals("ordered a no inversions", 0, r.inversions, 0.001);
	}
	@Test
	public void testB() {
		Integer[] a = { 1,2,3,4,5,7,8,6};
		FindInversions.Results r= fi.countInversions(a, 0, 7);
		assertEquals("2 inversions", 2, r.inversions, 0.001);
	}
	@Test
	public void testC() {
		Integer[] a = { 1,2,3,5,4,6,7,8};
		FindInversions.Results r= fi.countInversions(a, 0, 7);
		assertEquals("edge inversions", 1, r.inversions, 0.001);
	}
	@Test
	public void testD() {
		Integer[] a = { 8,7,6,5,4,3,2,1};
		FindInversions.Results r= fi.countInversions(a, 0, 7);
		assertEquals("edge inversions", 28, r.inversions, 0.001);
	}
	@Test
	public void testE() {
		Integer[] a = new Integer[10];
		for (int i = a.length-1; i >= 0; i--){
			a[i] = (a.length+1 - i);
		}
		FindInversions.Results r= fi.countInversions(a, 0 ,a.length-1);
		assertEquals("edge inversions", 45, r.inversions, 0.001);
	}
	@Test
	public void testF() {
		Integer[] a = new Integer[100];
		for (int i = a.length-1; i >= 0; i--){
			a[i] = (a.length+1 - i);
		}
		FindInversions.Results r= fi.countInversions(a, 0 ,a.length-1);
		assertEquals("edge inversions", ((a.length-1)*50), r.inversions, 0.001);
	}	@Test
	public void testG() {
		Integer[] a = new Integer[1000];
		for (int i = a.length-1; i >= 0; i--){
			a[i] = (a.length+1 - i);
		}
		FindInversions.Results r= fi.countInversions(a, 0 ,a.length-1);
		System.out.printf(" inversions %f", r.inversions);
		assertEquals("edge inversions", ((a.length-1)*500), r.inversions, 0.001);
	}


}
