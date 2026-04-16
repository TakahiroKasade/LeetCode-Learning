package java_fundamentals.week01;

/**
 * 練習題目：方法重載 (Method Overloading)
 * 任務內容：
 * 1. 實作第一個 getMax(int a, int b)，回傳兩數中的最大值
 * 2. 實作第二個 getMax(int a, int b, int c)，回傳三數中的最大值
 * 3. 提示：在三數版本中，可以呼叫兩數版本的方法來簡化邏輯
 * 4. 進階挑戰：實作 printInfo(String name) 與 printInfo(String name, int age) 的混合型別重載
 * 5. 在 main 方法中測試上述所有版本
 * 
 * @author Takahiro
 * @date 2026/04/16 (提前開始週五進度)
 */
public class MethodOverloadingPractice {

    public static void main(String[] args) {
        // 1. 測試兩數版本
        int result1 = getMax(20, 0);
        System.out.println("兩數最大值 (20, 0): " + result1);

        // 2. 測試三數版本
        int result2 = getMax(50, 120, 100);
        System.out.println("三數最大值 (50, 120, 100): " + result2);
        
        String result3= printInfo("Sam");
        System.out.println(result3);
        
        String result4= printInfo("Sam",20);
        System.out.println(result4);
    }

    /**
     * 比較兩個整數並回傳較大者 (基礎版本)
     */
    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * 比較三個整數並回傳最大者 (重載版本)
     * 活用已定義的兩數版本來簡化邏輯
     */
    public static int getMax(int a, int b, int c) {
        // 先找出 a 和 b 的冠軍
        int tempMax = getMax(a, b);
        // 拿冠軍去跟 c 進行最終對決
        return getMax(tempMax, c);
    }
    
    /**
     * 混合型別重載練習 1：印出姓名訊息
     */
    public static String printInfo(String name) {
        return "你好，" + name;
    }

    /**
     * 混合型別重載練習 2：印出姓名與年紀訊息
     */
    public static String printInfo(String name, int age) {
        return name + " 今年 " + age + " 歲";
    }
}
