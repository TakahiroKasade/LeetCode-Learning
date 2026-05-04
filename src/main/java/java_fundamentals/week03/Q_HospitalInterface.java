package java_fundamentals.week03;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <h3>第三週 OOP 設計實戰：抽象類別與介面 (Abstract & Interface)</h3>
 * 
 * <p><strong>題目背景：</strong><br>
 * 醫院系統需要處理各種「文件」，例如「手術紀錄 (OperationRecord)」與「員工考勤報表 (StaffReport)」。
 * 這些文件在本質上不同，但都需要具備「匯出資料」的能力。</p>
 * 
 * <p><strong>實作任務：</strong></p>
 * <ul>
 *   <li><b>1. 定義介面 Exportable：</b>
 *     <ul>
 *       <li>方法：<code>void exportData()</code></li>
 *     </ul>
 *   </li>
 *   <li><b>2. 定義抽象類別 MedicalDocument：</b>
 *     <ul>
 *       <li>屬性：<code>documentId</code>, <code>createDate</code></li>
 *       <li>方法：提供一個非抽象方法 <code>showInfo()</code> 印出基本資訊。</li>
 *     </ul>
 *   </li>
 *   <li><b>3. 實作 OperationRecord：</b>
 *     <ul>
 *       <li>繼承 <code>MedicalDocument</code> 並實作 <code>Exportable</code> 介面。</li>
 *     </ul>
 *   </li>
 *   <li><b>4. 實作 StaffReport：</b>
 *     <ul>
 *       <li>不繼承 <code>MedicalDocument</code> (因為報表不屬於醫療文件)，但實作 <code>Exportable</code> 介面。</li>
 *     </ul>
 *   </li>
 *   <li><b>5. 測試多型：</b>
 *     <ul>
 *       <li>建立一個 <code>Exportable</code> 類型的陣列，同時放入手術紀錄與員工報表，並統一呼叫 <code>exportData()</code>。</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * @author Takahiro
 * @date 2026/04/29
 */
public class Q_HospitalInterface {

    public static void main(String[] args) {
        // 任務：測試介面的多型運用
    		Exportable[] exportlist = new Exportable[2] ;

    		OperationRecord op = new OperationRecord();
    		op.documentId = 101;
    		op.createDate = LocalDateTime.now();
            
    		exportlist[0] = op;
    		exportlist[1] = new StaffReport();
    	    // 3. 統一呼叫匯出功能
    	    System.out.println("=== 醫院匯出系統啟動 ===");
    	    
    	    for (Exportable item : exportlist) {
    	        item.exportData(); // 不管你是誰，只要你有簽 Exportable 合約，我就能叫你匯出！
    	        System.out.println("--------------------");
    	    }

    }

}

// 1. 在此處定義介面 Exportable
	interface Exportable {
		void exportData();
	}
// 2. 在此處定義抽象類別 MedicalDocument
	abstract class  MedicalDocument {
		protected int documentId ;
		protected LocalDateTime createDate ;
		
		void showInfo() {
			System.out.println("印出基本資訊: " + documentId  + "，" + createDate);
		}
	}
// 3. 在此處定義實作類別
	class OperationRecord extends MedicalDocument  implements Exportable{
		
		@Override
		public void exportData() {
			showInfo();
		    System.out.println("正在匯出手術紀錄 PDF...");
		}
	}
	class StaffReport implements Exportable{
		
		public void exportData() {
				
		}
		
	}
	
	
