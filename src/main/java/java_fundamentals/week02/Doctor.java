package java_fundamentals.week02;


/**
 * 醫師資訊實體類別
 * 用於存放 HIS 系統中醫師的基本資料與診斷行為。
 * 
 * @author Takahiro
 * @date 2026/04/20
 */
public class Doctor {

	/**
	 * 【任務 1：無參建構子】
	 * 預設值：工號="D000", 姓名="未命名", 科別="一般科"
	 */
	public Doctor() {
		this("D000", "未命名", "一般科");
	}
	
	/**
	 * 【任務 2：兩參數建構子】
	 * 只給工號與姓名，科別預設為 "一般科"
	 */
	public Doctor(String doctorId, String doctorName) {
		this(doctorId, doctorName, "一般科");
	}
	
	/**
	 * 【核心建構子】
	 */
	public Doctor(String doctorId, String doctorName, String dept) {
		this.doctorId = doctorId;
		this.setDoctorName(doctorName);;
		this.dept = dept;
		
	}


	private String doctorId;           // 醫師工號
	private String doctorName;         // 醫師姓名
	private String dept;               // 所屬科別
	private String title;              // 職稱 (如：主治醫師)
	private String roomCode;           // 診間代碼
	private int yearsOfExperience;     // 醫師年資
	
	// --- Getters and Setters (為了讓你方便練習，我先幫你補齊) ---

	public String getDoctorId() { return doctorId; }
	public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

	public String getDoctorName() { return doctorName; }
	public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

	public String getDept() { return dept; }
	public void setDept(String dept) { this.dept = dept; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getRoomCode() { return roomCode; }
	public void setRoomCode(String roomCode) { this.roomCode = roomCode; }

	public int getYearsOfExperience() { return yearsOfExperience; }
	
	//確保年資不能為負數。
	public void setYearsOfExperience(int yearsOfExperience) { 
		if(yearsOfExperience<0) {
			System.out.println("醫生年資，不得為負!!");
			return;
		}
		this.yearsOfExperience = yearsOfExperience; 
	}

	/**
	 * 【核心邏輯挑戰】診斷病人
	 * 請在 HospitalSystem 中調用此方法，並傳遞一個 Patient 物件。
	 * 
	 * @param patient 被診斷的病人物件
	 */
	public void diagnose(Patient patient) {
		
		System.out.println(" [醫師姓名] 醫師正在為 [病人姓名] 進行診斷..." + doctorName + " 醫師正在為 " + patient.getPatientName() + " 進行診斷...");
		patient.setPrimaryDiagnosis("感冒");
		System.out.println("診斷完成，結果為： " + patient.getPrimaryDiagnosis());
		
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", dept=" + dept + ", title=" + title
				+ ", roomCode=" + roomCode + ", yearsOfExperience=" + yearsOfExperience + "]";
	}
}
