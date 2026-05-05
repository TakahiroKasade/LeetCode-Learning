package java_fundamentals.week04;

/**
 * 【題目背景與情境】
 * 醫院的系統需要批次處理病人的體重資料（從前端網頁傳來的通常是 String）。
 * 系統需要把這些 String 轉換成 double 來計算麻醉藥劑量。
 *
 * 【觀察任務】
 * 1. 請在 Eclipse 中直接執行這支程式。
 * 2. 觀察 Console 噴出的紅色錯誤訊息（體會一下什麼叫程式崩潰 / Crash）。
 * 3. 觀察程式最後有沒有印出「HIS 系統處理完畢」這句話？為什麼？
 *
 * @author Takahiro
 * @date 2026-05-05
 */
public class Q_ExceptionExperience {

    public static void main(String[] args) {
        System.out.println("--- HIS 系統開始處理病人體重資料 ---\n");

        // 模擬從前端傳來的陣列，第三筆資料不小心混入了中文字
        String[] patientWeights = {"65.5", "80.0", "60公斤", "50.2"};

        for (int i = 0; i < patientWeights.length; i++) {
            System.out.println("正在處理第 " + (i + 1) + " 位病人的資料：" + patientWeights[i]);
            
            try {
	            	  // 將字串轉為數字 (注意這裡！)
            		double weight = Double.parseDouble(patientWeights[i]);
                 System.out.println("✅ 轉換成功！該病患體重為：" + weight + " kg\n");
			} catch (NumberFormatException  e) {
				System.out.println("格式錯誤，略過此筆資烙");
			}finally {
				
			}
            
        }

        // 觀察重點：這句話最後會被印出來嗎？
        System.out.println("--- 🟢 HIS 系統處理完畢，開始計算劑量 ---");
    }
}
