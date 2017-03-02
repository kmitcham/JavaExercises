package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordConversionTest {
	WordConversion wc;
	@Before
	public void setUp() throws Exception {
		wc = new WordConversion();
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testOff(){
		String[] dictionary= { "dog", "dug", "tug", "tag", "dag"};
		List<String> d = Arrays.asList(dictionary);;
		
		List<String> result = wc.getOffByOne("dig", d);
		assertEquals("correct size", 3, result.size());
	}
	
	@Test
	public void testOneOff() {
		assertTrue(" dog-dag", wc.isOffByOne("dog", "dag"));
		assertTrue(" dog-cot", !wc.isOffByOne("dog", "cot"));
	}
	@Test
	public void testPath(){
		String[] d= { "bat", "cot", "dog","dag","dot", "cat"};
		List<String> dictionary = Arrays.asList(d);
		List<String> path = new ArrayList();
		assertEquals("correct path size", 3, wc.stepsToConvert("dog", "cat", dictionary, path));
		System.out.println(d.length+" testPath 1 Checks is "+wc.checks);
	}
	@Test
	public void testPath2(){
		String[] d= { "bat", "cot", "dog","dag","dot", "cat", "zap", "hat", "hut", "fun"};
		List<String> dictionary = Arrays.asList(d);
		List<String> path = new ArrayList();
		assertEquals("correct path size", 3, wc.stepsToConvert("dog", "cat", dictionary, path));
		System.out.println(d.length+" testPath2 2 Checks is "+wc.checks);
	}
	@Test
	public void testBadPath(){
		String[] d= { "bat", "cot", "dog","dag","dot", "cat", "zap"};
		List<String> dictionary = Arrays.asList(d);
		List<String> path = new ArrayList();
		assertEquals("correct path size", -1, wc.stepsToConvert("dog", "zap", dictionary, path));
		System.out.println(d.length+" testBadPath 1 is "+wc.checks);
	}
	@Test
	public void testBadPath2(){
		String[] d= { "bat", "cot", "dog","dag","dot", "cat", "zap", "hat", "hut", "fun"};
		List<String> dictionary = Arrays.asList(d);
		List<String> path = new ArrayList();
		assertEquals("correct path size", -1, wc.stepsToConvert("dog", "zap", dictionary, path));
		assertEquals("cf version",0, wc.wordLadder("dog", "zap", d));
		System.out.println(d.length+" testBadPath2 2 is "+wc.checks);
	}
	@Test
	public void testBestPath(){
		// dog  hog hug mug mut mat cat
		// dog dag fag  fat cat
		String[] d= {"hot",	 "hog",	 "hug", "mug", "mut", "mat", "cat", "dag", "fag", "fat" };
		List<String> dictionary = Arrays.asList(d);
		List<String> path = new ArrayList();
		wc.debug = true;
		assertEquals("correct path size", 4, wc.stepsToConvert("dog", "cat", dictionary, path));
		System.out.println(d.length+" testBestPath  is "+wc.checks);
		assertEquals("cf version",5, wc.wordLadder("dog", "cat", d));
	}
	@Test
	public void testCodeFight2(){
		String[] d= {"hot",	 "dot",	 "dog", "lot", "log" };
		List<String> dictionary = Arrays.asList(d);
		List<String> path = new ArrayList();
		assertEquals("correct path size", -1, wc.stepsToConvert("hit", "cog", dictionary, path));
		System.out.println(d.length+" testBadPath2 2 is "+wc.checks);
		assertEquals("cf version",0, wc.wordLadder("hit", "cot", d));
	}
/*
 * 
beginWord: "hit"
endWord: "cog"
wordList: []
 */
}
