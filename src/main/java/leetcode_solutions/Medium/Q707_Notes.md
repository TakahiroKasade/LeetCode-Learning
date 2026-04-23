# LeetCode #707 - Design Linked List (設計鏈結串列)

## 📌 學習目標
*   理解 **Node (節點)** 與 **Next (指針)** 的記憶體關係。
*   實作基本的資料結構操作：查詢、新增、刪除。
*   掌握「虛擬頭節點 (Dummy Head)」的技巧（可選，能簡化邊界條件）。

---

## 🛠️ API 操作邏輯圖解

### 1. `addAtHead(val)`
*   邏輯：新節點的 `next` 指向目前的 `head`，然後更新 `head` 為新節點。
*   注意：這是最簡單的新增操作。

### 2. `addAtTail(val)`
*   邏輯：從 `head` 開始遍歷，直到找到 `next` 為 `null` 的最後一個節點，將其 `next` 指向新節點。
*   思考：如果 `head` 本來就是空的怎麼辦？

### 3. `deleteAtIndex(index)`
*   邏輯：找到第 `index - 1` 個節點（前驅節點），將它的 `next` 跳過第 `index` 個，直接指向第 `index + 1` 個。
*   四字口訣：**「跨越刪除」**。

---

## ⚠️ 常見陷阱 (Pitfalls)
1.  **Index 越界**：在執行任何操作前，務必檢查 `index` 是否在 `0 ~ size-1` 之間。
2.  **空串列處理**：當串列為空時，`head` 為 `null`，此時呼叫 `head.next` 會導致 `NullPointerException`。
3.  **長度更新**：每次新增或刪除後，別忘了更新 `size` 變數。

---
**@author** Takahiro  
**@date** 2026/04/23
