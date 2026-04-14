# 每日上班練習計畫 - LeetCode + SQL
## 適合：Java初學者 | 每日2小時 | SQL初級

---

## 📋 計畫概覽

| 時間配置 | 內容 | 時長 |
|--------|------|------|
| **週一、三、五** | LeetCode (Java) + SQL練習 | 2小時 |
| **週二、四** | SQL進階 + 複習前面的題目 | 2小時 |
| **週末** | 總結 & 挑戰難題 | 自由 |

**每週目標：**
- ✅ 完成 5-6 道 LeetCode Easy 題目
- ✅ 學習 SQL 的 2-3 個新知識點
- ✅ 複習並優化之前做過的題目

---

## ⏰ 每日標準時間分配（2小時）

### 模式 A：LeetCode 重點日（週一、三、五）

```
09:00-09:10 (10分鐘)   → 熱身與回顧
  - 快速檢查昨天的筆記
  - 明確今天的目標

09:10-09:50 (40分鐘)   → LeetCode 做題
  - 做 1-2 道 Easy 難度題目
  - 專注理解題意，不要急著看答案

09:50-10:10 (20分鐘)   → 題目講解與優化
  - 查看官方解答或題解
  - 學習更優雅的解法
  - 複雜度分析（時間、空間）

10:10-10:50 (40分鐘)   → SQL 練習
  - 學習新的 SQL 概念（見下方課程表）
  - 在 LeetCode SQL 或 LeetCode Database 上做 2-3 道題

10:50-11:00 (10分鐘)   → 記錄與反思
  - 記錄學到的要點
  - 標記困難點
```

### 模式 B：複習與進階日（週二、四）

```
09:00-09:10 (10分鐘)   → 計劃確認
  - 選擇上週遇到的難題

09:10-09:40 (30分鐘)   → LeetCode 複習
  - 不看答案，重新做 2-3 道之前的題目
  - 檢查是否真正掌握

09:40-10:20 (40分鐘)   → SQL 進階
  - 學習高級 SQL（JOIN、GROUP BY、子查詢等）
  - 做 3-4 道 SQL 題目

10:20-11:00 (40分鐘)   → 對標練習
  - 挑選 1 道中等難度的 LeetCode 題
  - 嘗試從零開始完成

11:00-11:10 (10分鐘)   → 總結筆記
  - 更新學習進度表
```

---

## 🎯 LeetCode 學習路線（Java）

### 第 1-2 週：基礎數據結構
**概念：** 數組、字符串、基本遍歷

| 題號 | 題名 | 難度 | 關鍵概念 |
|-----|------|------|--------|
| 1 | Two Sum | Easy | 哈希表 (HashMap) |
| 9 | Palindrome Number | Easy | 字符串反轉 |
| 13 | Roman to Integer | Easy | 哈希表查詢 |
| 20 | Valid Parentheses | Easy | 棧 (Stack) |
| 66 | Plus One | Easy | 數組遍歷 |
| 121 | Best Time to Buy and Sell Stock | Easy | 單次遍歷 |

### 第 3-4 週：鏈表與遞歸
**概念：** 鏈表操作、遞歸思維

| 題號 | 題名 | 難度 | 關鍵概念 |
|-----|------|------|--------|
| 21 | Merge Two Sorted Lists | Easy | 鏈表合併 |
| 83 | Remove Duplicates from Sorted List | Easy | 鏈表遍歷 |
| 206 | Reverse Linked List | Easy | 遞歸/迭代 |
| 141 | Linked List Cycle | Easy | 雙指針 |
| 100 | Same Tree | Easy | 遞歸 |
| 104 | Maximum Depth of Binary Tree | Easy | 樹的遞歸 |

### 第 5-6 週：進階算法
**概念：** 排序、二分查找、滑動窗口

| 題號 | 題名 | 難度 | 關鍵概念 |
|-----|------|------|--------|
| 33 | Search in Rotated Sorted Array | Medium | 二分查找 |
| 3 | Longest Substring Without Repeating Characters | Medium | 滑動窗口 |
| 150 | Evaluate Reverse Polish Notation | Medium | 棧 |
| 235 | Lowest Common Ancestor of a Binary Search Tree | Easy | BST性質 |

---

## 📚 SQL 學習課程表

### 第 1-2 週：基礎查詢
**目標：** 掌握基本查詢語法

```sql
✓ SELECT 語句基礎
✓ WHERE 條件篩選
✓ ORDER BY 排序
✓ LIMIT 限制結果數量
✓ 基本聚合函數：COUNT(), SUM(), AVG(), MAX(), MIN()

範例練習：
- 查詢所有用戶的名字和年齡
- 查詢年齡大於30的用戶
- 計算用戶的平均年齡
```

**推薦 LeetCode SQL 題目：**
- 595 Big Countries
- 627 Swap Salary
- 182 Duplicate Emails
- 175 Combine Two Tables

### 第 3-4 週：JOIN 和分組

```sql
✓ INNER JOIN
✓ LEFT JOIN / RIGHT JOIN
✓ FULL OUTER JOIN
✓ GROUP BY 分組
✓ HAVING 分組篩選
✓ DISTINCT 去重

範例練習：
- 連接兩個表並篩選數據
- 按部門統計員工人數
- 找出購買次數最多的用戶
```

**推薦 LeetCode SQL 題目：**
- 176 Second Highest Salary
- 177 Nth Highest Salary
- 184 Department Highest Salary
- 180 Consecutive Numbers
- 262 Trips and Users

### 第 5-6 週：子查詢和進階
```sql
✓ 子查詢（SELECT IN、EXISTS）
✓ 窗口函數（ROW_NUMBER、RANK、DENSE_RANK）
✓ CASE 語句
✓ 常用日期函數

範例練習：
- 使用子查詢查找滿足條件的記錄
- 使用窗口函數進行排名
- 複雜的多表聯合查詢
```

**推薦 LeetCode SQL 題目：**
- 196 Delete Duplicate Emails
- 197 Rising Temperature
- 511 Game Play Analysis I
- 550 Game Play Analysis IV

---

## 💡 實用工具和資源

### Java 開發環境
```
推薦IDE：
- VS Code + Java Extension Pack
- IntelliJ IDEA Community Edition (免費)
- Eclipse

快速模板（在LeetCode上使用）：
class Solution {
    public int someMethod(int[] nums) {
        // 解題代碼
        return result;
    }
}
```

### SQL 練習環境
```
推薦平台：
1. LeetCode Database (免費)
   - 登錄 LeetCode，選擇 "Database" 標籤
   
2. SQLZoo (免費)
   - 互動式 SQL 教程
   
3. Mode Analytics SQL Tutorial (免費)
   - 完整的 SQL 從入門到精通教程

4. 本地環境
   - MySQL: https://dev.mysql.com/downloads/mysql/
   - PostgreSQL: https://www.postgresql.org/download/
```

### 推薦學習資源

**YouTube 頻道（中文）：**
- 花花醬 LeetCode (深度講解算法)
- 代碼隨想錄 (LeetCode 專題講解)

**在線課程：**
- LeetCode Explore (LeetCode 官方課程)
- Coursera：Algorithm Specialization

**書籍：**
- 《代碼面試集錦》
- 《Java 核心技術》

---

## 📝 學習筆記模板

為每個題目記錄以下內容：

```
【題目】Two Sum (LeetCode #1)
【難度】Easy
【解題思路】
  1. 使用 HashMap 存儲已見過的數字
  2. 遍歷數組，檢查是否存在補數
  
【時間複雜度】O(n)
【空間複雜度】O(n)

【Java 代碼關鍵點】
  - HashMap 的基本用法
  - 何時返回結果

【遇到的問題】
  - 如何處理邊界情況

【優化建議】
  - 是否有更好的方案
```

---

## 🔄 週進度追蹤模板

### 本週進度
```
【日期】2024年X月X日 - X月X日

LeetCode 進度：
☐ 第1天：Two Sum (Easy)
☐ 第2天：Palindrome Number (Easy)  
☐ 第3天：Valid Parentheses (Easy)
☐ 第4天：複習前3道題
☐ 第5天：Plus One (Easy)
☐ 第6天：Best Time to Buy and Sell Stock (Easy)

SQL 進度：
☐ Day 1-2：SELECT 和 WHERE
☐ Day 3-4：ORDER BY 和聚合函數
☐ Day 5-6：JOIN 基礎

完成度：___/6 道 LeetCode | ___/3 個 SQL 概念

遇到的困難：
- ...

下週計劃：
- ...
```

---

## ⚠️ 常見誤區和建議

### ❌ 做題速度優先
**正確做法：** 寧可做5道真正理解的題，也不要匆匆做20道

### ❌ 只看答案不動手
**正確做法：** 自己嘗試15-20分鐘無果後再看答案，然後自己重寫一遍

### ❌ SQL 和 LeetCode 完全分開
**正確做法：** 結合練習，很多實際應用都需要兩者配合

### ❌ 不總結和複習
**正確做法：** 定期（每週）複習之前做過的題，確保真正掌握

---

## 🎯 一個月後的目標

**LeetCode：**
- ✅ 完成 20-25 道 Easy 題目
- ✅ 理解常見數據結構（陣列、鏈表、棧、隊列、樹）
- ✅ 掌握 2-3 種常用算法思路

**SQL：**
- ✅ 能獨立寫出涉及 2-3 個表的查詢
- ✅ 掌握 JOIN、GROUP BY、子查詢
- ✅ 能優化簡單的查詢性能

---

## 💪 激勵和堅持

**計時器推薦：** 使用番茄工作法（25分鐘專注 + 5分鐘休息）

**進度可視化：**
- 在 Excel 或 GitHub 上記錄每週完成的題數
- 設置小目標：每週 5 道、一月 20 道

**社區互動：**
- 加入 LeetCode 討論區
- 在 GitHub 記錄學習過程
- 找一個同學互相監督

---

## 附錄：每日檢查清單

```
每日結束前檢查：
☐ 是否完成了計劃的題目/概念
☐ 是否理解了解題思路
☐ 是否記錄了筆記
☐ 是否遇到新的疑問
☐ 明天的計劃是否明確

每週結束前檢查：
☐ 本週是否完成了目標（5-6 道題）
☐ SQL 進度是否跟上
☐ 是否有需要複習的內容
☐ 下週的重點是什麼
```

---

**祝你學習順利！記住：堅持比天賦更重要！** 🚀
