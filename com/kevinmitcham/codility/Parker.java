package com.kevinmitcham.codility;

public class Parker {
    public int solution(String E, String L) {
        // write your code in Java SE 8
    	int total = 5;
    	int enter = convertTime(E);
    	int leave = convertTime(L);
    	int duration = leave - enter - 60; // already charged the first hour
    	while (duration > 0){
    		total += 4;
    		duration -= 60;
    	}
    	return total;
    }
    int convertTime(String time){
    	String h = time.substring(0,2);
    	String m = time.substring(3);
    	int hours = Integer.parseInt(h);
    	int minutes = Integer.parseInt(m);
    	return hours*60 + minutes;
    }
}
