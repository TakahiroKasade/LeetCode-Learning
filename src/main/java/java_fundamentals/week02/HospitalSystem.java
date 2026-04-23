package java_fundamentals.week02;

/**
 * 🏥 醫院管理系統 - 實戰練習
 * 
 * 今日練習目標：
 * 1. 實體化實作：練習使用 new 關鍵字產生 Patient 物件。
 * 2. 欄位賦值：透過點運算子 (.) 存取成員變數。
 * 3. 預設值觀念：觀察未賦值變數的 Initial Value (例如 String 是 null, int 是 0)。
 * 4. 記憶體地址：觀察直接印出物件時的十六進位 HashCode。
 * 
 * 任務步驟：
 * [ ] 建立 Patient 物件 p1，並設定其姓名、病歷號與年紀。
 * [ ] 建立 Patient 物件 p2，但不設定任何值。
 * [ ] 使用 System.out.println 印出 p1 的所有設定資訊。
 * [ ] 使用 System.out.println 印出 p2 的姓名與年紀，觀察預設值。
 * [ ] (加分題) 分別印出 p1 與 p2，看看會顯示什麼？
 * 
 * @author Takahiro
 * @date 2026/04/20
 */
public class HospitalSystem {

	
	public HospitalSystem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		/*
		System.out.println("=== 測試Patient開始 ===");
		 // 1. 使用無參建構子
	    Patient pNoArg = new Patient();
	    System.out.println("無參病人結果：" + pNoArg.getPatientName() + ", 性別：" + pNoArg.getGender());
	    System.out.println("---------------");
	    // 2. 使用兩參數建構子
	    Patient pTwoArg = new Patient("小明", 25);
	    System.out.println("兩參數病人結果：" + pTwoArg.getPatientName() + ", 身分證：" + pTwoArg.getIdCard());
	    System.out.println("---------------");
	    // 3. 使用四參數建構子
	    Patient pFull = new Patient("大壯", "男", "A123456789", 40);
	    System.out.println("四參數病人結果：" + pFull.getPatientName());
	    System.out.println("=== 測試結束 ===");
	    */
	    
	    System.out.println("=== 測試Doctor開始 ===");
	    Doctor dNoArg = new Doctor();
	    System.out.println("無參醫師結果：" + dNoArg.getDoctorId() + ", 醫師姓名：" + dNoArg.getDoctorName());
	    System.out.println("---------------");
	    // 2. 使用兩參數建構子
	    Doctor dTwoArg = new Doctor("D007", "龐德");
	    System.out.println("兩參數病人結果：" + dTwoArg.getDoctorId() + ", 醫師姓名：" + dTwoArg.getDoctorName());
	    System.out.println("---------------");
	    
		
		// 1. 使用「核心欄位建構子」直接建立病人 (姓名, 性別, 身分證, 年紀)
		Patient p1 = new Patient("Sam","男","A123456789",50);
		Patient p2 = new Patient();
		Patient p3 = new Patient("大雄", "男", "B987654321", 40);

		System.out.println("p1 的病歷號：" + p1.getChartNo());
		System.out.println("p2 的病歷號：" + p2.getChartNo());
		System.out.println("p3 的病歷號：" + p3.getChartNo());

		
		// 醫師工號, 醫師姓名, 科別
		Doctor d1 = new Doctor("D001", "吳依弘", "心臟外科");

		    
		// 2. 剩下的臨床資料再用 setter 補上
			p1.setAccountNo("I1100016234");
			p1.setPrimaryDiagnosis("末稍血管修補及吻合術");
			p1.setTemperature(42.5);
			//p2=p1;
			p2.setPatientName("Tom");
			
			d1.diagnose(p1);
			d1.setYearsOfExperience(-1);
			 
			System.out.println(" p1 的所有設定資訊: " + p1.toString());
			System.out.println(" p2 的姓名與年紀，觀察預設值: " + p2.toString());
			System.out.println(" d1 的所有設定資訊: " + d1.toString());
			
			System.out.println("p1的地址: " + p1.hashCode());
			System.out.println("p2的地址: " + p2.hashCode());
			System.out.println("p3的地址: " + p3.hashCode());

			// 直接用「類別名稱」呼叫，不用 p1 或 p2
			System.out.println("目前全院總人數：" + Patient.getTotalPatients());

			//System.out.println(p3.getPatientName().length()); //會發生NullPointException
	}

}
