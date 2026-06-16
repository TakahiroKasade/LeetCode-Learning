package java_projects.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q_TestPagination {
    // 模擬資料庫中的一筆記錄
    static class Record {
        int id;
        String data;

        Record(int id, String data) {
            this.id = id;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int totalRecords = 1000000; // 模擬資料庫有 100 萬筆記錄
        List<Record> dbTable = new ArrayList<>(totalRecords);

        // 1. 初始化模擬資料庫資料
        for (int i = 1; i <= totalRecords; i++) {
            dbTable.add(new Record(i, "RecordData_" + i));
        }

        int offset = 800000; // 模擬深分頁，查詢第 80 萬筆開始的資料
        int limit = 10;      // 每頁 10 筆
        int lastSeenId = 800000; // 鍵值分頁（Keyset）使用的前一次最後 ID

        // --- 🟢 模擬第一種：OFFSET 分頁 (Offset-based) ---
        // 邏輯：必須從頭掃描到 offset + limit，然後捨棄前 offset 筆
        long startTime = System.nanoTime();
        List<Record> offsetResult = new ArrayList<>();
        
        // 🔴 請在下方完成 OFFSET 掃描的程式碼：
        // 提示：寫一個迴圈，從索引 0 開始遍歷到 offset + limit - 1
        // 當索引大於等於 offset 時，將資料 dbTable.get(i) 加入 offsetResult 中。
       for (int i = 0; i < offset+limit ; i++) {
	    	   if(i>=offset) {
	    		   offsetResult.add(dbTable.get(i));
	    	   }
       }
        
        long endTime = System.nanoTime();
        System.out.println("Offset 分頁結果筆數: " + offsetResult.size() + "，耗時: " + (endTime - startTime) / 1000000.0 + " 毫秒");

        // --- 🔵 模擬第二種：Keyset / Cursor 分頁 (鍵值分頁) ---
        // 邏輯：利用索引直接定位（這裡直接用 ID 作為索引，等同於 O(1) 定位），直接從 lastSeenId 的下一個位置開始讀取 limit 筆
        startTime = System.nanoTime();
        List<Record> keysetResult = new ArrayList<>();
        
        // 🔴 請在下方完成 Keyset 直接定位讀取的程式碼：
        // 提示：既然已經知道最後一筆的 ID 是 lastSeenId，代表可以直接從它的下一個位置（即索引為 lastSeenId）開始讀取。
        // 提示：用迴圈從 lastSeenId 開始，遍歷到 lastSeenId + limit - 1，並將資料 dbTable.get(i) 加入 keysetResult 中。
        for(int i=lastSeenId; i<  lastSeenId + limit  ; i++) {
        		keysetResult.add(dbTable.get(i));
        }
        
        endTime = System.nanoTime();
        System.out.println("Keyset 分頁結果筆數: " + keysetResult.size() + "，耗時: " + (endTime - startTime) / 1000000.0 + " 毫秒");
    }
}
