package java_fundamentals.week01;

public class MultiplicationTable {

    /**
     * 練習題目：九九乘法表
     * 目的：練習巢狀迴圈 (Nested Loop) 與格式化輸出。
     * 運作邏輯：外層迴圈控制被乘數 (1-9)，內層迴圈控制乘數 (1-9)，
     *         每跑完一輪內層迴圈後執行換行。
     */
    
    public static void main(String[] args) { 
        for(int i =1; i<=9;i++) {
            for(int j=1; j<=9  ; j++) {
                System.out.print(i + " x " + j + " = " + (i*j)+ "  ");
            }
            System.out.println();
        }
    }
}