package com.kevinmitcham.interview;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LruCacheTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LruCache lru = new LruCache(2);
		lru.put("1", "1");   // 1  
		String out = lru.get("1");
		assertEquals("1", out);
		out = lru.get("x");
		assertEquals(lru.NOTFOUND, out);
		lru.put("2", "2");  
		lru.put("3","3");
		lru.put("4", "4");
		out = lru.get("1");
		assertEquals(lru.NOTFOUND, out);
		out = lru.get("4");
		assertEquals("4", "4");
		out = lru.get("2");
		lru.put("5", "5");
		out = lru.get("3");
		assertEquals(lru.NOTFOUND, out);
		

	}

}
