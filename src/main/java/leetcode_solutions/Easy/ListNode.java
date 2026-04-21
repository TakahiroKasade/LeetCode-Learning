package leetcode_solutions.Easy;

/**
 * 鏈表節點類別 (LeetCode 標準結構)
 * 
 * @author Takahiro
 * @date 2026/04/21
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
