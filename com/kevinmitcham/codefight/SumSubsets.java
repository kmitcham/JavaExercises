package com.kevinmitcham.codefight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumSubsets {
	int[][] sumSubsets(int[] arr, int num) {
	    ArrayList<ArrayList<Integer>> results;
	    HashMap<String, Integer> uniques = new HashMap();
	    results = matchingSubsets(arr, num, 0);
	    if (results.size() ==0){
	    	return new int[1][0];
	    }
	    for (ArrayList<Integer> set: results){
	    	String id = set.toString();
	    	uniques.put(id, 0);
	    }
	    int[][] asArray = new int[uniques.size()][];
	    int pos = 0;
	    for (int i=0; i < results.size(); i++){
	        ArrayList<Integer> set = results.get(i);
	        int[] asInt= new int[set.size()];
	        for (int j=0; j<set.size(); j++){
	            asInt[j] = set.get(j).intValue();
	        }
	        Arrays.sort(asInt);
	        String id = set.toString();
	        Integer found = new Integer(1);
	        if (!found.equals(uniques.get(id))){
	        	asArray[pos++] = asInt;
	        	uniques.put(id, found);
	        }
	    }
	    
	    return asArray;
	}
	ArrayList<ArrayList<Integer>> matchingSubsets( int []arr, int num, int start){
	    ArrayList<ArrayList<Integer>> local = new ArrayList();
	    for (int i= start; i < arr.length; i++){
	        if (arr[i] > num){
	            return local;
	        }
	        if (arr[i] == num){
	        	ArrayList<Integer> here = new ArrayList<Integer>(1);
	        	here.add(arr[i]);
	        	local.add(here);
	        	return local;
	        }
	        ArrayList<ArrayList<Integer>> following = matchingSubsets(arr, num-arr[i], i+1);
	        if (following != null){
	            for (ArrayList<Integer> set: following){
	                set.add(arr[i]);
	                local.add(set);
	            }
	        }
	    }
	    return local;
	}

}
