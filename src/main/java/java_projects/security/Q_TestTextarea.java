package java_projects.security;

public class Q_TestTextarea {
    public static void main(String[] args) {
        // 模擬資料庫取出的惡意診斷資料（阿明下毒的資料）
        String databaseData = "</textarea><script>alert('XSS');</script>";

        // 1. 進行 HTML 轉義
        String safeData = htmlEscape(databaseData);

        // 2. 模擬輸出到 HTML 畫面上
        System.out.println("--- 🔴 壞寫法：會被強行閉合並引爆 XSS ---");
        System.out.println("<textarea>" + databaseData + "</textarea>");

        System.out.println("\n--- 🟢 好寫法：安全轉義，標籤未閉合 ---");
        System.out.println("<textarea>" + safeData + "</textarea>");
    }

    public static String htmlEscape(String input) {
        if (input == null) return null;

        return input.replace("<", "&lt;") .replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
        
    }
}
