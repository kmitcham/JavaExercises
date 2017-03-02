package com.kevinmitcham.codefight;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KBoringTest {
	KBoring k;
	@Before
	public void setUp() throws Exception {
		k = new KBoring();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKthBoring1() {
		int a = 1;
		assertEquals("1->4", 4, k.kthBoring(1));
	}
	@Test
	public void testKthBoring2() {
		assertEquals("3->9", 9, k.kthBoring(3));
		//fail("Not yet implemented");
	}
	@Test
	public void testKthBoring4() {
		assertEquals("5->12", 12, k.kthBoring(5));
		//fail("Not yet implemented");
	}
	@Test
	public void testKthBoring7() {
		assertEquals("10->20", 20, k.kthBoring(10));
		//fail("Not yet implemented");
	}
	@Test
	public void testKthBoring9() {
		assertEquals("17-30", 30, k.kthBoring(17));
		//fail("Not yet implemented");
	}
	@Test
	public void testKthBoringA() {
		int a = 200000;
		assertEquals("200000->20", 219592, k.kthBoring(200000));
		//fail("Not yet implemented");
	}

	@Test
	public void testIsPrime() {
		assertTrue("1", !k.isPrime(1));
		assertTrue("2", k.isPrime(2));
		assertTrue("3", k.isPrime(3));
		assertTrue("4", !k.isPrime(4));
		for (int i = 5; i < 30; i++){
			k.isPrime(i);
		}
		assertTrue("17", k.isPrime(17));
		assertTrue("18", !k.isPrime(18));
		assertTrue("29", k.isPrime(29));
		
	}
		@Test
		public void testIsPrimeDeluxe() {
			boolean works = true;
			int foo = 50000;
			k.fillSieve(foo*20);
			for (int a = 2; a < foo*20; a++){
				k.isPrimeC(a);
				if( a%20000 == 0){
					System.out.println(" filling c a="+a+" size = "+k.p.size());
				}
			}
			System.out.println("begining actual check");
			int checked = 0;
			for (int a= 2; a< k.primes.length; a++){
	            if ( (a) % 10000 == 0){
	            	System.out.printf(" checking a=%d \n", a);
	            }
				if (k.primes[a]){
					checked++;
					if (! k.isPrimeB(a)){
						System.out.printf("b fail on a=%d \n", a);
						works = false;
					}
					if ( ! k.isPrimeC(a)){
						System.out.printf("c fail on %d\n", a);
						works = false;
					}
				}
			}
			System.out.println("Complete for "+foo);
			System.out.println("checked "+checked);
			assertTrue("They both worked", works);
	}

}
