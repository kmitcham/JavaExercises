package com.kevinmitcham.interview;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Snowman {

	int[] subtractManFromBalls(int[] snowballs, Integer[] man){
		ArrayList<Integer> remaining = new ArrayList();
		int head, body, legs;
		head = man[0];
		body = man[1];
		legs = man[2];
		for (int i=0; i < snowballs.length; i++){
			int val = snowballs[i];
			if (val == head){
				head = -1;
			} else if (val == body){
				body = -1;
			} else if (val == legs){
				legs = -1;
			} else {
				remaining.add(val);
			}
		}
		Integer[] foo = new Integer[remaining.size()];
		remaining.toArray(foo);
		return toPrimitive(foo);
	}
	// Convert Integer[] to int[]
	public static int[] toPrimitive(Integer[] IntegerArray) {

		int[] result = new int[IntegerArray.length];
		for (int i = 0; i < IntegerArray.length; i++) {
			result[i] = IntegerArray[i].intValue();
		}
		return result;
	}
	int[] cleanBalls(int[] balls){
		int[] clean = null;
		ArrayList<Integer> listBalls = new ArrayList();
		HashMap<Integer, Integer> counts = new HashMap();
		int size = balls.length;
		int maxMen = size/3;
		int maxOfVal=0, minOfVal=0;
		for (int i =0; i < balls.length; i++){
			int val = balls[i];
			if (counts.get(val) == null){
				counts.put(val, 1);
			} else {
				counts.put(val,  counts.get(val)+1);
			}
		}
		
		
		return clean;
	}
	SnowMen makeAllBestSnowmen(int[] origballs){
		Arrays.sort(origballs);
		Collections.reverse( Arrays.asList(origballs));
		Integer[] snowman = new Integer[3];
		int[] snowballs = origballs;
		if (snowballs.length < 3){
			return null;
		}
		SnowMen bestMen = null;
		double max = 0;
		int head, body, legs;
		int lastHead=-1, lastBody=-1, lastLegs=-1;
		for (int i=0; i < snowballs.length -2; i++){
			head = snowballs[i];
			for (int j=i+1; j < snowballs.length-1; j++){
				body = snowballs[j];
				if (head == body){
					continue;
				}
				for (int k=j+1; k < snowballs.length; k++){
					legs = snowballs[k];
					if (body == legs ){
						continue;
					}
					snowman[0] = head;
					snowman[1]= body;
					snowman[2] = legs;
					int[] remaining = subtractManFromBalls(snowballs, snowman);
					SnowMen others = makeAllBestSnowmen(remaining);
					double total = volume(head, body, legs);
					if (others != null){
						total += others.total;
					}
					
					if (total >= max){
						if (others != null){
							others.snowmen.add(snowman);
							bestMen = others;
						} else {
							bestMen = new SnowMen();
							bestMen.snowmen.add(snowman);
							bestMen.remaining = remaining;
						}
						bestMen.total = total;
						max = total;
					}
				}
			}
		}
		if (max == 0) {
			return null;
		}
		return bestMen;
	}

	int[] makeBestSnowman(int[] snowballs){
		Arrays.sort(snowballs);
		Collections.reverse( Arrays.asList(snowballs));
		int[] snowman = new int[3];
		if (snowballs.length < 3){
			return null;
		}
		double max = 0;
		int head, body, legs;
		for (int i=0; i < snowballs.length -2; i++){
			head = snowballs[i];
			for (int j=i+1; j < snowballs.length-1; j++){
				body = snowballs[j];
				if (head == body){
					continue;
				}
				for (int k=j+1; k < snowballs.length; k++){
					legs = snowballs[k];
					if (body == legs ){
						continue;
					}
					double total = volume(head, body, legs);
					if (total >= max){
						snowman[0] = head;
						snowman[1]= body;
						snowman[2] = legs;
						max = total;
					}
				}
			}
		}
		if (max == 0) {
			return null;
		}
		return snowman;
	}

	double volume(int head, int body, int legs){
		return Math.pow(head,3)+Math.pow(body,3)+Math.pow(legs, 3);
	}
	double actualVolume(int[] snowballs){
	double volume = 0;
	for (int i=0; i < snowballs.length; i++){
		if (snowballs[i] != 0){
			volume +=  ( 4 * Math.PI * Math.pow(snowballs[i],3) / 3 );
		}
	}
	return volume;
	}
	double snowmen(int[] snowballs) {
		SnowMen best = makeAllBestSnowmen(snowballs);
		double volume = 0.0;
		if (best == null){
			return actualVolume(snowballs);
		}
		if (best.remaining != null) {
			volume =actualVolume(best.remaining);
		}
		return volume;
	}

	public class SnowMen{
		ArrayList<Integer[]>snowmen = new ArrayList();;
		int[] remaining;
		double total =0;
		void add(SnowMen men){
			if (men != null){
				this.snowmen.addAll(men.snowmen);
				this.total += men.total;
				this.remaining = men.remaining;  // maybe validate here?  
			}
		}
		public String toString(){
			String s= "T:"+total;
			Iterator<Integer[]> i = snowmen.iterator();
			while (i.hasNext()){
				s+= " "+Arrays.toString(i.next());
			}
			return s;
		}
	}

}
