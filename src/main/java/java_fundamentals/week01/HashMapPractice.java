package java_fundamentals.week01;

import java.util.HashMap;

/**
 * 練習題目：HashMap 鍵值對基礎操作
 * 任務內容：
 * 1. 初始化 HashMap<Integer, String> 儲存員工資料
 * 2. 使用 put() 存入資料並觀察 Key 重複時的覆蓋現象
 * 3. 使用 get() 與 containsKey() 查找資料
 * 4. 使用 size() 確認資料總筆數
 * 5. 使用 keySet() 遍歷所有鍵並取出值 (Traversal)
 * 
 * @author Takahiro
 * @date 2026/04/16
 */
public class HashMapPractice {

    public static void main(String[] args) {
        // 1. 初始化 HashMap (Key: 員工 ID, Value: 員工姓名)
        HashMap<Integer, String> employeeMap = new HashMap<>();

        // 2. 存入數據 (Put)
        employeeMap.put(101, "Takahiro");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Alice");
        System.out.println("目前的員工資料: " + employeeMap);

        // 3. 讀取與查詢 (Get & ContainsKey)
        System.out.println("查詢 ID 101 的姓名: " + employeeMap.get(101));
        System.out.println("檢查 ID 105 是否存在: " + employeeMap.containsKey(105));

        // 4. 判斷重複 Key 的現象
        System.out.println("\n--- 測試重複 Key 存入 ---");
        System.out.println("原本 ID 101 為: " + employeeMap.get(101));
        
        // 再次 put 相同的 Key (101)
        employeeMap.put(101, "Sam");
        System.out.println("覆蓋後 ID 101 為: " + employeeMap.get(101));
        System.out.println("觀察結果：當 Key 重複時，新的 Value 會覆蓋掉原本的 Value。");

        // 5. 資料筆數 (Size)
        System.out.println("\n目前員工總數: " + employeeMap.size());
        System.out.println("最終員工名單: " + employeeMap);

        // 6. 遍歷鍵值對 (keySet) - 這是今天學到的進階技巧！
        System.out.println("\n--- 使用 keySet() 進行遍歷 ---");
        /*
         * keySet() 會回傳 Map 中所有的 Key (鍵)
         * 我們可以使用 for-each 迴圈來依序取出每一個 Key
         */
        for (Integer id : employeeMap.keySet()) {
            // 透過 Key (ID) 拿到對應的 Value (姓名)
            String name = employeeMap.get(id);
            System.out.println("員工 ID: " + id + ", 姓名: " + name);
        }
    }
}
