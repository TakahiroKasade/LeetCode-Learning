package java_fundamentals.week01;

import java.util.ArrayList;

/**
 * 練習題目：ArrayList 動態陣列基礎操作
 * 任務內容：
 * 1. 初始化 ArrayList<String>
 * 2. 使用 add() 新增元素
 * 3. 使用 size() 與 get() 查詢資料
 * 4. 使用 remove() 刪除指定索引的資料
 * 
 * @author Takahiro
 * @date 2026/04/16
 */
public class ArrayListPractice {

    public static void main(String[] args) {
        // 1. 初始化 ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // 2. 新增 (Add) 水果
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");
        System.out.println("目前的水果有: " + fruits);

        // 3. 查詢數量 (Size)
        System.out.println("目前水果數量: " + fruits.size());

        // 4. 取得指定索引的元素 (Get)
        // 取得第 2 個水果（索引為 1）
        System.out.println("取得第 2 個水果: " + fruits.get(1));

        // 5. 刪除元素 (Remove)
        // 刪除第 1 個水果（索引為 0）
        fruits.remove(0);
        System.out.println("刪除後，目前的內容為: " + fruits);
        System.out.println("刪除後的水果數量: " + fruits.size());
    }
}
