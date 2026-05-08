package java_fundamentals.week04;

import java.util.Arrays;

/**
 * 【手寫 ArrayList 練習】
 * 
 * 任務：
 * 1. 實作 add() 方法，當陣列滿了時自動擴容。
 * 2. 實作 ensureCapacity() 方法，負責「搬家」邏輯。
 * 
 * @author Takahiro
 * @date 2026-05-06
 */ 
public class Q_MyArrayListPractice {

    // 底層用來存資料的普通陣列
    private Object[] elementData;
    // 目前存了幾個東西
    private int size;

    // 建構子，預設給 3 個位子（為了方便觀察擴容）
    public Q_MyArrayListPractice() {
        elementData = new Object[3];
        size = 0;
    }

    /**
     * 新增資料
     */
    public void add(Object data) {
        // 1. TODO: 如果目前 size 已經等於陣列長度，代表滿了，要呼叫 ensureCapacity() 擴容
        if (size == elementData.length) {
            ensureCapacity();
        }
        
        // 2. 把資料放進去，並增加 size
        elementData[size++] = data;
        System.out.println("已加入：" + data + " (目前 size=" + size + ", 陣列長度=" + elementData.length + ")");
    }

    /**
     * 擴容（搬家）邏輯
     */
    private void ensureCapacity() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + 2; // 為了示範，我們每次增加 2 個位子
        System.out.println("\n --- 偵測到空間不足，啟動擴容！從 " + oldCapacity + " 變更為 " + newCapacity + " ---");

        /*  方法1: 懶人神器，一行搞定*/  
        elementData = Arrays.copyOf(elementData, newCapacity);
    
        /*  方法2: for迴圈
            // (1) 建立一個長度為 newCapacity 的新陣列
            Object[] newElementData = new Object[newCapacity];
            // (2) 使用 for 迴圈或 System.arraycopy 把舊資料搬過去
            for (int i = 0; i < oldCapacity; i++) {
                newElementData[i] = elementData[i];
            }
            // (3) 把 elementData 指向新陣列
            elementData = newElementData;
        */
    }

    public static void main(String[] args) {
        Q_MyArrayListPractice list = new Q_MyArrayListPractice();
        
        list.add("病人 A");
        list.add("病人 B");
        list.add("病人 C");
        list.add("病人 D"); // 這一筆會觸發擴容！
        list.add("病人 E");
        list.add("病人 F"); // 這一筆又會觸發擴容！

        // 記得 import java.util.Arrays;
        System.out.println("最終名單：" + Arrays.toString(list.elementData));

    }
}
