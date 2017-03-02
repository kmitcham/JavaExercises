package com.kevinmitcham.codefight;

import java.util.ArrayList;

public class StringPermutations {
	String[] stringPermutations(String s) {
		ArrayList<String> allResults = new ArrayList();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < s.length(); i++){
			sb.append("_");
		}
		allResults = subPermutations(s, sb.toString());
		
	    return null;
	}
	ArrayList<String> subPermutations(String otherItems, String base ){
	    // base is a string with 0 or more _ fields.ArrayList
	    // for every unique character in otherItems, replace first _ with every item
	    //  and recurse
	    //  
	    ArrayList<String> result = new ArrayList();
	    int first =base.indexOf("_");
	    if ( first == -1){
	        result.add(base);
	        return result;
	    }
	    for (int i=0; i< otherItems.length(); i++ ){
	    	String remaining = otherItems.substring(0, i) + otherItems.substring(i+1, otherItems.length());
	    	String updated = base.replaceFirst("_", otherItems.charAt(i)+"");
	    	ArrayList<String>  subResults = subPermutations(remaining, updated);
	    	result.addAll(subResults);
	    }
	    return result;
	    
	}
}
