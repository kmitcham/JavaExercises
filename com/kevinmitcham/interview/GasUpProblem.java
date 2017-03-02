package com.kevinmitcham.interview;
import java.util.Iterator;
import java.util.List;

public class GasUpProblem {

	public static final int MPG = 20;
	// if I know there IS an ample city
	int smartFindAmple(List<City> cities){
		int totalGas =0;
		// for each city, add the net to the total
		// if net < 0, start fresh with current city as ample target.
		int ampleIndex = 0;
		for (int i=0; i < cities.size(); i++){
			City current = cities.get(i);
			int net = current.gas - (current.miles/MPG);
			totalGas += net;
			if (totalGas < 0){
				ampleIndex  = -1;
				totalGas = 0;
			}
			if (ampleIndex == -1){
				ampleIndex = i+1;
			}
		}
		return ampleIndex;
	}
	
	City findAmple(List<City> cities){
		// for each city in the list, see if it is ample
		Iterator<City> i = cities.iterator();
		int count = 0;
		int maxCount = 1000;
		while (i.hasNext() && count < maxCount){ // trusting the input
			City city = i.next();
			count++;
			if (isAmple(city)){
				return city;
			}
		}
		return null;
	}
	// This is O(n)
	boolean isAmple(City city){
		City current = city, next = null;
		int totalGas = 0;
		while (city != current){
			next =current.nextCity;
			totalGas += current.gas;
			totalGas -= ( current.miles/MPG);
			if (totalGas <= 0){
				return false;
			}
			current = next;
		}
		return true;
	}
}
