package com.kevinmitcham.codility;

import java.util.Arrays;

import com.kevinmitcham.lagunita.course.QuickSort.PType;

public class Swapper {

	public boolean solution(int[] A) {
		int[] B = Arrays.copyOf(A,A.length);
		int mismatch = 0;
		Arrays.sort(B);
		for (int i=0; i < A.length; i++){
			if ( B[i] != A[i] ){
				mismatch++;
			}
		}
		if (mismatch <= 2){
			return true;
		}
		return false;
		
	}
	public boolean otherSoluton(int[]A){
		int first = -1;
        int second = -1;
        for (int i=1; i < A.length; i++){
            if ( A[i-1] > A[i] ){
                if (first == -1){
                    first = i;
                } else if (second == -1){
                    second = i;
                } else {
                    return false;
                }
            }
        }
        if ( second == -1 && first == -1){
        	return true;
        }
        if ( first != -1 && second == -1){
        	// just one; find a place for it?
        
        	return true;
        }
        // if we reach here, first AND second are set.
        return canSwap(A, first, second);
    }
	int MIN = -1;
	int MAX = 1001;
	boolean canSwap(int[] A, int first, int second){
        // if we reach here, first AND second are set.
        int fl = (first <= 0)?MIN:A[first-1];
        int fr = (first == A.length-1)?MAX:A[first+1];
        int sl = (second <= 0)?MIN:A[second-1];
        int sr = (second == A.length-1)?MAX:A[second+1];
        if ( fl < A[second] && A[second] < fr  
        		&& sl < A[first] && A[first] < sr ){
        	return true;
        }
        	
        return false;
		
	}
	int swaps = 0;
	void quickSort(int[] a, int start, int end){
		if (start == end ){
			return;
		}
		int partition = start;
		swap(a, start, partition);  // move the partition value into the first positon
		// p: smaller-i|--larger-|j---???? end
		// i is index of leading lesser item; j is first unknown item.
		int i = start;
		for (int j = start+1; j <= end; j++){
			if ( a[j] < a[start] ){
				swap(a,++i,j);
			}
		}
		// should be partitioned here., place the partition element 
		swap(a, start, i);
		if (start < i) {
			quickSort(a, start, i-1);
		}
		if (i < end){
			quickSort(a, i+1, end);
		}
	}
	void swap( int[] a, int start, int stop){
		if (a.length <= start || a.length <= stop || start < 0 || stop < 0){
			System.err.printf("bogus call to swap: start=%d end=%d a.length=%d  ", start, stop, a.length);
			if ( a.length < 8){
				StringBuilder sb = new StringBuilder();
				for (int i=start; i<=stop; i++){
					sb.append(a[i]+", ");
				}
				System.err.println(sb.toString());

			}
			throw new IllegalArgumentException();
		}
		if (start == stop){
			return;
		}
		int tmp = a[start];
		a[start] = a[stop];
		a[stop] = tmp;
	}
}
