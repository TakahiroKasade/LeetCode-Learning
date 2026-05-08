package java_projects;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 【極致體驗】樂觀鎖 vs 悲觀鎖 Web 模擬器
 * 
 * 執行此程式後，請在瀏覽器開啟：http://localhost:8080
 * 建議開啟兩個視窗（左右併排）來模擬併發操作。
 */
public class Q_LockingWebSimulator {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "123456"; // TODO: 請確保密碼正確

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/action", new ActionHandler());
        server.setExecutor(null);
        System.out.println("====== HIS 鎖定模擬器已啟動 ======");
        System.out.println("請在瀏覽器開啟：http://localhost:8081");
        System.out.println("==================================");
        server.start();
    }

    // 處理首頁 HTML 渲染
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String html = "<html><head><meta charset='UTF-8'><title>HIS 鎖定模擬器</title><style>" +
                    "body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #1a1a2e, #16213e); display: flex; justify-content: center; gap: 40px; padding: 40px; min-height: 100vh; margin: 0; }" +
                    ".card { background: rgba(255,255,255,0.95); padding: 25px; border-radius: 16px; box-shadow: 0 8px 32px rgba(0,0,0,0.3); width: 420px; }" +
                    ".card-a { border-top: 4px solid #e74c3c; }" +
                    ".card-b { border-top: 4px solid #3498db; }" +
                    "h2 { padding-bottom: 10px; margin-top: 0; }" +
                    ".title-a { color: #e74c3c; }" +
                    ".title-b { color: #3498db; }" +
                    ".mode-selector { background: #f8f9fa; padding: 10px 15px; border-radius: 8px; margin-bottom: 15px; font-size: 0.9em; }" +
                    ".info { background: #e8f0fe; padding: 12px; border-radius: 8px; margin-bottom: 15px; font-size: 0.9em; }" +
                    "textarea { width: 100%; height: 100px; margin: 10px 0; padding: 12px; border: 2px solid #ddd; border-radius: 8px; font-size: 14px; box-sizing: border-box; resize: vertical; }" +
                    "textarea:focus { border-color: #4285f4; outline: none; }" +
                    "button { cursor: pointer; padding: 12px 24px; border: none; border-radius: 8px; color: white; font-weight: bold; font-size: 14px; transition: all 0.3s; }" +
                    "button:hover { transform: translateY(-2px); box-shadow: 0 4px 12px rgba(0,0,0,0.2); }" +
                    ".btn-read { background: #34a853; margin-right: 10px; }" +
                    ".btn-save { background: #4285f4; }" +
                    ".log { margin-top: 15px; padding: 12px; background: #1a1a2e; color: #0f0; font-family: 'Consolas', monospace; height: 120px; overflow-y: auto; font-size: 0.85em; border-radius: 8px; line-height: 1.6; }" +
                    "</style></head><body>" +
                    renderDoctorCard("醫師A", "a") +
                    renderDoctorCard("醫師B", "b") +
                    "<script>" +
                    "async function doAction(doctor, type, cardId) {" +
                    "  const content = document.getElementById('text-' + doctor).value;" +
                    "  const version = document.getElementById('ver-' + doctor).innerText;" +
                    "  const logBox = document.getElementById('log-' + doctor);" +
                    "  const mode = document.querySelector('input[name=\"mode-' + cardId + '\"]:checked').value;" +
                    "  const now = new Date().toLocaleTimeString('en-GB', {hour12:false, hour:'2-digit', minute:'2-digit', second:'2-digit', fractionalSecondDigits:3});" +
                    "  logBox.innerHTML += '<span style=\"color:#888\">[' + now + ']</span> > 正在請求 ' + type + '...<br>';" +
                    "  try {" +
                    "    const res = await fetch('/action?doctor=' + encodeURIComponent(doctor) + '&type=' + type + '&content=' + encodeURIComponent(content) + '&version=' + version + '&mode=' + mode);" +
                    "    const data = await res.json();" +
                    "    const now2 = new Date().toLocaleTimeString('en-GB', {hour12:false, hour:'2-digit', minute:'2-digit', second:'2-digit', fractionalSecondDigits:3});" +
                    "    if(data.version) document.getElementById('ver-' + doctor).innerText = data.version;" +
                    "    if(data.content) document.getElementById('text-' + doctor).value = data.content;" +
                    "    logBox.innerHTML += '<span style=\"color:#888\">[' + now2 + ']</span> ' + (data.success ? '<span style=\"color:#ffd700\">' : '<span style=\"color:#ff4444\">') + data.message + '</span><br>';" +
                    "    logBox.scrollTop = logBox.scrollHeight;" +
                    "  } catch(e) { logBox.innerHTML += '<span style=\"color:#ff4444\">Error: ' + e + '</span><br>'; }" +
                    "}" +
                    "</script>" +
                    "</body></html>";
            exchange.sendResponseHeaders(200, html.getBytes("UTF-8").length);
            OutputStream os = exchange.getResponseBody();
            os.write(html.getBytes("UTF-8"));
            os.close();
        }

        private String renderDoctorCard(String doctor, String cardId) {
            String colorClass = "a".equals(cardId) ? "card-a" : "card-b";
            String titleClass = "a".equals(cardId) ? "title-a" : "title-b";
            String emoji = "a".equals(cardId) ? "\uD83D\uDC68\u200D\u2695\uFE0F" : "\uD83D\uDC69\u200D\u2695\uFE0F";
            return "<div class='card " + colorClass + "'>" +
                    "<h2 class='" + titleClass + "'>" + emoji + " " + doctor + " 控制台</h2>" +
                    "<div class='mode-selector'>" +
                    "  鎖定模式：<input type='radio' name='mode-" + cardId + "' value='opt' checked> 樂觀鎖 " +
                    "  <input type='radio' name='mode-" + cardId + "' value='pes'> 悲觀鎖" +
                    "</div>" +
                    "<div class='info'>病人：張小明 | 目前讀取版本：<b><span id='ver-" + doctor + "'>--</span></b></div>" +
                    "<textarea id='text-" + doctor + "' placeholder='請先點擊「讀取醫囑」載入資料...'></textarea><br>" +
                    "<button class='btn-read' onclick=\"doAction('" + doctor + "', 'READ', '" + cardId + "')\">1. 讀取醫囑</button>" +
                    "<button class='btn-save' onclick=\"doAction('" + doctor + "', 'SAVE', '" + cardId + "')\">2. 按下儲存</button>" +
                    "<div class='log' id='log-" + doctor + "'>系統日誌：<br></div>" +
                    "</div>";
        }
    }

    // 處理 AJAX 請求邏輯 (JDBC)
    static class ActionHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String json;
            try {
                Map<String, String> params = queryToMap(exchange.getRequestURI().getQuery());
                String doctor = params.getOrDefault("doctor", "未知");
                String type = params.getOrDefault("type", "");
                String content = params.getOrDefault("content", "");
                String versionStr = params.getOrDefault("version", "0");
                int version = 0;
                try { version = Integer.parseInt(versionStr); } catch (NumberFormatException ignored) {}
                String mode = params.getOrDefault("mode", "opt");

                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    if ("READ".equals(type)) {
                        json = handleRead(conn, mode, doctor);
                    } else {
                        json = handleSave(conn, mode, doctor, content, version);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                json = "{\"success\": false, \"message\": \"系統錯誤: " + e.getMessage().replace("\"", "'") + "\"}";
            }

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            byte[] response = json.getBytes("UTF-8");
            exchange.sendResponseHeaders(200, response.length);
            OutputStream os = exchange.getResponseBody();
            os.write(response);
            os.close();
        }

        private String handleRead(Connection conn, String mode, String doctor) throws SQLException {
            String sql = "SELECT * FROM locking_test WHERE id = 1" + ("pes".equals(mode) ? " FOR UPDATE" : "");
            // 注意：悲觀鎖需要 Transaction 才能維持鎖，此處為了模擬簡化，實際 Web 專案不建議在 GET 鎖定
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return String.format("{\"success\": true, \"message\": \"讀取成功\", \"content\": \"%s\", \"version\": %d}",
                            rs.getString("order_content"), rs.getInt("version"));
                }
            }
            return "{\"success\": false, \"message\": \"找不到資料\"}";
        }

        private String handleSave(Connection conn, String mode, String doctor, String content, int oldVersion) throws SQLException {
            String sql;
            int rows;
            if ("opt".equals(mode)) {
                sql = "UPDATE locking_test SET order_content = ?, version = version + 1 WHERE id = 1 AND version = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, content + " (by " + doctor + ")");
                    pstmt.setInt(2, oldVersion);
                    rows = pstmt.executeUpdate();
                }
                if (rows > 0) return "{\"success\": true, \"message\": \"【樂觀鎖】儲存成功！版本已更新。\"}";
                else return "{\"success\": false, \"message\": \"【樂觀鎖】儲存失敗！資料已被他人修改，請刷新再試。\"}";
            } else {
                // 悲觀鎖模式
                sql = "UPDATE locking_test SET order_content = ? WHERE id = 1";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, content + " (by " + doctor + ")");
                    rows = pstmt.executeUpdate();
                }
                return "{\"success\": true, \"message\": \"【悲觀鎖】儲存成功！\"}";
            }
        }

        private Map<String, String> queryToMap(String query) {
            Map<String, String> result = new HashMap<>();
            for (String param : query.split("&")) {
                String[] entry = param.split("=");
                if (entry.length > 1) result.put(entry[0], java.net.URLDecoder.decode(entry[1], java.nio.charset.StandardCharsets.UTF_8));
            }
            return result;
        }
    }
}
