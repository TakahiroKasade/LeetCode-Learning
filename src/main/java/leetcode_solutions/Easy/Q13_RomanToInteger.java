package leetcode_solutions.Easy;

/**
 * LeetCode #13: Roman to Integer
 * 
 * @author Takahiro
 * @date 2026/04/20
 */
public class Q13_RomanToInteger {

	/**
	 * 【核心邏輯】將羅馬數字字串轉換為整數
	 * 
	 * 拆解思路：從左往右讀取，並觀察「右邊鄰居」的值。
	 * 如果我是小個子 (現在值 < 右邊值)，那我就變成負的。
	 * 
	 * @param s 羅馬數字字串 (例如: "MCMXCIV")
	 * @return 轉換後的整數總和
	 */
	public int romanToInt(String s) {
		int ans = 0;        // 用來存放最終累加結果的「籃子」
		int n = s.length(); // 取得字串總長度

		for (int i = 0; i < n; i++) {
			// [步驟 1] 取得當前位置 (i) 的數值
			int nowVal = getValue(s.charAt(i));

			// [步驟 2] 邊界檢查：判斷右邊是否還有鄰居？
			if (i < n - 1) {
				// [步驟 3] 預看右邊鄰居 (i+1) 的數值
				int nextVal = getValue(s.charAt(i + 1));

				// [步驟 4] 套用羅馬數字規則：
				// 若「現在 < 右邊」 (例如: IV, IX)，則減去當前值
				if (nowVal < nextVal) {
					ans -= nowVal;
				} else {
					// 否則，正常相加
					ans += nowVal;
				}
			} else {
				// [步驟 5] 如果已經是最後一個字元，背後沒人了，直接加上去即可
				ans += nowVal;
			}
		}

		return ans;
	}

	/**
	 * 輔助方法：將單個羅馬字元轉換為對應數值
	 */
	private int getValue(char c) {
		switch (c) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

	public static void main(String[] args) {
		Q13_RomanToInteger solution = new Q13_RomanToInteger();
		
		// 測試案例
		System.out.println("III -> " + solution.romanToInt("III"));      // 應為 3
		System.out.println("IV -> " + solution.romanToInt("IV"));        // 應為 4
		System.out.println("IX -> " + solution.romanToInt("IX"));        // 應為 9
		System.out.println("LVIII -> " + solution.romanToInt("LVIII"));  // 應為 58
		System.out.println("MCMXCIV -> " + solution.romanToInt("MCMXCIV")); // 應為 1994
	}
}
