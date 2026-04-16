package java_fundamentals.week01;

/**
 * 練習題目：方法 (Method) 的定義與回傳值
 * 任務內容：
 * 1. 定義一個靜態方法 getMax，傳入兩個整數參數
 * 2. 在方法內部判斷哪一個數字較大
 * 3. 將最大值作為回傳值 (Return Value) 送回
 * 4. 在 main 方法中呼叫並測試輸出
 * 
 * @author Takahiro
 * @date 2026/04/16 (提前開始週五進度)
 */
public class MethodPractice {

    public static void main(String[] args) {
        // 在此呼叫 getMax 方法並印出測試結果
        int result = getMax(120, 100);
        System.out.println("最大值為: " + result);
    }

    /**
     * 比較兩個整數並回傳較大者
     * 
     * @param a 第一個整數
     * @param b 第二個整數
     * @return 較大的整數
     */
    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    
}
