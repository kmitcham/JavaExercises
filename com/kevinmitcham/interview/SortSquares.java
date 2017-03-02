package com.kevinmitcham.interview;

public class SortSquares {
	boolean debug = false;
	int[] sortedSquaredArray(int[] array) {
	    int[] output = new int[array.length];
	    int neg, pos;
	    int i=0;
	    while ( i < array.length && array[i] < 0 ){
	        array[i] = Math.abs(array[i]);
	        i++;
	    }
	    neg = i-1;
	    pos = i;
	    i = 0;
	    while ( i < output.length){
		    p(" i:"+i+" neg:"+neg+" pos:"+pos);
	        if (neg >= 0  && pos < array.length){
	            if ( array[neg] < array[pos]){
	                output[i] = array[neg] * array[neg];
	                neg--;
	            } else {
	                output[i] = array[pos] * array[pos];
	                pos++;
	            }
	        } else if (neg < 0){
	            output[i] = array[pos] * array[pos];
	            pos++;
	        } else if (pos >= array.length){
	                output[i] = array[neg] * array[neg];
	                neg--;            
	        } else {
	        	p("How you get here?");
	        }
	        
	        i++;
	    }
	    return output;
	}
	void p(String m){
		if (debug)  System.out.println(m);
	}
}
