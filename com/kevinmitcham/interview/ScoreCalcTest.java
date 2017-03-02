package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScoreCalcTest {
	ScoreCalc sc;
	@Before
	public void setUp() throws Exception {
		sc = new ScoreCalc();
	}

	@After
	public void tearDown() throws Exception {
	}
	String p(ArrayList<ArrayList<Integer>> l){
		String s = "S:";
		Iterator<ArrayList<Integer>> i = l.iterator();
		while(i.hasNext()){
			ArrayList<Integer> foo = i.next();
			if (foo != null){
				s+= ":"+foo.toString()+" ";
			} else {
				// this should not happen
				s+=":NULL ";
			}
		}
		return s;
	}
	@Test
	public void testSimple() {
		int[] plays = {1,2};
		ArrayList<ArrayList<Integer>> actual = sc.findCombos(3, plays);
		assertEquals("simple match", "S::[2, 1] :[1, 1, 1] ", p(actual));
		assertEquals("simple Count OK", 2, sc.numberOfCombos(3, plays));
	}
	@Test
	public void testSimpleB() {
		int[] plays = {1,2,5};
		ArrayList<ArrayList<Integer>> actual = sc.findCombos(3, plays);
		assertEquals("simple match", "S::[2, 1] :[1, 1, 1] ", p(actual));
		assertEquals("simpleB Count OK", 2, sc.numberOfCombos(3, plays));
	}
	@Test
	public void testOrder() {
		int[] plays = {1};
		ArrayList<ArrayList<Integer>> actual = sc.findCombos(3, plays);
		assertEquals("simpleB Count OK", 1, sc.numberOfCombos(3, plays));
	}
	@Test
	public void testExample() {
		int[] plays = {2,3,7, 8};
		ArrayList<ArrayList<Integer>> actual = sc.findCombos(8, plays);
		assertEquals("simple match", "S::[8] :[3, 3, 2] :[2, 2, 2, 2] ",
				p(actual));
		assertEquals("8 Count OK", 3, sc.numberOfCombos(8, plays));
	}
	@Test
	public void testBookExample() {
		int[] plays = {2,3,7};
		ArrayList<ArrayList<Integer>> actual = sc.findCombos(12, plays);
		assertEquals("book Count OK", 4, sc.numberOfCombos(12, plays));
	}
	@Test
	public void testBigExample() {
		int[] plays = {2,3,6,7,8};
		assertEquals("book Count OK", 31, sc.numberOfCombos(23, plays));
	}
	@Test
	public void testCountTwo(){
		int[] parts = {0, 2,3,5,11};
		assertTrue(" test 1", sc.canCountTwo(10, parts));
	}
	@Test
	public void testCountThreeA(){
		int[] parts = {0, 2,3,5,11};
		assertTrue(" test 1", sc.canCountThree(10, parts));
	}
	@Test
	public void testCountThreeB(){
		int[] parts = { 2,5,11};
		assertTrue(" test 1",!sc.canCountThree(10, parts));
	}
	@Test
	public void testCountCoins(){
		int[] parts = { 1,5,10, 25};
		
		assertEquals(" test coins",1,sc.numberOfCombos(55, parts));
	}
	@Test
	public void testCountThreeC(){
		int[] parts = { 1, 3,5,7, 17,23, 31};
		assertTrue(" testbigger 2 ",!sc.canCountThree(2, parts));
		assertTrue(" testbigger 3 ",sc.canCountThree(3, parts));
		assertTrue(" testbigger 4",!sc.canCountThree(4, parts));
		assertTrue(" testbigger 9",sc.canCountThree(9, parts));
		assertTrue(" testbigger 10",!sc.canCountThree(10, parts));
		assertTrue(" testbigger 62",!sc.canCountThree(62, parts));
		assertTrue(" testbigger 63",sc.canCountThree(63, parts));
		assertTrue(" testbigger 73",!sc.canCountThree(73, parts));
		assertTrue(" testbigger 92",!sc.canCountThree(92, parts));
		assertTrue(" testbigger 93",sc.canCountThree(93, parts));
		assertTrue(" testbigger 94",!sc.canCountThree(94, parts));
		
		
		}
}
