package java_fundamentals.week02;

/**
 * 🏥 護理排班津貼計算器 (Shift Credit Parser)
 * 
 * 今日練習目標：
 * 1. 練習字串遍歷與 charAt() 運用。
 * 2. 實作「前瞻邏輯」(Look-ahead)：在處理當前字元時，判斷下一格。
 * 3. 處理數值累加 (double 型別)。
 * 
 * 點數規則：
 * - 'D' (白班): 1.0 點
 * - 'N' (夜班): 2.0 點
 * - 'O' (休假): 0.0 點
 * 
 * 特殊加成規則：
 * - 如果出現 'DN' 序列，則該個 'D' 計為 1.5 點。
 * 
 * 任務：
 * [ ] 實作 calculateCredits 方法。
 * [ ] 在 main 方法中執行測試，確保結果吻合。
 * 
 * @author Takahiro
 * @date 2026/04/20
 */
public class ShiftCalculator {

	/**
	 * 計算整個月班表的總點數
	 * @param s 班表字串 (例如 "DDNODN")
	 * @return 總津貼點數
	 */
	public double calculateCredits(String s) {
		double totalCredits = 0.0;
		int n = s.length();
		
		for (int i = 0; i < n; i++) {
			
			char currentBox = s.charAt(i);
			
			if( currentBox == 'D' &&  i < n-1 && s.charAt(i+1) == 'N') {
				totalCredits = totalCredits + 1.5;
			}else {
				totalCredits = totalCredits + getValue(currentBox);
			}
			
		}
		
		return totalCredits;
	}
	
	private double getValue(char c) {
		switch(c) {
			case  'D' : return 1.0;
			case  'N' : return 2.0;
			case  'O' :  return 0.0;
			default : return 0.0;
		}
		
	}

	public static void main(String[] args) {
		ShiftCalculator calc = new ShiftCalculator();
		
		// 測試案例
		System.out.println("測試案例 1 (DD): " + calc.calculateCredits("DD"));       // 應為 2.0
		System.out.println("測試案例 2 (DN): " + calc.calculateCredits("DN"));       // 應為 3.5 (1.5 + 2.0)
		System.out.println("測試案例 3 (DNO): " + calc.calculateCredits("DNO"));     // 應為 3.5 (1.5 + 2.0 + 0)
		System.out.println("測試案例 4 (DDNODNND): " + calc.calculateCredits("DDNODNND")); 
		// 預期 4: 1.0(D) + 1.5(D) + 2.0(N) + 0(O) + 1.5(D) + 2.0(N) + 2.0(N) + 1.0(D) = 11.0
		
	}

}
