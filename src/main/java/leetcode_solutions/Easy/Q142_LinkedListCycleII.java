package leetcode_solutions.Easy;

/**
 * 【題目 #142】Linked List Cycle II
 * 
 * 【任務】
 * 找出環的起點。如果沒有環，回傳 null。
 *
 * 【實作步驟】
 * 1. 判斷是否有環（使用 #141 的快慢指針）。
 * 2. 如果相遇，將 slow 移回 head，fast 留在相遇點。
 * 3. 兩者同時各走一步 (slow = slow.next; fast = fast.next;)。
 * 4. 再次相遇的地點就是環的起點。
 *
 * @author Takahiro
 * @date 2026-05-06
 */
public class Q142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 第一階段：尋找相遇點
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break; // 找到相遇點，跳出迴圈
            }
        }

        // 第二、三階段：尋找環的入口
        if (hasCycle) {
            // 1. 把其中一個指針移回 head
            slow = head;
            
            // 2. 兩者同時各走一步，直到再次相遇
            while (slow != fast) { 
                slow = slow.next;
                fast = fast.next;
            }
            
            // 3. 回傳相遇的節點    
            return slow;
        }

        return null; // 如果沒有環，回傳 null
    }

    public static void main(String[] args) {
        Q142_LinkedListCycleII solution = new Q142_LinkedListCycleII();

        // --- 建立測試案例：1 -> 2 -> 3 -> 4，然後 4 指回 2 ---
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 💡 製造環，入口在 2

        ListNode result = solution.detectCycle(node1);

        if (result != null) {
            System.out.println("✅ 找到環了！入口節點的值是：" + result.val);
        } else {
            System.out.println("❌ 沒有找到環。");
        }
    }
}

