package java_fundamentals.week01;

import java.util.concurrent.ForkJoinPool;

public class SumToHundred {

	/**
	 * 練習題目：計算 1 到 100 之總和
	 * 目的：練習迴圈累加 (Summation) 與變數狀態更新。
	 * 運作邏輯：透過 for 迴圈遍歷 1 至 100，將每個數字累加至 sum 變數中。
	 * @return 最終總和 (預期為 5050)
	 */
	
	public static void main(String[] args) {
		int sum = 0 ; 
		for(int i=1 ; i<=100 ;i++){
			sum = sum + i ;
		}
		System.out.println("總和:"+sum);
	}


}
