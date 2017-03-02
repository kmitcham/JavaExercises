package com.kevinmitcham.codefight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class KBoring {
	int kthBoring(int k) {
	    ArrayList<Integer> boring = new ArrayList(k);
	    
	    int a =1, b = 2, next = a+b;
	    HashMap<Integer, Integer> f = new HashMap(k);
	    f.put(1,1); f.put(2,1);
	    for (int i =0; i < 26; i++ ){
	    	next = a+b;
	        f.put( (next) ,1);
	        a = b;
	        b = next;
	    }
	    int n = 1;
	    p.add(2);
	    p.add(3);
	    p.add(5);
	    p.add(7);
	    fillSieve(k+20);
	    StringBuilder sb = new StringBuilder();
	    while (boring.size() < k ){
	        n++;
	    	sb.append("checking "+n+" ");
	        if ( f.containsKey(n) ) {
	        	sb.append(" f ");
	        } else if(  isPrime(n)){
	        	sb.append(" p ");
	        } else {
	            boring.add(n);
	            sb.append(" b " + boring.size());
	        }
	        //System.out.println(sb.toString());;
	    }
	    return n;
	    
	}
	protected ArrayList<Integer> p = new ArrayList();
	boolean[] primes;
	void fillSieve(){
		fillSieve(250);
	}
	void fillSieve(int k){
		boolean[] np = new boolean[k];
		System.out.println(" ----------- filling sieve for "+k);
		if (k > Integer.MAX_VALUE){
			System.out.println(" k is very lager "+k);
		}
		Arrays.fill(np,true);        // assume all integers are prime.
	    int start = 2;
	    np[0]=np[1]=false;       // we know 0 and 1 are not prime.
	   
	    for (int i=start;i<np.length;i++) {
	        //if the number is prime,
	        //then go through all its multiples and make their values false.
            if ( (i) % 1000000 == 0){
            	System.out.printf(" i=%d \n", i);
            }
	        if(np[i]) {
	            for (int j=2;i*j<np.length;j++) {
	                np[i*j]=false;
	            }
	        }
	    }
	    this.primes = np;
	}
	boolean isPrime(int k){
		if (primes == null || primes.length -2 < k){
			fillSieve(2*k);
		}
		return primes[k];
	}
	boolean isPrimeC(int k){
	    if (p.contains(k))
	        return true;
	    double max = Math.sqrt(k);
	    int m = (int) max;
	    int factor;
	    for (int i= 0; i < p.size() ; i++){
	        factor = p.get(i);
	        if (factor == 0){
	        	System.out.println(" somehow got a 0? at i="+i);
	        	continue;
	        }
	        int mod = k % factor;
	    	if ( k%factor == 0)
	            return false;
	    }
	    if ( k != 1)   p.add(k);
	    return true;
	}
	boolean isPrimeB(int n) {
	    for(int i=2;2*i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    
	    return true;
	}
}
