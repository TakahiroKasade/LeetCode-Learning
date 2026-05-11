package java_projects;

import java.util.LinkedList;

/**
 * 【題目背景與情境】
 * 醫院藥局需要一個快速統計系統，用來計算當日各類藥品的領用次數。
 * 為了理解 HashMap 的底層原理，你需要手動實作一個「桶位 (Bucket)」系統。
 * 
 * 【實作任務】
 * 1. 實作 getBucketIndex 方法：將藥名轉換為 0-9 的數字。
 * 2. 處理「碰撞」：當兩個藥名對應到同一個 Index 時，使用 LinkedList 儲存。
 * 3. 模擬 put 邏輯：如果藥名已存在，次數 +1；若不存在，新增一個紀錄。
 *
 * @author Takahiro
 * @date 2026-05-11
 */
public class Q_SimpleHashSimulation {

    // 模擬 HashMap 的底層陣列（桶位），大小固定為 10
    // 每個桶位裡面存放一個 LinkedList，用來處理碰撞 (Chaining)
    @SuppressWarnings("unchecked")
    private static LinkedList<DrugEntry>[] buckets = new LinkedList[10];

    static {
        // 初始化陣列，每個位置都先放一個空的 LinkedList
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * 藥品紀錄實體類
     */
    static class DrugEntry {
        String drugName;
        int count;

        DrugEntry(String drugName, int count) {
            this.drugName = drugName;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("[%s: %d]", drugName, count);
        }
    }

    public static void main(String[] args) {
        String[] medicineInflow = {"Aspirin", "Panadol", "Insulin", "Aspirin", "Vitamin", "Panadol", "Morphine"};

        for (String medicine : medicineInflow) {
            addMedicine(medicine);
        }

        // 印出結果，觀察哪些藥品在同一個「桶位」
        printBuckets();
    }

    /**
     * 核心邏輯：將藥品加入對應的桶位
     */
    public static void addMedicine(String medicine) {
        // 1. 計算 Index (呼叫 getBucketIndex)
        int index = getBucketIndex(medicine);

        // 2. 取得該 Index 對應的 LinkedList
        LinkedList<DrugEntry> bucket = buckets[index];

        // 3. TODO: 遍歷該 LinkedList
        //    - 如果找到相同的藥名 (equals)，則 count++
        for(DrugEntry entry : bucket) {
            if(entry.drugName.equals(medicine)) {
                entry.count++; 
                return;
            }
        }
        //    - 如果遍歷完整個 List 都沒找到，則新增一個 DrugEntry(medicine, 1) 加入 List
        bucket.add(new DrugEntry(medicine, 1));
        System.out.println("處理藥品: " + medicine + " -> 存入桶位: " + index);
    }

    /**
     * 計算 Hash 指數
     * 提示：可以使用 medicine.hashCode()，但要確保結果在 0-9 之間
     */
    public static int getBucketIndex(String medicine) {
        // TODO: 實作你的 Hash 算法 (確保回傳值為 0-9)
        int hash = medicine.hashCode();
        int index = hash % 10;
        if(index<0) {index=index*-1;}
        return index; 
    }

    public static void printBuckets() {
        System.out.println("\n--- 目前桶位分布狀況 ---");
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket " + i + ": " + buckets[i]);
        }
    }
}
