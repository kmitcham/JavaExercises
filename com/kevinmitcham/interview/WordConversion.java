package com.kevinmitcham.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordConversion {
	int wordLadderOrig(String beginWord, String endWord, String[] wordList) {
	    ArrayList<String> d = new ArrayList();
	    d.addAll(Arrays.asList(wordList));
	    ArrayList<String> path = new ArrayList();
	    return stepsToConvert(beginWord, endWord, d, path);
	}
	int bestPath = Integer.MAX_VALUE;

	int stepsToConvert(String start, String end, List<String> dictionary, List<String> path){
		List<String> found = getOffByOne(start, dictionary);
		List<String> trimmedDictionary = new ArrayList<String>(dictionary.size());
		trimmedDictionary.addAll(dictionary);
		for (String word: found){
			if (end.equals(word)){
				int steps = path.size();
				if (steps < bestPath){
					bestPath = steps;
				}
				return 1;
			}
			trimmedDictionary.remove(word);
		}
		if (path.size() > bestPath){
			p("Abort for too long path");
			return -1;
		}
		int localBest = Integer.MAX_VALUE;
		for (String word: found){
			path.add(word);
			int result = stepsToConvert(word, end, trimmedDictionary, path);
			path.remove(word);
			if (result != -1){
				if (result < localBest){
					localBest = result+1;
				}
			}
		}
		if (localBest < Integer.MAX_VALUE){
			return localBest;
		}
		return -1;
	}
	List<String> getOffByOne( String word, List<String> dictionary){
		ArrayList<String> list = new ArrayList();
		for (String test: dictionary){
			if ( isOffByOne(word, test) ){
				list.add(test);
			}
		}
		return list;
	}
	boolean isOffByOne(String word, String test){
		boolean oneOff = false;
		char[] wc = word.toCharArray();
		char[] tc = test.toCharArray();
		checks++;
		for (int i=0; i < wc.length; i++){
			if (wc[i] != tc[i]){
				if (oneOff){
					return false;
				}
				oneOff = true;
			}
		}
		return oneOff;
	}
	boolean debug = false;
	int checks = 0;
	void p(String m){
		if (debug)
		System.out.println(m);
	}
	int wordLadder(String beginWord, String endWord, String[] wordList) {
	    ArrayList<String> d = new ArrayList();
	    d.addAll(Arrays.asList(wordList));
	    HashMap<String, Integer> distances = new HashMap(wordList.length);
	    distances.put(beginWord, 0);
	    int mapped = -1;
	    int level = 0;
	    while (!d.isEmpty() && mapped != 0 ){
	    	mapped = mapWords(d, level++, distances);
	    }
	    Integer distance = distances.get(endWord);
	    if (distance != null) return distance+1;
	    return 0;
	}
	
	int mapWords( List<String> dictionary, int level, HashMap<String, Integer> map){
		Set<String> wordsForLevel = new HashSet();
		Set<String> allKeys = map.keySet();
		int mapped = 0;
		for (String word: allKeys){
			Integer distance = map.get(word);
			if (distance != null && distance == level){
				wordsForLevel.add(word);
			}			
		}
		for (String word: wordsForLevel){
			p("adding words for "+word+": ");
			List<String> found = getOffByOne(word, dictionary);
			for (String next: found){
				System.out.print(next+" ");
				map.put(next,level+1);
				dictionary.remove(next);
				mapped++;
			}
		}
		p("");
		return mapped;
	}
}	
