package com.kevinmitcham.interview;

import java.util.Arrays;
import java.util.HashMap;

public class LevelCounter {
	int treeLevelSum(String tree, int k) {
	    int level=-1, total=0;
	    HashMap<Integer, Integer> levelTotals = new HashMap<Integer, Integer>();
	    char[] asChar = tree.toCharArray();
	    for (int i=0; i < asChar.length; i++){
	    	if ( '(' == asChar[i] || ')' == asChar[i]){
	    		if (levelTotals.get(level) == null){
	    			levelTotals.put(level, total);
	    		} else {
	    			levelTotals.put(level, total+levelTotals.get(level));
	    		}
	    		total = 0;
	    	}
	    	if ('(' == asChar[i] ){
	    		level++;
	    	} else if (')' == asChar[i]){
	    		level--;
	    	} else {
	    		try {
	    			int bit = Integer.parseInt(""+asChar[i]) ;
	    			total = total*10 + bit;
	    		} catch (Exception e){
	    			
	    		}
	    	}
	    }
	    return levelTotals.get(k);
	}
	boolean tripletSum(int x, int[] a) {
	    Arrays.sort(a);
	    int t1, t2;
	    FIRST: for (int i=0; i < a.length-2; i++){
	        t1 = a[i];
	        if (a[i] >= x){
	            return false;
	        }
	        SECOND: for (int j=i+1; j < a.length-1; j++){
	            if (a[i]+a[j] >= x){
	                continue FIRST;
	            }
	            t2 = x - a[i]-a[j];
	            if ( contains(t2, j+1,a)){
	            	return true;
	            }
	            
	        }
	    }
	    return false;
	}
	boolean contains(int x,int start, int[] a ){
		for (int i=start; i < a.length; i++){
			if (x == a[i]){
				return true;
			}
			if (x < a[i]){
				return false;
			}
		}
		return false;
	}

}
