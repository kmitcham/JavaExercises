package com.kevinmitcham.lagunita.course;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FindInversions {
	public boolean debug = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//open the file
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("./IntegerArray.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(1);
		}
		try {
			System.out.println("reading file...");
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    ArrayList<Integer> nums = new ArrayList(100000);
		    int counter =0;
		    while (line != null) {
		    	Integer i = Integer.parseInt(line);
		    	nums.add(i);
		    	if (counter++ % 1000 == 0){
		    		System.out.print(".");
		    	}
		    	if (counter % 10000 == 0){
		    		System.out.println(counter+" "+i);
		    	} 
		    	line = br.readLine();
		    }
		    Integer[] a = new Integer[100000];
		    nums.toArray(a);
		    FindInversions fi = new FindInversions();
			System.out.println("Sorting...");
			Results r = fi.countInversions(a, 0, a.length-1);
			System.out.println("inversions = "+r.inversions);
			System.out.printf(" inversions %f", r.inversions);

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
	class Results{
		Integer[] sorted;
		float inversions;
		public String toString(){
			return "i="+inversions+" "+Arrays.toString(sorted);
		}
	}
	void p(String msg){
		if (debug)		System.out.println(msg);
	}
	String pSect(Integer[] nums,  int start, int end ){
		StringBuilder sb = new StringBuilder();
		for (int i=start; i < end; i++){
			sb.append(nums[i]+",");
		}
		sb.append(nums[end]);
		return(sb.toString());
	}
	Results countInversions(Integer[] nums,  int start, int end ){
		Results left, right, combined;
		combined = new Results();
		int n = end - start +1;
		p("n="+n+ " n/2="+n/2+" start="+start+" end="+end+"   "+pSect(nums, start, end));
		if ( n < 0 || start < 0 || end < 0 ){
			p("error case");
			combined.inversions = 0;
			Integer[] fpp = {};
			combined.sorted = fpp;
			return combined;
		}
		if (n == 1){  // just one item
			combined.inversions = 0;
			Integer[] sorted = { nums[start] } ;
			combined.sorted = sorted;
			p("r one:"+combined.toString());
			return combined;
		}
		if (n == 2){			
			if (nums[start] > nums[end]){
				combined.inversions = 1;
				Integer[] sorted = { nums[end] , nums[start]} ;
				combined.sorted = sorted;
			} else {
				combined.inversions = 0;
				Integer[] sorted = { nums[start] , nums[end]} ;
				combined.sorted = sorted;
				
			}
			p("r two:"+combined.toString());
			return combined;
		}
		
		left  = countInversions(nums, start, start+n/2 -1);
		right = countInversions(nums, start+n/2 , end);
		
		combined.inversions = left.inversions+right.inversions;
		if (combined.inversions < 0  || combined.inversions > 10000000000.0 ){
			System.out.printf("Below zero? start=%d  end=%d left="+left.toString()+" right="+right.toString(), start, end);
			System.out.println();
		}
		combined.sorted = new Integer[left.sorted.length + right.sorted.length];
		int i=0, j=0, k=0;
		for (; i < combined.sorted.length  && j < left.sorted.length && k < right.sorted.length; i++){
			if (left.sorted[j] < right.sorted[k] ){
				combined.sorted[i] = left.sorted[j++];
			} else if ( right.sorted[k] < left.sorted[j]){
				combined.sorted[i] = right.sorted[k++];
				combined.inversions += ( left.sorted.length - j);
			} else {
				System.out.printf(" equal numbers?  i=%d j=%d :%d  k=%d %d", i, j, left.sorted[j], k, right.sorted[k]);
			}
		}
		if (j < left.sorted.length){
			for ( ; i < combined.sorted.length; i++ ){
				combined.sorted[i] = left.sorted[j++];
			}
		}
		if (k < right.sorted.length){
			for ( ; i < combined.sorted.length; i++ ){
				combined.sorted[i] = right.sorted[k++];
			}
		}
		
		return combined;
	}
	
}
