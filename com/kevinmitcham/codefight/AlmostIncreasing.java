package com.kevinmitcham.codefight;

import java.util.Arrays;

public class AlmostIncreasing {
		int killKthBit(int n, int k) {
			int mask = (int) Math.pow(2,k-1) ;
			int bigMaskA = (int) Math.pow(2, 7);
			int bigMaskB = bigMaskA -1;
			System.out.printf("mask %d bigA %d bigB %d  ", mask, bigMaskA, bigMaskB);
			int combo = bigMaskB ^ mask;
			int result = n & combo;
			System.out.printf(" n %d k %d mask %d  result %d\n", n,k,combo, result);
		  return result; 
		  //return  String digits = Integer.toString(Integer.parseInt(number, 10), 2);

		}
		int bitCount(int x){
		    String digits = Integer.toString(x, 2);
		    int total = 0;
		    for (char c : digits.toCharArray()){
		        if (c == '1'){
		            total++;
		        }
		    }
		    return total;
		}
		/*
		 * int secondRightmostZeroBit(??? n) {
  				return ~( ? | (n+1) ) &  (  ( ?| ( n+1) ) +? ) ;
			}
		 */
		int secondRightmostZeroBit(int n) {
			  return ~(n|(n+1)) & ((n|(n+1))+n) ;
			}
	   public static void main(String args[]) {
		      int a = 60;	/* 60 = 0011 1100 */
		      int b = 13;	/* 13 = 0000 1101 */
		      int c = 0;

		      c = a & b;        /* 12 = 0000 1100 */
		      System.out.println("60 & 13 = " + c );

		      c = a | b;        /* 61 = 0011 1101 */
		      System.out.println("60 | 13 = " + c );

		      c = a ^ b;        /* 49 = 0011 0001 */
		      System.out.println("60 ^ 13 = " + c );

		      c = ~a;           /*-61 = 1100 0011 */
		      System.out.println("~60 = " + c );

		      c = a << 2;       /* 240 = 1111 0000 */
		      System.out.println("a << 2 = " + c );

		      c = a >> 2;       /* 15 = 1111 */
		      System.out.println("a >> 2  = " + c );

		      c = a >>> 2;      /* 15 = 0000 1111 */
		      System.out.println("a >>> 2 = " + c );
		   }
	   
	boolean almostIncreasingSequence(int[] s) {
		int max = -100001,pmax=-100002;
		int fails = 0;
		for (int i:s){
			if ( i > max ){
					pmax= max;
					max = i;
			} else if ( i > pmax ){
				// fail just this number
				fails++;
				max = i;  // discard the fail number
			} else {
				fails++;
				// this means i is less than 2 items in the series.
				// which is actually OK, i could be the bad value.
			}
		}
		
		return fails < 2;
	}
	boolean almostIncreasingSequenceB(int[] s) {
	    int fails = 0;
	    int[] b = Arrays.copyOf(s, s.length);
	    Arrays.sort(b);
	    String m;
	    for (int i=0,j=0; j < b.length && i < s.length; ){
	    	int si = s[i];
	    	int bj = b[j];
	      if (si > bj){
	          System.out.printf(" i=%d j=%d si=%d bj=%d fail advance i\n", i,j,si,bj);
	          fails++;
	          i++;
	      } else if (bj > si){
	          j++;
	      } else {
	    	  i++;j++;
	      }
	    }
	    return  fails <= 1;
	}

}
