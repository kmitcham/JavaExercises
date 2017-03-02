package com.kevinmitcham.interview;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class LruCache {
	HashMap<String, Element> hash;
	Element fresh, stale;
	int size;
	public static String NOTFOUND = "NOTFOUND";
	class Element {
		String key, value;
		Element fresher, staler;
		Element(String key, String value){
			this.key = key;
			this.value =value;
		}
		boolean spliceOut(){
			System.out.println(" removing "+this);
			if (fresher != null ){
				fresher.staler = staler;
			}
			if (staler != null){
				staler.fresher = fresher;
			}
			return true;
		}
		public String toString(){
			return key+":"+value+((staler!=null && staler != this)?"->"+staler:"");
		}
	}
	LruCache(int size){
		hash = new HashMap<String,Element>(size+1);
		this.size = size;
	}
	Element put(String key, String value){
		Element e = new Element(key, value);
		hash.put(key,e);
		if (stale == null){
			stale = e;
		}
		if (fresh == null){
			fresh = e;
		} else {
			e.staler = fresh;
			fresh.fresher = e;
			fresh = e;
		}

		while (hash.size() >= size){
			hash.remove(stale.key);			
			stale = stale.fresher;
			stale.staler = null;
		}
		return e;
	}
	String get(String key){
		Element e = hash.get(key);
		if (e == null){
			return "NOTFOUND";
		}
		e.spliceOut();
		e.staler = fresh;
		fresh = e;
		return e.value;
	}
	

}

	