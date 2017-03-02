package com.kevinmitcham.lagunita.course;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
	public static enum PType  { first, last, median };
	int comparisons,depth=0;
	boolean debug = false;
	void p(String m){
		if (debug)
			System.out.println(m);
	}
	
	int choosePartition(int[] a, int start, int stop, PType type){
		int partition = -1;
		switch (type){
			case first: 
				partition = start;
				break;
			case last:
				partition = stop;
				break;
			case median:
				int x = a[start];
				int y = a[stop];
				int z = a[  start + (stop - start)/2];
				if (( x >= y && y >= z )  || ( z >= y && y >= x)){
					partition = stop;
				} else if (( y >=x && x >= z )  || ( z >= x && x >= y)){
					partition = start;
				} else if (( x >= z && z >= y )  || ( y >= z && z >= x)){
					partition = start + (stop - start)/2 ;
				} else {
					System.err.printf("fall through on median %d - %d", start, stop);
					System.err.println(Arrays.toString(a));
					partition = start;
				}
				break;
			default:
				partition = a[start];
				System.out.println("fall through in partion for type "+type+" start:"+start);
		}
		return partition;
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
		//p("swapping "+a[start]+" for "+a[stop]);
		int tmp = a[start];
		a[start] = a[stop];
		a[stop] = tmp;
	}
	
	void quickSort(int[] a, int start, int end, PType type){
		depth++;
		String f = String.format("start:a[%d]=%d  end:a[%d]=%d  comparisons=%d depth=%d", 
				start, a[start], end, a[end], comparisons, depth);
		p(f);
		if (start == 6){
			p("in the problem");
		}
		if (start == end ){
			//System.out.print("-");
			depth--;
			return;
		}
		comparisons += (end - start);
		if ( (start+1 == end) && false){  // lecture doesn't do this
			if ( a[start] > a[end]){
				swap(a, start, end);
			}
			//System.out.print(".");
			depth--;
			return;
		}
		if ( depth > 1000 ){
			System.out.println(">>too deep:");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(f);
			StringBuilder sb = new StringBuilder("range=");
			for (int i=start; i <= end && i < a.length; i++){
				sb.append(a[i]+", ");
			}
			System.out.println(sb.toString());
			depth--;
			return ;
		}
		// base case
		if (start > end ){
			System.out.println("Flipped:"+f);
			depth--;
			return;
		}
		// recursive case
		// sort into partitions, call on each partition
		int partition = choosePartition(a, start, end, type);
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
		p("new partitions "+start+"--"+(i-1)+"-p-"+(i+1)+"--"+end+ " "+Arrays.toString(a));
		if (start < i) {
			quickSort(a, start, i-1, type);
		}
		if (i < end){
			quickSort(a, i+1, end, type);
		}
		depth--;
	}
	int isSorted(int[] a){
		for (int i=0; i < a.length-1; i++){
			if (a[i] > a[i+1]){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open the file
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("/Users/kevinmitcham/Documents/workspace/Java1.8/bin/QuickSort.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(1);
		}
		try {
			System.out.println("reading file...");
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    ArrayList<Integer> nums = new ArrayList(10000);
		    int[] b= new int[10000];
		    int counter =0;
		    while (line != null) {
		    	Integer x = Integer.parseInt(line);
		    	nums.add(x);
		    	b[counter] = x;
		    	if (counter++ % 100 == 0){
		    		System.out.print(".");
		    	}
		    	if (counter % 1000 == 0){
		    		System.out.println(counter+" "+x);
		    	} 
		    	line = br.readLine();
		    }
		    int[] a = Arrays.copyOf(b, b.length);
		    QuickSort qs = new QuickSort();
			System.out.println("Sorting by first...");
			qs.quickSort(a, 0, a.length-1,  QuickSort.PType.first);
			if ( qs.isSorted(a) != -1){
				System.out.println("first sorting failed" );
			}
			System.out.println(" comparisons = "+qs.comparisons);
			qs = new QuickSort();
			a = Arrays.copyOf(b, b.length);
			System.out.println("Sorting by median...");
			try {
			qs.quickSort(a, 0, a.length-1,  QuickSort.PType.median);
			} catch (Exception e){
				System.out.printf("failed, but qs.depth was %d \n", qs.depth);
				e.printStackTrace(System.out);				
			}
			if ( qs.isSorted(a) != -1){
				System.out.println("median sorting failed" );
			}
			System.out.println(" comparisons = "+qs.comparisons);

			qs = new QuickSort();
			a = Arrays.copyOf(b, b.length);
			System.out.println("Sorting by last...");
			try {
				qs.quickSort(a, 0, a.length-1,  QuickSort.PType.last);
			} catch (Exception e){
				System.out.printf("failed, but qs.depth was %d \n", qs.depth);
				e.printStackTrace(System.out);
			}
			if ( qs.isSorted(a) != -1){
				System.out.println("last sorting failed" );
			}
			System.out.println(" comparisons = "+qs.comparisons);
		} catch (Exception e1){
			e1.printStackTrace();
			
		} finally{
			if (br != null){
				try{
					br.close();
				} catch (Exception e1){
					e1.printStackTrace();
					
				}
			}
		}
		System.out.println("Complete");

	}
}
/*		int j = start+1;
		int i = start;
		if (a[j] < a[start] ){
			i++; j++;
		}  else {
			j++;
		}
		for (; j <= end; ){
			if (a[j] <= a[start] ){
				swap(a, i+1, j);
				i++; j++;
			} else if ( a[j] > a[start]){
				j++;
			}
		}

 */
