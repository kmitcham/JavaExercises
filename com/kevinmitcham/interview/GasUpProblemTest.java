package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GasUpProblemTest {
	GasUpProblem g;
	@Before
	public void setUp() throws Exception {
		g = new GasUpProblem();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimple() {
		int[] vals = {0, -10, 5,5,0,10};
		LinkedList<City> cities = makeCities(vals);
		assertEquals("ample index worked ", 2, g.smartFindAmple(cities));
		
	}
	@Test
	public void testInitial() {
		int[] vals = {10,0, -10, 5,5,0,10};
		LinkedList<City> cities = makeCities(vals);
		assertEquals("ample index worked ", 0, g.smartFindAmple(cities));
	}
	@Test
	public void testLowestB() {
		int[] vals = {10,0, -10, 5,-20, 5,0,10};
		LinkedList<City> cities = makeCities(vals);
		assertEquals("ample index worked ", 5, g.smartFindAmple(cities));
	}
	private LinkedList<City> makeCities(int[] nets){
		LinkedList<City> cities = new LinkedList();
		for (int i: nets){
			cities.add(new City(i));
		}
		return cities;
	}

}
