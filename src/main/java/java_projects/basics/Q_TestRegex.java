package java_projects.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q_TestRegex {
    public static void main(String[] args) {
        // -----------------------------------------------------------------
        // 🔴 任務一：驗證台灣手機號碼 (格式必須為 09 開頭，後面接著 8 碼數字，總共 10 碼)
        // 範例：0912345678 (符合), 0812345678 (不符合), 091234567 (不符合，少一碼)
        // -----------------------------------------------------------------
        System.out.println("--- 📱 任務一：手機號碼驗證 ---");
        
        // 請在此處撰寫你的手機號碼正規表示法
        // 提示：^ 代表開始，09 代表固定前置，\\d{8} 代表 8 碼數字，$ 代表結束
        // 注意：在 Java 字串中，反斜線 \ 必須寫成雙反斜線 \\ 轉義，所以 \d 要寫成 \\d
        String phoneRegex = "^09\\d{8}$"; // [請在此處編寫手機 Regex]
        
        String[] testPhones = {"0912345678", "0812345678", "09123456", "09123456789"};
        for (String phone : testPhones) {
            boolean isValid = validate(phone, phoneRegex);
            System.out.println("號碼: " + phone + " ➔ 驗證結果: " + (isValid ? "🟢 合法" : "🔴 不合法"));
        }

        // -----------------------------------------------------------------
        // 🔴 任務二：驗證簡單的 Email 格式
        // 規則：前面可以是任何英文字母或數字，後面接著 @，再接著 domain 名字，最後是 .com
        // 範例：test@gmail.com (符合), test.gmail.com (不符合，沒有 @), test@gmail (不符合，沒有 .com)
        // -----------------------------------------------------------------
        System.out.println("\n--- ✉️ 任務二：Email 格式驗證 ---");
        
        // 請在此處撰寫你的 Email 正規表示法
        // 提示：^[a-zA-Z0-9]+ 代表帳號開頭，接著 @，接著 [a-zA-Z0-9]+ 代表網域，最後接著 \\.com$ (注意點號 . 前面要加 \\ 轉義，否則會變成任意字元)
        String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$"; // [請在此處編寫 Email Regex]
        
        String[] testEmails = {"takahiro@gmail.com", "takahiro.gmail.com", "takahiro@gmail", "takahiro@company.com","takajojo@@gmail.com"};
        for (String email : testEmails) {
            boolean isValid = validate(email, emailRegex);
            System.out.println("Email: " + email + " ➔ 驗證結果: " + (isValid ? "🟢 合法" : "🔴 不合法"));
        }
    }

    // 通用的 Regex 驗證輔助方法
    public static boolean validate(String input, String regex) {
        if (input == null || regex == null || regex.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
