package java_projects.basics;

public class Q_TestNullSafe {
    public static void main(String[] args) {
        String input = null; // 模擬資料庫撈出來的空值 (null)

        System.out.println("--- 測試開始 ---");

        // 🟢 方案 A：常數前置（老手寫法）
        // 請問: "0".equals(null) 會當機嗎？
        boolean resultA = "0".equals(input);
        System.out.println("方案 A 執行成功！結果是: " + resultA);

        System.out.println("\n--- 準備觸發當機 ---");

        // 🔴 方案 B：變數在頭（舊寫法，容易當機）
        // 請將下方這行程式碼的雙斜線 // 刪除，解開註解：
        // boolean resultB = input.equals("0");

        // System.out.println("方案 B 執行成功！結果是: " + resultB);
    }
}
