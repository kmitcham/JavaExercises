package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MazeSolverTest {
	MazeSolver ms;
	@Test
	public void testGetPoints() {
		Integer[] start = {1,1};
		Set<Integer[]> pts = ms.getAdjacent(start, getMazeB());
		assertEquals("correct number", 1, pts.size());
		pts = ms.getAdjacent(start, getMazeA() );
		assertEquals("bigger maze", 2, pts.size());
		Integer[] next = {3,3};
		pts = ms.getAdjacent(next, getMazeA() );
		assertEquals("bigger maze", 3, pts.size());
	}
	@Test
	public void testCanSolveB1(){
		Integer[] start = {1,0}; // or maybe 1,0?
		Integer[] finish = {1,1};
		assertTrue("simple solves", ms.canSolve(getMazeB(), start, finish));
	}
	@Test
	public void testCanSolveB2(){
		Integer[] start = {1,0}; // or maybe 1,0?
		Integer[] finish = {0,1};
		assertTrue("simple blocked ",!ms.canSolve(getMazeB(), start, finish));
	}
	@Test
	public void testCanSolveA1(){
		Integer[] start = {1,0}; // or maybe 1,0?
		Integer[] finish = {3,5};
		assertTrue("big solve ",ms.canSolve(getMazeA(), start, finish));
	}
	@Test
	public void testCanSolveA2(){
		Integer[] start = {1,0}; // or maybe 1,0?
		Integer[] finish = {1,4};
		//ms.debug = true;
		assertTrue("big fail ",!ms.canSolve(getMazeA(), start, finish));
	}

	@Before
	public void setUp() throws Exception {
		ms = new MazeSolver();
	}

	@After
	public void tearDown() throws Exception {
	}

	String[][] getMazeA(){
		String[][] maze = {
				//0   1   2   3   4   5
				{"$","$","$","$","$","$"},//0
				{".",".","$","$",".","$"},//1
				{"$",".","$",".","$","$"},//2
				{"$",".","$",".",".","."},//3
				{"$",".",".",".","$","$"},//4
				{"$",".","$","$","$","$"},//5
		};
		return maze;
	}
	String[][] getMazeB(){
		String[][] maze = {
				{ "$","$"},
				{ ".","."},
					};
		return maze;
	}

}
