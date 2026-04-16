# SQL 聯結與自身應用 實戰練習 (2026/04/16)

今天我們要跨越「單張表」的限制，學習如何將兩張表組合在一起，以及如何讓同一張表內的不同資料進行對決。

---

## 🚩 題目一：Combine Two Tables (LeetCode #175)

### 📝 題目描述
現在有兩張表：
1. `Person` (個人資訊)：有 `personId`, `firstName`, `lastName`。
2. `Address` (住址資訊)：有 `addressId`, `personId`, `city`, `state`。

**任務**：撰寫一個 SQL，查詢所有人的 `firstName`, `lastName`, `city`, `state`。
**關鍵點**：如果某個人在 `Address` 表裡沒有地址資料，他的城市和州要顯示為 `Null` (但人名還是要出現)。

### 💡 觀念引導：為什麼不能用普通的 JOIN?
- 如果用 `INNER JOIN`，沒地址的人會被踢出報表（就像醫院查病人名單，沒登記地址的病人會消失）。
- 我們要用 **`LEFT JOIN`**：以左邊的表 (Person) 為主，右邊 (Address) 沒資料就填空。

### ✍️ 練習區
```sql
SELECT a.firstName, a.lastName, b.city, b.state
FROM Person a
LEFT JOIN Address b ON a.personId = b.personId;
```

---

## 🚩 題目二：Employees Earning More Than Their Managers (LeetCode #181)

### 📝 題目描述
有一張 `Employee` 表，包含：`id`, `name`, `salary`, `managerId`。
- `managerId` 指向的是這張表裡另一個人的 `id`。

**任務**：找出所有「薪水比自己主管高」的員工姓名。

### 💡 觀念引導：Self Join 的進階版
這題需要把 `Employee` 表想像成兩份：
- **一份是員工表 (e)**
- **一份是主管表 (m)**
- 連結條件：員工的 `managerId` = 主管的 `id`。

### ✍️ 練習區
```sql
SELECT e.name AS Employee
FROM Employee e, Employee m
WHERE e.managerId = m.id AND e.salary > m.salary;
```

---

## 💡 SQL 三大聯結：白話速查表

| 聯結類型 | 白話比喻 | 核心邏輯 | 醫院實務場景 |
| :--- | :--- | :--- | :--- |
| **INNER JOIN** | **嚴格門禁** | 兩邊都有資料才顯示，任何一邊空缺就剔除。 | 查詢「有完成手術」的病人（沒動手術的就不顯示）。 |
| **LEFT JOIN** | **主從協議** | **以左表為主**。左邊的人全出現，右邊沒資料就補 Null。 | 查詢「全院病人」及其地址（沒留地址的人姓名也要出現）。 |
| **SELF JOIN** | **照鏡子** | 同一張表自己跟自己比。通常是為了處理「階層（主管/員工）」或「對照」關係。 | 查詢「某個護理紀錄」在不同時間點的數值變化（自己跟自己的歷史紀錄比）。 |

### 🔍 補充：為什麼沒有用 RIGHT JOIN?
`RIGHT JOIN` 只是把 `LEFT JOIN` 的主客關係顛倒過來。在實務上，為了程式碼的統一性，我們習慣固定把「重要的主表」放在 `FROM` 的位置，然後一路 `LEFT JOIN` 下去，這樣閱讀起來最符合大腦直覺！

---
**@author** Takahiro  
**@date** 2026/04/16
