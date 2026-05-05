package java_fundamentals.week04;

/**
 * 【自定義異常類別】
 * 繼承 Exception 代表這是一個「受檢異常」，強迫呼叫者必須處理。
 */
class HighFeverException extends Exception {
    public HighFeverException(String message) {
        super(message); // 將錯誤訊息傳給父類別 Exception
    }
}

/**
 * 【實作練習】
 * 模擬醫院的體溫監控系統。
 */
public class Q_CustomMedicalException {

    public static void main(String[] args) {
        try {
            checkTemperature(37.2); // 正常體溫
            checkTemperature(39.5); // 高燒，會拋出異常
        } catch (HighFeverException e) {
            // 3. TODO: 在這裡捕捉並印出異常訊息
            System.err.println("🚨 警報：系統捕捉到異常！" + e.getMessage());
        }
    }

    /**
     * 檢查體溫，如果超過 38 度就拋出異常。
     * 
     * @param temp 體溫
     * @throws HighFeverException 這裡必須宣告 throws，因為它是受檢異常
     */
    public static void checkTemperature(double temp) throws HighFeverException {
        System.out.println("正在檢查體溫：" + temp + " °C");
        
        // 1. TODO: 如果 temp > 38.0，就 throw 一個新的 HighFeverException
        if (temp > 38.0) {
            throw new HighFeverException("體溫過高");
        }
        
        System.out.println("✅ 體溫正常，繼續監控。\n");
    }
}
