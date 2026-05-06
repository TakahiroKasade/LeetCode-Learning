package leetcode_solutions.Easy;

/**
 * 【題目 #141】Linked List Cycle
 * 
 * 【題目說明】
 * 給定一個 Linked List 的 head，判斷裡面是否有環 (Cycle)。
 * 如果兔子 (fast) 和烏龜 (slow) 最後會相遇，代表有環。
 *
 * 【實作思路】
 * 1. 初始化兩個指針，都在 head。
 * 2. 使用 while 迴圈讓兩者賽跑（slow 走一步，fast 走兩步）。
 * 3. 判斷是否相遇或撞牆。
 *
 * @author Takahiro
 * @date 2026-05-05
 */

public class Q141_LinkedListCycle {
	
    public boolean hasCycle(ListNode head) {
        // 1. 如果 head 是空的，或者只有一個節點且沒指向自己，不可能有環
        if (head == null || head.next == null) {
            return false;
        }

        // 2. 初始化快慢指針
        ListNode slow = head;
        ListNode fast = head;
        
        // 3. 實作 while 迴圈賽跑邏輯
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
            		return true;
            }
        }
        
        return false; // 暫時回傳 false
    }



    public static void main(String[] args) {
	    Q141_LinkedListCycle solution = new Q141_LinkedListCycle();
	    // --- 測試案例 1：直線 Linked List (1 -> 2 -> 3 -> null) ---
	    ListNode head1 = new ListNode(1);
	    head1.next = new ListNode(2);
	    head1.next.next = new ListNode(3);
	    System.out.println("測試案例 1 (直線) 結果：" + solution.hasCycle(head1)); // 應該印出 false
	    // --- 測試案例 2：有環的 Linked List (1 -> 2 -> 3 -> 指回 2) ---
	    ListNode head2 = new ListNode(1);
	    ListNode node2 = new ListNode(2);
	    ListNode node3 = new ListNode(3);
	    
	    head2.next = node2;
	    node2.next = node3;
	    node3.next = node2; // 💡 關鍵：這裡把 3 指回了 2，製造出一個無限循環的環！
	    
	    System.out.println("測試案例 2 (有環) 結果：" + solution.hasCycle(head2)); // 應該印出 true
	}
    
}


