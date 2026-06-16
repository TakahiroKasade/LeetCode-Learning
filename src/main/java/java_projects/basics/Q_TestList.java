package java_projects.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q_TestList {
    public static void main(String[] args) {
	        int size = 100000; // 十萬筆資料
	        List<Integer> arrayList = new ArrayList<>();
	        List<Integer> linkedList = new LinkedList<>();
	
	        // 1. 初始化資料
	        for (int i = 0; i < size; i++) {
	            arrayList.add(i);
	            linkedList.add(i);
	        }
	
	        // 2. 測試隨機讀取第 50000 筆資料 10000 次的耗時
	        long startTime = System.nanoTime();
	        for (int i = 0; i < 10000; i++) {
	            arrayList.get(50000); // ArrayList 空降讀取
	        }
	        long endTime = System.nanoTime();
	        System.out.println("ArrayList 耗時: " + (endTime - startTime) / 1000000 + " 毫秒");
	
	        // 3. 測試 LinkedList 讀取
	        startTime = System.nanoTime();
	        for (int i = 0; i < 10000; i++) {
	            // 🔴 請在此處呼叫 linkedList 讀取第 50000 筆資料的方法：
	        		linkedList.get(50000);
	        }
	        endTime = System.nanoTime();
	        System.out.println("LinkedList 耗時: " + (endTime - startTime) / 1000000 + " 毫秒");
    }
}
