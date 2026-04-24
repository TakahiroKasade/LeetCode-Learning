package java_projects;

/**
 * <h3>本週 OOP 綜合實戰：員工管理系統 (StaffManagement Challenge)</h3>
 * 
 * <p><strong>題目背景：</strong><br>
 * 模擬一家醫院的人事管理系統，你需要設計類別來管理員工資訊與部門統計資訊。
 * 此練習旨在測試你對「封裝 (Encapsulation)」、「建構子 (Constructor)」、「靜態成員 (Static)」以及「物件關聯」的綜合運用能力。</p>
 * 
 * <p><strong>實作任務：</strong></p>
 * <ul>
 *   <li><b>1. Staff 類別設計：</b>
 *     <ul>
 *       <li>私有屬性：姓名 (name)、員工編號 (staffId)、部門 (department)、薪資 (salary)。</li>
 *       <li>封裝要求：薪資不可為負數，若設定為負數請預設為 0。</li>
 *       <li>靜態計數器：使用一個 static 變數追蹤「總員工數」，並用來自動生成 staffId (例如：S001, S002...)。</li>
 *       <li>建構子：提供「全參數建構子」與「姓名+部門」的簡化版建構子 (薪資預設 30000)。</li>
 *     </ul>
 *   </li>
 *   <li><b>2. Department 類別設計：</b>
 *     <ul>
 *       <li>屬性：部門名稱、該部門員工數、薪資總額。</li>
 *       <li>方法：addStaff(Staff staff) - 接收一個 Staff 物件，更新部門統計數據。</li>
 *     </ul>
 *   </li>
 *   <li><b>3. Main 方法測試：</b>
 *     <ul>
 *       <li>建立至少 3 個 Staff 物件。</li>
 *       <li>建立 2 個 Department 物件並將員工歸入。</li>
 *       <li>印出所有員工資訊與部門統計結果，驗證靜態計數器是否運作正常。</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * @author Takahiro
 * @date 2026/04/24
 */
public class Q_StaffManagementChallenge {

   public static void main(String[] args) {
    // 1. 建立部門
    Department devDept = new Department();
    devDept.setDepartment("開發部");

    // 2. 建立員工 (使用你寫的建構子)
    Staff s1 = new Staff("Alice", "開發部", 50000);
    Staff s2 = new Staff("Bob", "開發部"); // 預設 30000
    Staff s3 = new Staff("Charlie", "開發部", -500); // 測試防呆，應變成 0

    // 3. 加入部門
    devDept.addStaff(s1);
    devDept.addStaff(s2);
    devDept.addStaff(s3);

    // 4. 印出驗證
    System.out.println("員工 1 編號：" + s1.getStaffId() + "，姓名：" + s1.getName() + "，薪資：" + s1.getSalary());
    System.out.println("員工 2 編號：" + s2.getStaffId() + "，姓名：" + s2.getName() + "，薪資：" + s2.getSalary());
    System.out.println("員工 3 編號：" + s3.getStaffId() + "，姓名：" + s3.getName() + "，薪資：" + s3.getSalary());
    
    System.out.println("--- 部門統計 ---");
    System.out.println("部門名稱：" + devDept.getDepartment());
    System.out.println("總人數：" + devDept.getEmployeeCount());
    System.out.println("總薪資：" + devDept.getSalary());
}

}

class Staff {
	private String name	;
	private String  staffId ;
	private String department;
	private int salary;
	private static int totalCount =0;
	
    public Staff() {
		super();
	}
	
	public Staff(String name, String department, int salary) {
		super();
		this.name = name;
		this.department = department;
		this.setSalary(salary);
		totalCount++;
        this.staffId= String.format("S%03d", totalCount);  

	}

	public Staff(String name, String department) {
		this(name, department, 30000);
	}

	
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		if(salary<0) {
			this.salary = 0 ;
		}
		else {
			this.salary=salary;
		}
	}

	public static int getTotalCount() {
		return totalCount;
	}

	public static void setTotalCount(int totalCount) {
		Staff.totalCount = totalCount;
	}
    
    
}

class Department {
    // 實作部門管理邏輯
    //   <li>屬性：部門名稱、該部門員工數、薪資總額。</li>
    //   <li>方法：addStaff(Staff staff) - 接收一個 Staff 物件，更新部門統計數據。</li>
	
	private String department	;
	private int employeeCount;
	private int salary;
	
    public void addStaff(Staff staff) {
        // 1. 人數要增加
    			employeeCount++;
        // 2. 薪資總額要加上 staff.getSalary()
    			salary = salary +  staff.getSalary();
    }
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
}
