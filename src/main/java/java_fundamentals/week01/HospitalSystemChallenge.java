package java_fundamentals.week01;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 🏥 第一週 Java 終極整合挑戰：醫院門診管理系統
 * 
 * 本題目將結合本週所學：ArrayList、HashMap、方法重載 (Overloading) 與 迴圈控制。
 * 請依照 Javadoc 中的任務說明，在不看筆記的情況下試著手寫實現。
 * 
 * 任務需求：
 * 1. 在 main 方法中，建立一個 ArrayList<String> 存放「科別」(例如：內科、外科、兒科)。
 * 2. 建立一個 HashMap<Integer, String> 存放「診間分配」(Key: 診間號碼, Value: 醫生姓名)。
 * 
 * 3. 實作靜態方法 addRoom：
 *    - 輸入：Map, 診間號碼, 醫生姓名。
 *    - 邏輯：檢查診間是否已被佔用（使用 containsKey），若已被佔用則印出「警告：診間已有人！」；
 *            若未被佔用，則存入 map 並印出「分配成功」。
 * 
 * 4. 實作靜態方法 printStatus：
 *    - 使用 keySet() 遍歷所有的診間，印出目前的「[診間號碼]：[醫生姓名]」。
 * 
 * 5. 實作「方法重載 (Method Overloading)」練習（方法名均為 findInfo）：
 *    - 版本 A (int roomNo)：傳入診間號碼，印出該診間的醫生是誰。
 *    - 版本 B (String docName)：傳入醫生姓名，遍歷 Map 找出該醫生在哪個診間。
 * 
 * @author Takahiro
 * @date 2026/04/17
 */
public class HospitalSystemChallenge {

    public static void main(String[] args) {
        // --- 1. 資料初始化 ---
        // TODO: 建立 ArrayList 存科別
    		ArrayList<String> costName = new ArrayList<String>();
    		costName.add("內科");
    		costName.add("外科");
    		costName.add("兒科");
        // TODO: 建立 HashMap 存診間分配
    		HashMap<Integer, String> roomMap = new HashMap<Integer, String>();
    		roomMap.put(1, "Bob");
    		roomMap.put(2, "Sam");
    		roomMap.put(3, "Takahiro");
        // --- 2. 測試分配診間 ---
        // TODO: 呼叫三次 addRoom
    		addRoom(roomMap,4,"Star");
    		addRoom(roomMap,5,"Candy");
    		addRoom(roomMap,1,"Vic");
        // --- 3. 印出目前狀態 ---
        // TODO: 呼叫 printStatus
    		printStatus(roomMap);
        
        // --- 4. 測試搜尋 (Overloading) ---
        // TODO: 呼叫 findInfo (傳入數字)
    		findInfo(roomMap,2);
        // TODO: 呼叫 findInfo (傳入字串)
    		findInfo(roomMap,"Takahiro");
    }

    /**
     * 分配診間邏輯
     */
    public static void addRoom(HashMap<Integer, String> map, int roomNo, String doctor) {
        // TODO: 實作邏輯
	    	
	    	if(map.containsKey(roomNo)) {
	    		System.out.println("警告：診間已有人！");
	    	}else {
	    		map.put(roomNo, doctor);
	    		//則存入 map 並印出「分配成功」。
	    		System.out.println("分配成功" + map);
	    	}
	    	
    }

    /**
     * 顯示所有診間進度
     */
    public static void printStatus(HashMap<Integer, String> map) {
        // TODO: 實作遍歷邏輯 (keySet)
    		for (int roomNo : map.keySet()) {
    			//「[診間號碼]：[醫生姓名]」。
				System.out.println("[診間號碼]" + roomNo + ":" + "[醫生姓名]" +map.get(roomNo) );
			}
    }

    // --- 以下為 Method Overloading 練習區 ---

    /**
     * 搜尋任務 A：透過診間找醫生
     */
    public static void findInfo(HashMap<Integer, String> map, int roomNo) {
        // TODO: 實作邏輯
    		map.get(roomNo);
    		System.out.println("透過診間找醫生: "+map.get(roomNo) );
    }

    /**
     * 搜尋任務 B：透過醫生找診間
     */
    public static void findInfo(HashMap<Integer, String> map, String doctorName) {
        // TODO: 實作邏輯 (需要遍歷 Map)
    		for (int room : map.keySet()) {
    			
    			String docInRoom= map.get(room);
    			
    			if(docInRoom.equals(doctorName)) {
    				System.out.println("透過醫生找診間: "+room );
    			}
    			
		}
    }
}
