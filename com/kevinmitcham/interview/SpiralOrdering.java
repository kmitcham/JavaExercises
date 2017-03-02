package com.kevinmitcham.interview;

public class SpiralOrdering {

	int[] spiralOrder( int[][] input){
		int rowMin = 0, colMin = 0;
		int rowMax = input.length;
		int colMax = input[0].length;
		int[] output = new int [(rowMax*colMax)];
		int index = 0;
		while (rowMin <= rowMax && colMin < colMax){
			p("rowMin="+rowMin+" rowMax="+rowMax+" colMin="+colMin+" colMax="+colMax);
		// assume they are well posed, eg, square.
		// print row[rowMin] from colMin to colMax; rowMin++;
			for (int i=colMin; i < colMax; i++){
				output[index++] = input[rowMin][i];
				p("i="+i+" rowMin="+rowMin+" val="+input[rowMin][i]);
			}
			rowMin++;
			// print column colMax from rowMin to rowMax; colMax--
			for (int i=rowMin; i < rowMax; i++){
				output[index++] = input[i][colMax-1];
			}
			colMax--;
		// print row[rowMax] from colMax to colMin; rowMax--;
			for (int i=colMax-1; i >= colMin; i--){
				output[index++] = input[rowMax-1][i];
			}
			rowMax--;
		// print column colMin from rowMax to rowMin; colMin++;
			for (int i=rowMax-1; i >= rowMin; i--){
				p("i="+i+" rowMax="+rowMax+" colMin="+colMin+" val="+input[i][colMin]);
				output[index++] = input[i][colMin];
			}
			colMin++;
		// 
		}
		
		return output;
	}
	void p(String m){
		System.out.println(m);
	}
}
