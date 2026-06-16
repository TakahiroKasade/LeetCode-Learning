package java_projects.basics;

public class Q_TestBuilder {
    public static void main(String[] args) {
        String patientName = "張三";
        String disease = "高血壓";

        // 1. 宣告 StringBuilder
        StringBuilder builder = new StringBuilder();

        // 🔴 請在下方寫 1 行程式碼，利用 StringBuilder 的 .append() 方法與鏈式呼叫，
        // 將字串拼裝成: "病患:張三, 診斷:高血壓" 的格式。
        // 提示: builder.append("病患:").append(...).append(...)
        builder.append("病患:").append(patientName).append(",診斷").append(disease);


        // 2. 印出結果 (builder.toString() 會把拼裝好的內容轉回普通 String)
        System.out.println(builder.toString());
    }
}
