package leetcode_solutions.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1 - Two Sum
 * 
 * 任務細節：
 * 1. 在陣列中找出兩個數，其總和等於目標值 target。
 * 2. 包含暴力解 (O(n^2)) 與 HashMap 優化解 (O(n)) 作為對比。
 * 
 * @author Takahiro
 * @date 2026/04/16
 */
public class Q1_TwoSum {

    /**
     * 解法一：暴力法 (Brute Force)
     * 時間複雜度：O(n^2)
     * 空間複雜度：O(1)
     */
    public int[] bruteForceTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("無解");
    }

    /**
     * 解法二：HashMap 優化解 (O(n)) - 推薦
     * 時間複雜度：O(n)
     * 空間複雜度：O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        // 使用 HashMap 紀錄「數值」與「索引」的對應 (Key: 數值, Value: 索引)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 計算當前數字需要的「補數」
            int complement = target - nums[i];

            // 檢查補數是否已经在牆上（Map）了
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // 如果沒找到，就將目前的自己的數字與索引登記在牆上
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("無解");
    }

    /**
     * 測試進入點
     */
    public static void main(String[] args) {
        Q1_TwoSum solution = new Q1_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 26;

        // 測試 HashMap 解法
        int[] result = solution.twoSum(nums, target);

        System.out.println("題目：Two Sum");
        System.out.println("結果索引：[" + result[0] + ", " + result[1] + "]");
        System.out.println("對應數值：" + nums[result[0]] + " + " + nums[result[1]] + " = " + target);
    }
}
