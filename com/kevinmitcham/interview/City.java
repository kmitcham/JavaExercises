package com.kevinmitcham.interview;
class City{
		City nextCity;
		City previousCity;
		int gas;
		int miles;
		int DEFAULT = 30;
		City(int net){
			if (net >= 30){
				System.out.println("max net is 30");
			}
			this.gas = net+DEFAULT;
			this.miles = DEFAULT * GasUpProblem.MPG;
		}
		City (int gas, int miles){
			this.gas = gas;
			this.miles = miles;
		}
	}