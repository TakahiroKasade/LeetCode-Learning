package java_fundamentals.week01;

/**
 * 練習題目：陣列遍歷與奇偶數判斷
 * 任務內容：
 * 1. 宣告並初始化 int[] 陣列
 * 2. 使用 for 迴圈遍歷陣列
 * 3. 判斷數字為偶數或奇數並輸出
 * 
 * @author Takahiro
 * @date 2026/04/16
 */
public class ArrayPractice {

    public static void main(String[] args) {
        // 初始化陣列
        int[] nums = {1, 8, 12, 5, 20, 3};

        // 遍歷陣列並判斷奇偶數
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                System.out.println(nums[i] + " 是偶數");
            } else {
                System.out.println(nums[i] + " 是奇數");
            }
        }
    }
}
