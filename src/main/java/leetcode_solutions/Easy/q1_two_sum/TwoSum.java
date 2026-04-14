package leetcode_solutions.Easy.q1_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1 - Two Sum
 * 題目描述：在陣列中找到兩個數，其總和等於目標值 target。
 * 
 * 學習重點：
 * 1. 使用 HashMap 優化搜尋效率（從 O(n^2) 降低到 O(n)）。
 * 2. 練習「一次遍歷（One-pass）」技巧。
 */
public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        // 使用 Map 紀錄「數值」與「索引」的對應
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // 如果補數已經在 Map 中，代表找到了！
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // 否則將目前的數值與索引存入 Map
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("無解");
    }

    // 測試 Main 方法 (您可以在 Eclipse 直接 Run As -> Java Application)
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = solution.twoSum(nums, target);
        
        System.out.println("題目：Two Sum");
        System.out.println("結果：[" + result[0] + ", " + result[1] + "]");
        System.out.println("對應數值：" + nums[result[0]] + " + " + nums[result[1]] + " = " + target);
    }
}
