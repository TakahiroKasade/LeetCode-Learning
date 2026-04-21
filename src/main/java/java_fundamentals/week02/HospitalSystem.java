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

	public static void main(String[] args) {

		Patient p1 = new Patient();
		Patient p2 = new Patient();
		Patient p3 = new Patient(); 
		Doctor d1 = new Doctor();
		p1.setPatientName("Sam");
		p1.setAccountNo("I1100016234");
		p1.setAge(500);
		p1.setPrimaryDiagnosis("末稍血管修補及吻合術");
		p1.setTemperature(42.5);
		p2=p1;
		p2.setPatientName("Tom");
		
		d1.setDoctorName("吳依弘");
		d1.diagnose(p1);
		d1.setYearsOfExperience(-1);
		 
		System.out.println(" p1 的所有設定資訊: " + p1.toString());
		System.out.println(" p2 的姓名與年紀，觀察預設值: " + p2.toString());
		System.out.println(" d1 的所有設定資訊: " + d1.toString());
		
		System.out.println("p1的地址: " + p1.hashCode());
		System.out.println("p2的地址: " + p2.hashCode());
		
		
		//System.out.println(p3.getPatientName().length()); //會發生NullPointException
		
	}

}
