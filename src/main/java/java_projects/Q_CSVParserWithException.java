package java_projects;

import java.util.*;

/**
 * 【題目背景：醫院健保資料上傳系統】
 * 醫院每天需要上傳大量的藥品批發紀錄 CSV 到健保局系統。
 * 過去的系統非常脆弱，只要 CSV 裡有一行格式錯誤（例如金額是文字、日期格式不對），
 * 整個程式就會拋出 Exception 並直接當掉，導致剩下的幾千筆資料都沒處理。
 *
 * 【實作任務】
 * 你需要實作一個「強健型 CSV 解析器」，要求：
 * 1. 逐行讀取 CSV 資料。
 * 2. 使用 Try-Catch 機制：當某一行出錯時，必須攔截異常，紀錄錯誤原因，並讓程式「繼續處理下一行」。
 * 3. 自定義異常：當金額為負數時，請拋出自定義的 `InvalidMedicalDataException`。
 * 4. 統計結果：最後要輸出「成功處理幾筆」、「失敗幾筆」。
 *
 * 【模擬資料格式】
 * drug_name,price,quantity
 * Aspirin,100,5
 * BadDrug,ABC,10  <-- 這行 price 格式錯誤 (NumberFormatException)
 * Panadol,-50,2   <-- 這行金額為負 (應拋出自定義異常)
 * Vitamin,200,3
 *
 * @author Takahiro
 * @date 2026-05-08
 */
public class Q_CSVParserWithException {

    public static void main(String[] args) {
        // 模擬 CSV 的每行資料 (實務上會從檔案讀取)
        List<String> csvRows = Arrays.asList(
            "Aspirin,100,5",
            "BadDrug,ABC,10",
            "Panadol,-50,2",
            "Vitamin,200,3",
            "Insulin,300,invalid"
        );
        System.out.println(csvRows);//[Aspirin,100,5, BadDrug,ABC,10, Panadol,-50,2, Vitamin,200,3, Insulin,300,invalid,  ,XX, ]
        csvRows.set(0,"NewDrug,400,8");
        System.out.println(csvRows); //[Aspirin,100,5, BadDrug,ABC,10, Panadol,-50,2, Vitamin,200,3, Insulin,300,invalid,  ,XX, , NewDrug,400,8]
        //csvRows.add("NewDrug,400,8");
        //System.out.println(csvRows); //UnsupportedOperationException //[Aspirin,100,5, BadDrug,ABC,10, Panadol,-50,2, Vitamin,200,3, Insulin,300,invalid,  ,XX, , NewDrug,400,8]    
        // csvRows.remove("BadDrug,ABC,10");
        //System.out.println(csvRows); //UnsupportedOperationException

        int successCount = 0;
        int failureCount = 0;

        System.out.println("--- 健保資料解析啟動 ---");

        for (String row : csvRows) {
            try {
                // 1. 分割字串，並檢查欄位數量
                String[] data = row.split(",");
                if (data.length < 3) {
                    throw new ArrayIndexOutOfBoundsException("CSV 欄位缺失");
                }

                // 2. 解析資料 (使用 trim() 預防空格)
                String drugName = data[0].trim();
                int price = Integer.parseInt(data[1].trim());
                int quantity = Integer.parseInt(data[2].trim());

                // 3. 業務邏輯檢查 (自定義異常)
                if (price < 0) {
                    throw new InvalidMedicalDataException("價格不能為負數 (" + price + ")");
                }

                successCount++;
                System.out.println("[成功] 藥品: " + drugName + " (總額: " + (price * quantity) + ")");

            } catch (NumberFormatException e) {
                failureCount++;
                System.out.println("[格式錯誤] 行內容: " + row + " (原因: 數字格式不正確)");

            } catch (InvalidMedicalDataException e) {
                failureCount++;
                System.out.println("[邏輯錯誤] 行內容: " + row + " (原因: " + e.getMessage() + ")");

            } catch (Exception e) {
                failureCount++;
                System.out.println("[其他錯誤] 行內容: " + row + " (類型: " + e.getClass().getSimpleName() + ", 訊息: " + e.getMessage() + ")");
            }
        }

        System.out.println("\n--- 處理總結 ---");
        System.out.println("成功筆數: " + successCount);
        System.out.println("失敗筆數: " + failureCount);
    }
}

/**
 * 自定義異常類別
 */
class InvalidMedicalDataException extends Exception {
    public InvalidMedicalDataException(String message) {
        super(message);
    }
}
