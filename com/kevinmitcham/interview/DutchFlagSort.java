package com.kevinmitcham.interview;
import java.util.Arrays;

public class DutchFlagSort {
	public static int[] sort(int[] a, int pivot){
		// sort the array into  x< a, x=a, a< x bands
		// from the left, find a too big item.  
		//     from the right, search for a too-small item.
		if (pivot > a.length){
			return a;
		}
		int left = 0;
		int right = a.length-1;
		int pivotVal = a[pivot];
		for ( left=0; left < right; ){
			if (a[left] < pivotVal){
			} else if (a[left] >= pivotVal){
				right = getIndexOfNextSmall(a, pivotVal, right);
				swap(a, left, right);
			}
			left++;
		}
		for ( left=0, right=a.length-1; left < right; ){
			if (a[right] > pivotVal){
			} else if (a[right] <= pivotVal){
				right = getIndexOfNextLarge(a, pivotVal, right);
				swap(a, left, right);
			}
			left++;
		}
		Arrays.sort(a);
		return a;
	}
	static int getIndexOfNextSmall(int[] a, int pivotVal, int startIndex){
		for (int i = startIndex; i >= 0; i--){
			if (a[i] < pivotVal ){
				return i;
			}
		}
		return 0;
	}
	static int getIndexOfNextLarge(int[] a, int pivotVal, int startIndex){
		for (int i = startIndex; i < a.length; i++){
			if (a[i] > pivotVal ){
				return i;
			}
		}
		return 0;
	}
	static int[] swap(int[] array, int i, int j){
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
		return array;
	}
}

