package java_fundamentals.week02;

/**
 * 病人資訊實體類別
 * 用於存放 HIS 系統中手術病人的基本資料與手術相關資訊。
 * 
 * @author Takahiro
 * @date 2026/04/20
 */
public class Patient {

	// 基本資料
	private String patientName;        // 姓名
	private String gender;             // 性別
	private String idCard;             // 身分證字號
	private int age;                   // 年紀
	private double temperature;  //體溫

	// 帳務與病歷資訊
	private String accountNo;          // 批價帳號
	private String chartNo;            // 病歷號
	private String bedNo;              // 病床號
	private String dept;               // 科別名稱

	// 醫療團隊與診斷
	private String attendingPhysician; // 主治醫師
	private String primaryDiagnosis;   // 主診斷
	private String procedure;          // 術式 (手術名稱)

	// 手術時間資訊
	private String surgeryDate;        // 手術日期
	private String surgeryTime;        // 手術時間
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
	    // 如果年齡小於 0 或超過 150，就報錯且不賦值
	    if (age < 0 || age > 150) {
	        System.out.println("⚠️ 警告：嘗試設定不合理的年齡 [" + age + "]，已被攔截！");
	        return; 
	    }
	    this.age = age;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	/**
	 * 在 setTemperature 方法中，限制體溫必須在 35.0 到 42.0 度之間。
		若超出範圍，印出「⚠️ 體溫數據異常，請確認後輸入」。
	 * @param temperature
	 */
	
	public void setTemperature(double temperature) {
		if (35>temperature || temperature>42) {
			System.out.println("⚠️ 體溫數據異常，請確認後輸入");
			return;
		}
		this.temperature = temperature;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getChartNo() {
		return chartNo;
	}
	public void setChartNo(String chartNo) {
		this.chartNo = chartNo;
	}
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAttendingPhysician() {
		return attendingPhysician;
	}
	public void setAttendingPhysician(String attendingPhysician) {
		this.attendingPhysician = attendingPhysician;
	}
	public String getPrimaryDiagnosis() {
		return primaryDiagnosis;
	}
	public void setPrimaryDiagnosis(String primaryDiagnosis) {
		this.primaryDiagnosis = primaryDiagnosis;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public String getSurgeryDate() {
		return surgeryDate;
	}
	public void setSurgeryDate(String surgeryDate) {
		this.surgeryDate = surgeryDate;
	}
	public String getSurgeryTime() {
		return surgeryTime;
	}
	public void setSurgeryTime(String surgeryTime) {
		this.surgeryTime = surgeryTime;
	}
	

	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", gender=" + gender + ", idCard=" + idCard + ", age=" + age
				+ ", temperature=" + temperature + ", accountNo=" + accountNo + ", chartNo=" + chartNo + ", bedNo="
				+ bedNo + ", dept=" + dept + ", attendingPhysician=" + attendingPhysician + ", primaryDiagnosis="
				+ primaryDiagnosis + ", procedure=" + procedure + ", surgeryDate=" + surgeryDate + ", surgeryTime="
				+ surgeryTime + "]";
	}
	
	
}

