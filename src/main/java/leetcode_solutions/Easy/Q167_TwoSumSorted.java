package leetcode_solutions.Easy;

/**
 * LeetCode #167 - Two Sum II - Input array is sorted
 * 題目描述：給定一個已排序的整數陣列 numbers 和一個整數 target，
 * 請你找出兩個數字，使它們的和等於 target。回傳索引值 (1-based)。
 * 
 * 學習重點：
 * 1. 雙指針 (Two Pointers) 技巧。
 * 2. 空間複雜度優化至 O(1)。
 */
public class Q167_TwoSumSorted {

    public static void main(String[] args) {
        // 需要的變數 left right target sum
        int[] nums = {2, 7, 8, 15};
        int target = 15;
        int left = 0;
        int right = nums.length - 1;
        int sum;

        while (left < right) {
            sum = nums[left] + nums[right];

            if (sum == target) {
                // 題目要求 1-based index，所以要 +1
                System.out.println("題目：Two Sum II (Sorted Array)");
                System.out.println("結果：[" + (left + 1) + "," + (right + 1) + "]");
                System.out.println("對應數值：" + nums[left] + " + " + nums[right] + " = " + target);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
