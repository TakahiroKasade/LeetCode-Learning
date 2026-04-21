package leetcode_solutions.Easy;

/**
 * LeetCode #206 - Reverse Linked List (翻轉鏈表)
 * 
 * 【題目描述】
 * 反轉一個單向鏈表。
 * 例如： 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * 反轉後： 5 -> 4 -> 3 -> 2 -> 1 -> NULL
 * 
 * 【此題核心觀念】
 * 1. 物件引用操控：理解如何在 Heap 中修改 next 的指向。
 * 2. 暫存變數：在剪斷原本的連結前，必須先紀錄「下一個節點」的位置，否則會發生 NullPointerException。
 * 3. 記憶體佈局：這題是昨日「Memory Model」觀念的實戰應用。
 * 
 * 【反轉手術五步驟 - 邏輯拆解】
 * 1. 建立 prev 指標 (初始化為 null)，代表翻轉後的「新尾部」。
 * 2. 建立 curr 指標 (初始化為 head)，代表目前正在處理的節點。
 * 3. 在迴圈中，先將 curr.next 暫存起來（備份）。
 * 4. 將 curr.next 指向 prev (完成翻轉！)。
 * 5. 將 prev 與 curr 向後位移，繼續處理下一個。
 * 
 * @author Takahiro
 * @date 2026/04/21
 */
public class Q206_ReverseLinkedList {

    /**
     * 翻轉鏈表的實作方法
     * @param head 鏈表的頭節點
     * @return 翻轉後的頭節點
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // STEP 1: 【卡位】先找個臨時夥伴記下原本的「下一個」是誰，免得線斷了之後後面的人跑掉
        		ListNode nextTemp = curr.next;
            // STEP 2: 【轉身】把目前這個人 (curr) 的手放開，改去牽著「剛才轉身成功的那個前任」 (prev)
        		curr.next = prev;
            // STEP 3: 【交棒】現在你自己也轉身成功了，所以你要成為下一個人的「前任」 (把這個 curr 交給 prev)
                prev = curr ; 
            // STEP 4: 【前進】剛才那個暫時記住的下一個夥伴，現在變成了「目前要處理的人」 (把暫存的夥伴交給 curr)
                curr = nextTemp;
        }

        return prev;
    }

    public static void main(String[] args) {
        // 1. 建立鏈表： 1 -> 2 -> 3
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.print("翻轉前: ");
        printList(n1);

        // 2. 執行翻轉
        Q206_ReverseLinkedList solution = new Q206_ReverseLinkedList();
        ListNode reversedHead = solution.reverseList(n1);

        System.out.print("翻轉後: ");
        printList(reversedHead);
    }

    /**
     * 輔助方法：印出整串鏈表內容
     */
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
