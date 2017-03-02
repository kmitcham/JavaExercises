package com.kevinmitcham.codility;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParkerTest {
	Parker p;
	@Before
	public void setUp() throws Exception {
		p = new Parker();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSolutionA() {
		assertEquals("1 minute", 5, p.solution("00:00", "00:01"));
		assertEquals("59 minute", 5, p.solution("00:00", "00:59"));
		assertEquals("60 minute", 5, p.solution("00:00", "01:00"));
		assertEquals("61 minute", 9, p.solution("00:00", "01:01"));
	}
	@Test
	public void testSolutionB() {
		assertEquals("23 hours", 5+22*4, p.solution("00:00", "23:00"));
		assertEquals("24", 5+23*4, p.solution("00:00", "23:01"));
		assertEquals("24", 5+23*4, p.solution("00:00", "23:59"));
	}

	@Test
	public void testConvertTime() {
		String s = "12:23";
		assertEquals("12:23", 12*60+23, p.convertTime(s));
		
		s = "02:01";
		assertEquals(s, 2*60+1, p.convertTime(s));
		
		s = "23:00";
		assertEquals(s, 23*60, p.convertTime(s));
		
		s = "00:00";
		assertEquals(s, 0, p.convertTime(s));
	}

}
