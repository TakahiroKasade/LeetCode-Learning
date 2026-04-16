package leetcode_solutions.Easy;

/**
 * LeetCode #9 - Palindrome Number (迴文整數)
 * 
 * 任務細節：
 * 1. 判斷一個整數 x 是否為迴文（正著讀倒著讀都一樣）。
 * 2. 限制：不可以使用「轉成字串」的做法，必須純用數學邏輯解決。
 * 
 * 實作邏輯：
 * - 排除負數。
 * - 透過 % 10 取尾數，並透過 (result * 10) + digit 的方式翻轉數字。
 * - 最後比對翻轉結果與原數字是否相等。
 * 
 * @author Takahiro
 * @date 2026/04/16
 */
public class Q9_PalindromeNumber {

    /**
     * 判斷整數是否為迴文
     * 
     * @param x 輸入整數
     * @return true 如果是迴文, false 則否
     */
    public boolean isPalindrome(int x) {
        // 1. 負數絕對不可能是迴文
        if (x < 0) {
            return false;
        }

        // 2. 宣告變數儲存原始值與翻轉結果
        int temp = x;
        int reversed = 0;

        // 3. 數學翻轉邏輯 (迴圈將數字一位位取下並重組)
        while (temp > 0) {
            int lastDigit = temp % 10;   
            reversed = (reversed * 10) + lastDigit;
            temp = temp / 10;
        }
        // 流程模擬：假設 x = 121
        // 迴圈第 1 次：lastDigit=1, reversed=1,   temp=12
        // 迴圈第 2 次：lastDigit=2, reversed=12,  temp=1
        // 迴圈第 3 次：lastDigit=1, reversed=121, temp=0

        // 流程模擬：假設 x = 12321
        // 迴圈第 1 次：lastDigit=1, reversed=1,     temp=1232
        // 迴圈第 2 次：lastDigit=2, reversed=12,    temp=123
        // 迴圈第 3 次：lastDigit=3, reversed=123,   temp=12
        // 迴圈第 4 次：lastDigit=2, reversed=1232,  temp=1
        // 迴圈第 5 次：lastDigit=1, reversed=12321, temp=0
        
        // 4. 比對翻轉後的結果是否等於原始輸入
        return reversed == x;
    }

    /**
     * 測試進入點
     */
    public static void main(String[] args) {
        Q9_PalindromeNumber solution = new Q9_PalindromeNumber();
        
        System.out.println("測試 121: " + solution.isPalindrome(121));   // 應為 true
        System.out.println("測試 -121: " + solution.isPalindrome(-121));  // 應為 false
        System.out.println("測試 10: " + solution.isPalindrome(10));    // 應為 false
        System.out.println("測試 12321: " + solution.isPalindrome(12321)); // 應為 true
    }
}
