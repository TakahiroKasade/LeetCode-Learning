package java_fundamentals.week01;

import java.util.HashMap;

/**
 * 🚀 第一週 Java 基礎鞏固挑戰 (Consolidation Challenge)
 * 
 * 本題目旨在驗證對於 HashMap、迴圈控制以及方法封裝的綜合運用能力。
 * 請依照以下任務順序手寫實現代碼：
 * 
 * 任務內容：
 * 1. 於 main 方法中建立一個 HashMap<String, Integer>，代表員工姓名與薪水。
 * 2. 至少存入三筆資料（例如："Takahiro", 60000; "Alice", 45000; "Bob", 55000）。
 * 3. 實作一個靜態方法 checkHighSalary，接收該 Map 並遍歷。
 * 4. 於方法中判斷薪水是否大於 50000，若是則印出：「高薪員工姓名：[姓名]」。
 * 5. 確保程式碼整潔並符合 Java 命名慣例。
 * 
 * @author Takahiro
 * @date 2026/04/17
 */
public class ConsolidationChallenge {

    public static void main(String[] args) {
        // TODO: 1. 建立 HashMap 並存入資料
        HashMap<String, Integer> employeeMap = new HashMap<>();       
        employeeMap.put("Takahiro", 60000);
        employeeMap.put("Alice", 45000);
        employeeMap.put("Bob", 55000);
        
        // TODO: 2. 呼叫 checkHighSalary 方法
        checkHighSalary(employeeMap);
    }

    /**
     * 遍歷員工資料並篩選高薪者
     * 
     * @param employeeMap 包含姓名(String)與薪水(Integer)的 Map
     */
    public static void checkHighSalary(HashMap<String, Integer> employeeMap) {
        // 1. 啟動巡邏隊 (遍歷所有 Key)
        for (String name : employeeMap.keySet()) {
            // 2. 拿出這個人的薪水
            // int salary = ... (請使用 get)
            int salary =employeeMap.get(name);
            // 3. 判斷並印出姓名
            // if (salary > 50000) { ... }
            if( salary > 50000) {
            		System.out.println("高薪員工姓名：[" + name  +"]");
            }
            
        }
    }

}
