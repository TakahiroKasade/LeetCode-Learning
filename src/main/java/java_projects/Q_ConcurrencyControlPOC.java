package java_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 【POC】並發控制 (Concurrency Control) 概念驗證
 * 
 * 模擬兩位醫師 (A 與 B) 同時修改同一筆醫囑的情境。
 * 
 * @author Takahiro
 * @date 2026-05-06
 */
public class Q_ConcurrencyControlPOC {

    // TODO: 請確認並替換成你的 DB 連線資訊
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "123456"; // 請填入密碼

    // 開關：切換樂觀鎖 (true) 或 悲觀鎖 (false)
    private static final boolean USE_OPTIMISTIC = false;

    public static void main(String[] args) {
        System.out.println("====== HIS 系統並發測試開始 (模式：" + (USE_OPTIMISTIC ? "樂觀鎖" : "悲觀鎖") + ") ======\n");

        // 模擬兩位醫師的執行緒
        Thread doctorA = new Thread(new DoctorTask("醫師A", 3000)); // 醫師 A 思考比較久 (3秒)
        Thread doctorB = new Thread(new DoctorTask("醫師B", 1000)); // 醫師 B 動作很快 (1秒)

        doctorA.start();
        doctorB.start();
    }

    // 格式化印出時間軸，製造「畫面感」
    private static void log(String doctor, String message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        String prefix = doctor.equals("醫師A") ? "[畫面 A - " + doctor + "] " : "[畫面 B - " + doctor + "] ";
        System.out.println("[" + time + "] " + prefix + message);
    }

    static class DoctorTask implements Runnable {
        private String name;
        private int thinkTimeMs;

        public DoctorTask(String name, int thinkTimeMs) {
            this.name = name;
            this.thinkTimeMs = thinkTimeMs;
        }

        @Override
        public void run() {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                // 為了展示悲觀鎖的等待效果，我們必須關閉自動提交，手動控制交易
                conn.setAutoCommit(false);

                if (USE_OPTIMISTIC) {
                    doOptimisticLocking(conn);
                } else {
                    doPessimisticLocking(conn);
                }

                conn.commit();
            } catch (Exception e) {
                log(name, "發生系統異常：" + e.getMessage());
            }
        }

        private void doOptimisticLocking(Connection conn) throws SQLException, InterruptedException {
            // 1. 讀取資料
            int currentVersion = 0;
            String selectSql = "SELECT * FROM locking_test WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(selectSql);
                 ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    currentVersion = rs.getInt("version");
                    log(name, "開啟醫囑，看到病人：" + rs.getString("patient_name") + " (Version: " + currentVersion + ")");
                }
            }

            // 模擬看畫面、打字的時間
            log(name, "正在修改醫囑...");
            Thread.sleep(thinkTimeMs);

            // 2. 準備存檔
            log(name, "點擊「儲存」！準備寫入資料庫...");
            
            // 提示 1 & 2: 建立 SQL 與 PreparedStatement
            // 🚨 關鍵修正：除了 WHERE 條件，存檔時也必須把 version + 1，否則版本號永遠不變！
            String sql = "UPDATE locking_test SET order_content = ?, version = version + 1 WHERE id = 1 AND version = ?";
            
            // 🚨 關鍵修正：PreparedStatement 是一個 Interface，不能用 new，必須透過 conn 產生
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name + " 修改的醫囑 (樂觀鎖)");
                pstmt.setInt(2, currentVersion);
                
                // 提示 3: 呼叫 executeUpdate()
                int rows = pstmt.executeUpdate();
                
                // 提示 4: 判斷該 int 是否為 0
                if (rows > 0) {
                    log(name, "存檔成功！(Version 變為 " + (currentVersion + 1) + ")");
                } else {
                    log(name, "⚠️ 系統提示：資料已被其他人修改，請重新整理！");
                }
            }
        }

        private void doPessimisticLocking(Connection conn) throws SQLException, InterruptedException {
            /* =========================================================
             * TODO: 請在這裡實作「悲觀鎖」的 SELECT ... FOR UPDATE 邏輯！
             * =========================================================
             * 提示 1: 只要把下面這句 selectSql 補上悲觀鎖的關鍵字即可。
             */
            String selectSql = "SELECT * FROM locking_test WHERE id = 1 FOR UPDATE"; 
            
            try (PreparedStatement pstmt = conn.prepareStatement(selectSql);
                 ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    log(name, "成功取得並鎖定資料！病人：" + rs.getString("patient_name"));
                }
            }
            /* ========================================================= */

            log(name, "正在修改醫囑 (霸佔資料中)...");
            Thread.sleep(thinkTimeMs);

            log(name, "點擊「儲存」！準備寫入資料庫並釋放鎖...");
            
            // 悲觀鎖因為一開始就鎖定了，更新時就不需要再檢查 version 了
            String updateSql = "UPDATE locking_test SET order_content = ? WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                pstmt.setString(1, name + " 修改的醫囑 (悲觀鎖)");
                pstmt.executeUpdate();
                log(name, "存檔成功！鎖即將釋放。");
            }
        }
    }
}
