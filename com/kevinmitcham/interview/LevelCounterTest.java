package com.kevinmitcham.interview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LevelCounterTest {
	LevelCounter lc;
	@Before
	public void setUp() throws Exception {
		lc = new LevelCounter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String a = "(1(2(3)(4))(5))";
		assertEquals("SimpleTest", 7, lc.treeLevelSum(a, 2));
	}

}
