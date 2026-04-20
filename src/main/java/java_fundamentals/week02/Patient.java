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
	String patientName;        // 姓名
	String gender;             // 性別
	String idCard;             // 身分證字號
	int age;                   // 年紀

	// 帳務與病歷資訊
	String accountNo;          // 批價帳號
	String chartNo;            // 病歷號
	String bedNo;              // 病床號
	String dept;               // 科別名稱

	// 醫療團隊與診斷
	String attendingPhysician; // 主治醫師
	String primaryDiagnosis;   // 主診斷
	
	String procedure;          // 術式 (手術名稱)

	// 手術時間資訊
	String surgeryDate;        // 手術日期
	String surgeryTime;        // 手術時間
	
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
		this.age = age;
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
				+ ", accountNo=" + accountNo + ", chartNo=" + chartNo + ", bedNo=" + bedNo + ", dept=" + dept
				+ ", attendingPhysician=" + attendingPhysician + ", primaryDiagnosis=" + primaryDiagnosis
				+ ", procedure=" + procedure + ", surgeryDate=" + surgeryDate + ", surgeryTime=" + surgeryTime + "]";
	}
	
	
}

