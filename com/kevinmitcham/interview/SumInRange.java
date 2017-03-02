package com.kevinmitcham.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SumInRange {
	
	int visiblePoints(int[][] points) {
	    double[] thetas = new double[points.length];
	    for (int i=0; i < points.length; i++){
	    	thetas[i] = theta(points[i][0], points[i][1]);
	    }
	   Arrays.sort(thetas);
	    int max = 0;
	    for (int i = 1; i < points.length; i++){
	    	if (thetas[i] > thetas[0] + Math.PI/4) {
	    		break;
	    	}
	    	max++;
	    }
	    int start = 0;
	    int end = max;
	    for (;  end < points.length; end++){
	    	// if end is w/in 45 of start, increase end
	    	if ( thetas[end] < ( thetas[start] + Math.PI/4 ) ) {
	    		end++;
	    	} else {
	    		start++;
	    	}
	    	if ( end - start > max){
	    		System.out.printf("updating max %d at theta %f start %d  end %d\n", max, thetas[start], start, end);
	    		max = end - start;
	    	}	    	
	    }
	    
	    return max;
	}
	Double theta(int x, int y){
double theta =  Math.atan(y/x);
System.out.printf( "x=%d y=%d theta = %f\n", x,y, theta);
	    return theta;
	}

	
	
	boolean debug = false;
	HashMap<String, Double> cache = new HashMap();
	int sumInRange(int[] nums, int[][] queries) {
		int[] times = new int[nums.length];
		for (int i=0; i < times.length; i++){
			times[i] = 0;
		}
		double total = 0;
		for (int i=0; i < queries.length; i++){
			for (int k = queries[i][0]; k <= queries[i][1]; k++){
				times[k]++;
			}
		}
		for (int i=0; i < times.length; i++){
			total += times[i] * nums[i];
		}
		int foo = (int) (total % ( 1000000000+7));
		return foo;
	}
	int sumInRangeA(int[] nums, int[][] queries) {
		Double total =0.0;
		double weird =1000000000+7 ;
		int knownStart =nums.length/2, knownEnd=nums.length/2;
		double knownTotal = nums[nums.length/2];
		for (int i=0; i < queries.length; i++){
			int first = queries[i][0];
			int last = queries[i][1];
			if (cache.get(first+":"+last) != null){
				total += cache.get(first+":"+last);
			} else {
				double qTotal = 0;
				if (knownStart >= first && knownEnd <= last && !false){
					// we are recomputing stuff
					if (debug)	System.out.format(" Recomputing for %d:%d  known %d:%d\n", first, last, knownStart, knownEnd);            
					for (int k = first; k < knownStart; k++){
						qTotal += nums[k];
					}
					knownStart = first;
					qTotal += knownTotal;
					for (int k = knownEnd+1; k <= last; k++){
						qTotal += nums[k];
					}
					knownEnd = last;
					total+= qTotal;
					knownTotal = qTotal;
				}  else {
					for (int k = first; k <= last; k++){
						qTotal += nums[k];
					}
					total += qTotal;
				}
				cache.put(first+":"+last, qTotal);
			}
		}
		System.out.println("total is "+total+
				" weird is "+weird+
				" sum is "+(weird + total) );
		total = total % (weird);
		if (total >= 0){
			return total.intValue();
		} else {
			Double foo = weird+total;
			return foo.intValue();
		}
	}

}
