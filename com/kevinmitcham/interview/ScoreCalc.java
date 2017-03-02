package com.kevinmitcham.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ScoreCalc {
	int count =0;
	int countB = 0;
	HashMap<String, ArrayList<ArrayList<Integer>>> cache = new HashMap();
	
	int numberOfCombos(int score, int[] plays){
		ArrayList<ArrayList<Integer>> combos = findCombos(score, plays);

		if (combos == null){
			return 0;
		}
		for (ArrayList<Integer> foo: combos){
			if (foo.size() == 5){
				System.out.println(" --> 5:" + foo.toString());
			}
		}		System.out.println("For score "+score+" and "+plays.length+" plays, count is "+count);
		return combos.size();
	}
	ArrayList<ArrayList<Integer>> findCombos(int score, int[] plays){
		ArrayList<Integer> soFar = new ArrayList<Integer>();
		return findCombosRecursive(score, plays, soFar, plays.length-1 );
	}
	ArrayList<ArrayList<Integer>> findCombosRecursive(int score, int[] plays, ArrayList<Integer> soFar, int maxIndex){
		String key = score+" "+Arrays.toString(plays)+" "+maxIndex;
		if (cache.get(key) != null){
			//System.out.println("Cache hit for "+key);
			return cache.get(key);
		}
		Arrays.sort(plays);
		ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
		for (int i=maxIndex; i >= 0; i--){
			count++;
			ArrayList<Integer> thisSolution = (ArrayList<Integer>) soFar.clone();
			if (plays[i] > score){
				continue;
			}
			thisSolution.add(plays[i]);
			if ((score - plays[i] == 0)){
				solutions.add(thisSolution);
			} else {
				ArrayList<ArrayList<Integer>> partialSolutions = 
						findCombosRecursive(score - plays[i], plays, thisSolution, i);
				if (partialSolutions == null){
					continue;
				}
				Iterator<ArrayList<Integer>> vals = partialSolutions.iterator();
				while (vals.hasNext()){
					ArrayList<Integer> part = vals.next();
					if (part != null){
						solutions.add(part);
					}
				}
			}						
		}		
		//System.out.println("Cache put for "+key);
		cache.put(key, solutions);
		return solutions;
	}
	int[][] numPlaysForScore ;
	ArrayList<ArrayList<Integer>> findCombosDynamic(int score, int[] plays, ArrayList<Integer> soFar, int maxIndex){
		numPlaysForScore= new int[score][plays.length];
		
		return null;
	}
	boolean canCountThree(int target, int[] parts){
		Arrays.sort(parts);
		countB = 0;
		if (parts[parts.length-1] * 3 < target) return false;
		if (parts[0] * 3 > target) return false;
		/*
		 * 3*min---+--------------min+min+max-----+----max+max+min---------+-3*max
		 *       min+2items                  min+max+1 item    max+2 items
		 */
		int min = parts[0];
		int max = parts[parts.length-1];
		boolean result = false;
		if ( max * 3 < target){
			result =  false;
		} else if (max +max+max == target){
			result =  true;
		} else if (max + max  < target) {
			result =  canCountTwo((target - max), parts);
		} else if ( (max + min +min ) == target ){
			result =  true;
		} else if ( (max + min +min ) > target  ){
			result =  canCountTwo(target-min, parts);
		} else if ( min+min+min > target){
			result =  false;
		}
		System.out.println(target+" result "+result+" CountB is "+countB);
		return result;
	}
	boolean canCountTwo(int target, int[] parts){
		int minIndex = 0;
		int maxIndex = parts.length-1;
		if (parts[maxIndex] * 2 < target) return false;
		if (parts[minIndex] * 2 > target) return false;
		do {
			if (parts[minIndex] + parts[maxIndex] == target) return true;
			if (parts[minIndex] + parts[maxIndex] > target){
				maxIndex--;
			} else {
				minIndex++;
			}
			countB++;
		} while (minIndex != maxIndex);
		if (parts[maxIndex] * 2 == target) return true;
		return false;
	}
	
	
}
