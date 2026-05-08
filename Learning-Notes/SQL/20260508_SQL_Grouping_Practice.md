# 📊 SQL 實戰練習：GROUP BY & HAVING (醫院藥劑科情境)

## 🏥 情境說明
你是醫院資訊室的工程師，藥劑科主任想要一份「藥品庫存成本報表」。
他需要統計目前庫存中，**單價超過 50 元** 的藥品，並按 **「給藥途徑 (Route)」** 進行分組。
最後，他只想要看到 **總庫存金額 (單價 * 數量) 超過 5,000 元** 的類別。

## 🗄️ 資料表結構：`Pharmacy_Stock`

| 欄位名稱 | 說明 | 範例 |
| :--- | :--- | :--- |
| `drug_id` | 藥品代碼 | `D001` |
| `drug_name` | 藥品名稱 | `Aspirin` |
| `route` | 給藥途徑 | `Oral`, `Injection`, `Topical` |
| `unit_price` | 單價 | `60` |
| `stock_quantity` | 庫存數量 | `100` |

---

## 📝 實作任務

請寫出一個 SQL 查詢，包含以下邏輯：
1. **篩選條件**：只計算 `unit_price > 50` 的藥品。
2. **分組邏輯**：按 `route` 分組。
3. **顯示欄位**：
   - 給藥途徑 (`route`)
   - 該類別藥品總數 (`COUNT(*)`)
   - 該類別總庫存金額 (`SUM(unit_price * stock_quantity)`)
4. **分組後篩選**：總庫存金額必須 **大於 5,000 元**。

---


## 🧠 思考區 (請在此寫下你的 SQL)

```sql
-- 請在此輸入你的答案
```
SELECT  route , COUNT(*) AS drug_count , SUM(unit_price * stock_quantity) AS total_value
FROM Pharmacy_Stock
WHERE unit_price > 50
GROUP BY route
HAVING SUM(unit_price * stock_quantity) > 5000 
---

## 💡 提示與檢查
- [ ] 我用了 `WHERE` 來過濾單價嗎？
- [ ] 我用了 `GROUP BY` 來分類途徑嗎？
- [ ] 我用了 `HAVING` 來過濾總金額嗎？
- [ ] 執行順序對嗎？ (FROM -> WHERE -> GROUP BY -> HAVING -> SELECT)
