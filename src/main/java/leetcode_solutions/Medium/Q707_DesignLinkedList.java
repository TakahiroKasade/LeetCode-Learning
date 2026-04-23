package leetcode_solutions.Medium;

/**
 * LeetCode #707 - Design Linked List (設計鏈結串列)
 * 
 * 任務描述：
 * 設計一個鏈結串列，支援以下操作：
 * 1. get(index)：獲取第 index 個節點的值。
 * 2. addAtHead(val)：在頭部插入節點。
 * 3. addAtTail(val)：在尾部插入節點。
 * 4. addAtIndex(index, val)：在第 index 個節點前插入節點。
 * 5. deleteAtIndex(index)：刪除第 index 個節點。
 * 
 * @author Takahiro
 * @date 2026/04/23
 */
class MyLinkedList {

    // 內部的節點類別 (Inner Class)
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head; // 鏈結串列的頭
    private int size;  // 紀錄目前串列長度

    /** 初始化 MyLinkedList */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /** 獲取第 index 個節點的值 */
    public int get(int index) {
        // TODO: 實作獲取邏輯
        if(index < 0 || index >= size){
            return -1;
        }
        Node curr = head;
        while(index > 0){
            curr = curr.next;
            index--;
        }
        return curr.val;
    }
    
    /** 在最前面新增一個節點 */
    public void addAtHead(int val) {
        // TODO: 實作新增邏輯
        Node newNode = new Node(val);
        head = newNode.next;
        
    }
    
    /** 在最後面新增一個節點 */
    public void addAtTail(int val) {
        // TODO: 實作新增邏輯
    }
    
    /** 在指定 index 前插入節點 */
    public void addAtIndex(int index, int val) {
        // TODO: 實作插入邏輯
    }
    
    /** 刪除指定 index 的節點 */
    public void deleteAtIndex(int index) {
        // TODO: 實作刪除邏輯
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
