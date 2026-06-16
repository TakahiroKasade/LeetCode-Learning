package java_projects.security;

public class Q_TestCookie {
    public static void main(String[] args) {
        MyCookie cookie = new MyCookie("session_id", "XYZ123");
        
        // 🟢 請在下方寫 1 行程式碼，啟用這個 cookie 的 httpOnly 屬性：
        cookie.setHttpOnly(true);

        System.out.println("Cookie 是否已啟用 HttpOnly? " + cookie.isHttpOnly());
    }
}

// 模擬 Cookie 類別
class MyCookie {
    private String name;
    private String value;
    private boolean httpOnly = false; // 預設關閉

    public MyCookie(String name, String value) {
        this.name = name;
        this.value = value;
    }
    public void setHttpOnly(boolean httpOnly) {
        this.httpOnly = httpOnly;
    }
    public boolean isHttpOnly() {
        return this.httpOnly;
    }
}
