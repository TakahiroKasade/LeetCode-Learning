package java_fundamentals.week01;

public class OddEvenCheck {

   /**
     * 練習題目：奇偶數判斷
     * 目的：練習條件判斷式 (if-else) 與取餘數運算子 (%)。
     * 運作邏輯：輸入一整數，判斷其除以 2 的餘數是否為 0。
     * @param num 要判斷的整數
     */

    public static void main(String[] args) {
        
        int num = 48 ;
        if(num%2==0){System.out.println(num+"是偶數");}
        else{System.out.println(num+"是奇數");}

    }

}
