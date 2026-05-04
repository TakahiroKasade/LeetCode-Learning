package java_fundamentals.week03;

/**
 * <h3>第三週 OOP 異常處理實戰：醫院系統安全機制 (Exception Handling)</h3>
 * 
 * <p><strong>題目背景：</strong><br>
 * 在醫院系統中，輸入錯誤的員工編號或存取到尚未建立的資料是常有的事。<br>
 * 我們需要建立一套異常處理機制，確保系統不會因為一個人的輸入錯誤就整個當機。</p>
 * 
 * <p><strong>實作任務：</strong></p>
 * <ul>
 *   <li><b>1. 處理 NullPointerException：</b>
 *     <ul>
 *       <li>在 <code>main</code> 方法中建立一個長度為 3 的 String 陣列。</li>
 *       <li>不給予任何初值，直接嘗試呼叫 <code>array[0].length()</code>。</li>
 *       <li>使用 <code>try-catch</code> 捕捉錯誤，並印出「錯誤：存取到空物件」。</li>
 *     </ul>
 *   </li>
 *   <li><b>2. 拋出與捕獲自定義異常：</b>
 *     <ul>
 *       <li>建立一個方法 <code>checkStaffId(int id)</code>。</li>
 *       <li>如果 <code>id < 0</code>，使用 <code>throw</code> 拋出一個 <code>IllegalArgumentException</code>。</li>
 *       <li>在 <code>main</code> 中呼叫此方法，並捕捉該異常。</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * @author Takahiro
 * @date 2026/04/30
 */
public class Q_HospitalException {


	public static void main(String[] args) {
        // 任務 1：處理 NullPointerException
        try {
            String[] staffNames = new String[3];
            int length = staffNames[0].length();
        } catch (NullPointerException e) {
             // 當地雷爆炸時，執行這裡
            System.out.println("抓到錯誤了：員工姓名還沒初始化喔！");
        }
       
        // 任務 2：呼叫 checkStaffId 並處理異常
        try {
			checkStaffId(-5);
		} catch (Exception e) {
            System.out.println("錯誤：編號輸入不合法");
		}
    }

    /**
     * 檢查員工編號是否合法。
     * @param id 員工編號
     * @throws Exception 
     * @throws IllegalArgumentException 當編號小於 0 時
     */
    public static void checkStaffId(int id) throws Exception {
        // 實作檢查邏輯
    		if( id < 0) {
                throw new IllegalArgumentException("ID 不可為負數");
    		}
        
    }

}
