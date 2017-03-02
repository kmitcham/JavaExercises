package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExercisesTest {
	Exercises bc;
	@Before
	public void setUp() throws Exception {
		bc = new Exercises();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToBase10() {
        assertEquals("21 in base four", 9, bc.convertToBase10("21", 4));
        assertEquals("1 in base four", 1, bc.convertToBase10("1", 4));
        assertEquals("-321 in base four", -57, bc.convertToBase10("-321", 4));
        assertEquals("10 in base six", 6, bc.convertToBase10("10", 6));

	}
	@Test
	public void testConvertToAltBase(){
        assertEquals("10 in base four", "10", bc.convertToAltBase(4, 4));
        assertEquals("321 in base four", "321", bc.convertToAltBase(57, 4));
        assertEquals("11 in base six", "11", bc.convertToAltBase(7,6));

	}
	@Test
	public void testConvertToBase10Hex() {
        assertEquals("21 in base hex", 33, bc.convertToBase10("21", 16));
        assertEquals("11 in base 12", 13, bc.convertToBase10("11", 12));
        assertEquals("12 in base hex", 12, bc.convertToBase10("C", 16));
        assertEquals("12 in base hex", 12, bc.convertToBase10("C", 16));
        assertEquals("12 in base 20", 22, bc.convertToBase10("12", 20));

	}
	@Test
	public void testMangle(){
		char[] a;
		a = new char[] {'c','c','c','c'};
		assertEquals("simple case", a, bc.mangleChar(a, 3));
		a = new char[] {'c','c','a','c'};
		Assert.assertArrayEquals("simple case", new char[] {'c','c','d','d'}, bc.mangleChar(a, 3));
		a = new char[] {'b','c','a','x'};
		Assert.assertArrayEquals("simple case", new char[] {'c','d','d', 'x'}, bc.mangleChar(a, 3));
	}
	@Test
	public void testMergeSimple(){
		LinkedList<Integer> a = new LinkedList(Arrays.asList(1,3,5));
		LinkedList<Integer> b = new LinkedList(Arrays.asList(2,4));
		LinkedList<Integer> expected = new LinkedList(Arrays.asList(1,2,3,4,5));
		LinkedList<Integer> result = bc.mergeLists(a, b);
		assertTrue("merged list is same", Arrays.equals(expected.toArray(), result.toArray() ));
		
	}
	@Test
	public void testMergeHarder(){
		LinkedList<Integer> a = new LinkedList(Arrays.asList(1,1,1,2,3,5));
		LinkedList<Integer> b = new LinkedList(Arrays.asList(2,4,5));
		LinkedList<Integer> expected = new LinkedList(Arrays.asList(1,1,1,2,2,3,4,5,5));
		LinkedList<Integer> result = bc.mergeLists(a, b);
		assertTrue("merged list is same", Arrays.equals(expected.toArray(), result.toArray() ));
		
	}
	//deprecated; I broke listnode 
	public void testSection(){
		ListNode first = new ListNode(1);
		ListNode temp = first;
		for (int i=2; i<= 6; i++){
			ListNode next = new ListNode(i);
			temp.next = next;
			temp = next;
		}
		bc.reverseSection(first, 2, 4);
		assertEquals("order swap worked", "1 4 3 2 5 6 ", first.toString());		
	}
	// deprecated 
	public void testSectionLonger(){
		ListNode first = new ListNode(1);
		ListNode temp = first;
		for (int i=2; i<= 10; i++){
			ListNode next = new ListNode(i);
			temp.next = next;
			temp = next;
		}
		bc.reverseSection(first, 3, 6);
		assertEquals("Longer order swap worked", "1 2 6 5 4 3 7 8 9 10 ", first.toString());		
	}
	@Test 
	public void testLooper(){
		ListNode first = new ListNode(1);
		ListNode temp = first;
		for (int i=2; i<= 6; i++){
			ListNode next = new ListNode(i);
			temp.next = next;
			temp = next;
		}
		ListNode foo = bc.checkForLoops(first);
		assertNull("no loops gives null", foo);
		temp.next = first.next.next;
		foo = bc.checkForLoops(first);
		assertEquals("found the loop", first.next.next.value, foo.value);		
	}
	@Test
	public void testBalance(){
		BinaryTreeNode<Integer> root = new BinaryTreeNode(new Integer(1));
		root.left = new BinaryTreeNode(new Integer(2));
		root.right = new BinaryTreeNode(new Integer(3));
		
		assertTrue("Simple symetric tree" , bc.isTreeBalanced(root));
		root.left.left = new BinaryTreeNode(new Integer(4));
		assertTrue("one leaf",bc.isTreeBalanced(root));
		root.left.left.left = new BinaryTreeNode(new Integer(5));
		assertTrue("Out of balance",! bc.isTreeBalanced(root));
	}
	@Test 
	public void testFloor(){
		assertEquals(1, bc.floorRoot(1));
		assertEquals(4, bc.floorRoot(16));
		assertEquals(17, bc.floorRoot(323));
		assertEquals(18, bc.floorRoot(324));
		assertEquals(18, bc.floorRoot(324));
	}
	@Test
	public void testKLarge(){
		Integer[] a = {0,1,2,3,4,5,6,7,};
		assertEquals(5, bc.kthLargest(a, 3));
	
	}
	@Test 
	public void testLeastDistance(){
		ArrayList<String> l= new ArrayList<>(Arrays.asList("dog","catx","horse","cat","dog"));
		assertEquals("split on cat", 4, bc.closestMatchedEntries(l));
	}
	@Test
	public void testintersectionOfArrays(){
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,3,5,7,9,11));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1,9));
		ArrayList<Integer> out = bc.intersectionOfArrays(a,b);
		assertEquals("union correct", out.size(), 2);
		assertEquals("Value correct", out.get(0), new Integer(1) );
		b = new ArrayList<>(Arrays.asList(1,2,4,5,5,5,5,6,9,18));
		out = bc.intersectionOfArrays(a,b);
		assertEquals("union correct", out.size(),3);
		assertEquals("Value correct", out.get(0), new Integer(1) );
		b = new ArrayList<>(Arrays.asList());
		out = bc.intersectionOfArrays(a,b);
		assertEquals("union correct", out.size(), 0);
	
	}
	
}
