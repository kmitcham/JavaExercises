package com.kevinmitcham.codility;

public class DemoTest {
	public int solution(int[] A) {
        // write your code in Java SE 8
		double sum = 0;
        double right,left;
        if (A.length ==1 ){
        	return 0;
        }
        double[] totals = new double[A.length+1];
        totals[0] = 0;
        for (int i=0; i < A.length; i++){
        	sum += A[i];            
        	totals[i+1] = sum;
            
        }
        double max = totals[totals.length-1];
        for (int i=0; i < totals.length-1; i++){
        	right = ( max - totals[i+1] ) ;
        	left = totals[i];
        	if (left == right){
        		return i;
        	}
        }
        return -1;
    }
}
