package java_projects;

/**
 * <h3>第三週 OOP 進階實戰：醫院繼承體系 (Hospital Inheritance)</h3>
 * 
 * <p><strong>題目背景：</strong><br>
 * 延續上一週的員工管理系統，我們現在要細分醫院的職位。
 * 醫院中有「醫生 (Doctor)」與「護理師 (Nurse)」，兩者都是「員工 (Staff)」。
 * 此練習旨在學習如何使用 <code>extends</code> 繼承共同屬性，並使用 <code>super()</code> 呼叫父類別建構子。</p>
 * 
 * <p><strong>實作任務：</strong></p>
 * <ul>
 *   <li><b>1. 繼承 Staff 類別：</b>
 *     <ul>
 *       <li>將上一題的 <code>Staff</code> 類別邏輯遷移（或重新定義）作為父類別。</li>
 *       <li>屬性包含：姓名 (name)、員工編號 (staffId)、薪資 (salary)。</li>
 *     </ul>
 *   </li>
 *   <li><b>2. 建立 Doctor 類別：</b>
 *     <ul>
 *       <li>繼承 <code>Staff</code>。</li>
 *       <li>新增屬性：專科 (specialization，例如：心臟內科、外科)。</li>
 *       <li>建構子：必須透過 <code>super()</code> 傳遞姓名與薪資給父類別。</li>
 *     </ul>
 *   </li>
 *   <li><b>3. 建立 Nurse 類別：</b>
 *     <ul>
 *       <li>繼承 <code>Staff</code>。</li>
 *       <li>新增屬性：值班時數 (shiftHours)。</li>
 *       <li>建構子：必須透過 <code>super()</code> 傳遞姓名與薪資給父類別。</li>
 *     </ul>
 *   </li>
 *   <li><b>4. Main 方法測試：</b>
 *     <ul>
 *       <li>建立一個 <code>Doctor</code> 物件與一個 <code>Nurse</code> 物件。</li>
 *       <li>分別印出他們的資訊，確認繼承的 <code>staffId</code> 與 <code>name</code> 是否正確初始化。</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * @author Takahiro
 * @date 2026/04/27
 */
public class Q_HospitalInheritance {

    public static void main(String[] args) {
    	
    		HStaff s1 = new HStaff("Sam" , 0);
    		Doctor d1 = new Doctor("王醫師", 0, "心臟科");
    		Nurse n1 = new Nurse("李護士", 0, 8);
    		
    		System.out.println(d1.getName() + " 的專科是：" + d1.getSpecialization());
    		System.out.println("n1.name=" + n1.getName()+"n1.salary=" + n1.getSalary());
    }

}

class HStaff {
	private String name;
	private int salary;
	private String staffId;
	private static int totalCount =0;
	
	public HStaff(String name, int salary) {
		this.name = name;
		this.setSalary(salary);
		totalCount++;
        this.staffId= String.format("S%03d", totalCount);  
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
		HStaff.totalCount = totalCount;
	}
    
}

class Doctor extends HStaff{
	private String specialization;

    public Doctor(String name, int salary, String specialization) {
        super(name, salary);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
}

class Nurse extends HStaff{
	private int shiftHours;

    public Nurse(String name, int salary, int shiftHours) {
        super(name, salary);
        this.shiftHours = shiftHours;
    }

    public int getShiftHours() {
        return shiftHours;
    }

    public void setShiftHours(int shiftHours) {
        this.shiftHours = shiftHours;
    }
    
}