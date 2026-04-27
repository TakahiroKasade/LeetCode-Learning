package leetcode_solutions.Easy;

import java.util.Arrays;

/**
 * <h3>LeetCode #167 - Two Sum II (Refactor Practice)</h3>
 * 
 * <p><strong>題目描述：</strong><br>
 * 給定一個已排序的整數陣列 <code>numbers</code> 和一個整數 <code>target</code>，
 * 請找出兩個數字使它們的和等於 target。回傳這兩個數字的索引值 (1-based)。</p>
 * 
 * <p><strong>實作任務：</strong></p>
 * <ul>
 *   <li>1. 實作 <code>twoSum</code> 方法，使用雙指針技巧。</li>
 *   <li>2. 處理 1-based index 的轉換邏輯。</li>
 *   <li>3. 在 <code>main</code> 方法中測試多組測資（例如：{2, 7, 11, 15}, target=9）。</li>
 * </ul>
 * 
 * @author Takahiro
 * @date 2026/04/27
 */
public class Q167_TwoSumSorted_Refactor {

    public static void main(String[] args) {
        int[] nums = {2, 2, 7, 15};
        int target = 9;

        // 呼叫你的方法
        int[] result = twoSum(nums, target);

        // 印出結果驗證
        System.out.println("測試陣列: " + Arrays.toString(nums));
        System.out.println("目標值: " + target);
        System.out.println("結果索引: " + Arrays.toString(result));
    }

    /**
     * 使用雙指針法尋找目標和
     * 
     * @param numbers 已排序的陣列
     * @param target  目標和
     * @return 包含兩個 1-based 索引的 int 陣列；若未找到則回傳 {-1, -1}
     */
   public static int[] twoSum(int[] numbers, int target) {
        // 1. 初始化 left 和 right 指針
            int left = 0 ;
            int right = numbers.length - 1 ;
        // 2. 開始 while 迴圈
        while( left < right) {
	        	// 3. 判斷 sum == target 的情況，並用 return 把答案傳回去
	        	int sum = numbers[left] + numbers[right];
	        	if (sum==target){
	        		  return new int[] {left + 1, right + 1};
			}else if(sum<target) {
	            left ++ ;
	        }else {
	            right -- ; 
	        }               
        }
        // 4. 如果沒找到，回傳預設值
        return new int[] {-1, -1};
    }

}
