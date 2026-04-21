package leetcode_solutions.Easy;

import java.util.Stack;

/**
 * LeetCode #155 - Min Stack (最小棧)
 * 
 * 任務描述：
 * 設計一個堆疊，支援 push, pop, top 操作，並能在 O(1) 時間內檢索到最小元素。
 * 
 * 解題思路：
 * 1. 使用兩個 Stack：一個存放所有資料 (dataStack)，另一個同步存放目前的最小值 (minStack)。
 * 2. 封裝：將這兩個 Stack 隱藏在 MinStack 類別內部，對外只提供指定的介面。
 * 
 * @author Takahiro
 * @date 2026/04/21 (提前執行 4/22 計畫)
 */
public class Q155_MinStack {

    /**
     * 注意：LeetCode 官方要求類別名稱為 MinStack
     * 我們在本地端練習使用 Q155_MinStack 作為封裝
     */
    static class MinStack {
        // 在這裡宣告你的 Stack (提示：需要兩個)
        
        /**
         * 初始化 MinStack
         */
        public MinStack() {
            // 建構子：在這裡 new 出你的 Stack
        }
        
        public void push(int val) {
            // 邏輯：dataStack 直接放；minStack 要判斷 (新值是否比目前最小值小？)
        }
        
        public void pop() {
            // 邏輯：兩邊都要同步移出
        }
        
        public int top() {
            // 邏輯：回傳 dataStack 的最頂端
            return 0;
        }
        
        public int getMin() {
            // 邏輯：直接看 minStack 的最頂端
            return 0;
        }
    }

    public static void main(String[] args) {
        // 在這裡撰寫測試案例
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("目前最小值 (預期 -3): " + minStack.getMin()); 
        minStack.pop();
        System.out.println("Top 元素 (預期 0): " + minStack.top());    
        System.out.println("目前最小值 (預期 -2): " + minStack.getMin()); 
    }
}
