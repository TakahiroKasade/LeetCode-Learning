package leetcode_solutions.Easy;

/**
 * LeetCode #206: Reverse Linked List (反轉鏈結串列)
 * 
 * 解題思路：
 * 我們需要三個指標：prev (前一個), curr (目前的), next (下一個)。
 * 透過不斷地更換 curr.next 的指向，來達成反轉的目的。
 * 
 * 時間複雜度：O(n)
 * 空間複雜度：O(1)
 */
public class Q206_ReverseLinkedList {

    // 定義節點結構 (LeetCode 內建)
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
        // 1. 初始化：prev 是 null, curr 是 head
        ListNode prev = null;
        ListNode curr = head;

        // 2. 當 curr 還沒跑出範圍時，開始跳舞
        while (curr != null) {
            // 第一步：備忘 (把下一個人記在 nextTemp)
            // TODO
            ListNode nextTemp = curr.next;
            // 第二步：轉頭 (把我現在的 next 指向 prev)
            // TODO
            curr.next = prev;
            // 第三步：交棒 (把 prev 往前移到我現在的位置)
            prev = curr;
            // 第四步：前進 (我自己往前跳到備忘錄那個人那裡)
            // TODO
            curr = nextTemp;
        }

        // 3. 回傳新頭頭
        return prev;
    }


    public static void main(String[] args) {
        // 1. 建立珍珠 (Nodes)
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        // 2. 把珍珠串起來： 1 -> 2 -> 3
        n1.next = n2;
        n2.next = n3;

        // 3. 印出反轉前的樣子
        System.out.print("反轉前: ");
        printList(n1);

        // 4. 執行反轉
        Q206_ReverseLinkedList solution = new Q206_ReverseLinkedList();
        ListNode newHead = solution.reverseList(n1);

        // 5. 印出反轉後的樣子
        System.out.print("反轉後: ");
        printList(newHead);
    }

    // 輔助方法：幫我們印出整串項鍊
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

}
