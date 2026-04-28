package java_fundamentals.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>第三週 OOP 多型實戰：醫院獎金系統 (Hospital Bonus System)</h3>
 * 
 * <p><strong>題目背景：</strong><br>
 * 醫院的人事部門需要發放年終獎金。不同職位的獎金計算方式不同：
 * <ul>
 *   <li><b>普通員工 (Staff)：</b> 獎金 = 薪資 * 0.1</li>
 *   <li><b>醫生 (Doctor)：</b> 獎金 = 薪資 * 0.1 + 10000 (固定手術津貼)</li>
 *   <li><b>護理師 (Nurse)：</b> 獎金 = 薪資 * 0.1 + (值班時數 * 100)</li>
 * </ul>
 * 此練習旨在學習如何使用 <code>@Override</code> 覆寫方法，並利用「多型」統一處理所有員工。</p>
 * 
 * <p><strong>實作任務：</strong></p>
 * <ul>
 *   <li><b>1. 定義 HStaff 父類別：</b>
 *     <ul>
 *       <li>屬性：姓名、薪資。</li>
 *       <li>方法：<code>public double calculateBonus()</code>，回傳薪資的 10%。</li>
 *     </ul>
 *   </li>
 *   <li><b>2. 定義 Doctor 類別：</b>
 *     <ul>
 *       <li>繼承 <code>HStaff</code>，覆寫 <code>calculateBonus()</code> 加入手術津貼。</li>
 *     </ul>
 *   </li>
 *   <li><b>3. 定義 Nurse 類別：</b>
 *     <ul>
 *       <li>繼承 <code>HStaff</code>，新增值班時數屬性，覆寫 <code>calculateBonus()</code> 加入時數補貼。</li>
 *     </ul>
 *   </li>
 *   <li><b>4. 多型測試 (Main)：</b>
 *     <ul>
 *       <li>建立一個 <code>List&lt;HStaff&gt;</code>，放入一個 Doctor 和一個 Nurse。</li>
 *       <li>使用 <code>for</code> 迴圈遍歷清單，印出每位員工的姓名與計算出的獎金。</li>
 *     </ul>
 *   </li>
 * </ul>
 * 
 * @author Takahiro
 * @date 2026/04/28
 */
public class Q_HospitalPolymorphism {

    public static void main(String[] args) {
        // 任務：建立 List<HStaff> 並進行多型呼叫測試
        List<HStaff> hospitalStaff = new ArrayList<>();
        hospitalStaff.add(new Doctor("王醫師",40000));
        hospitalStaff.add(new Nurse("李護理師",60000, 2));
        
        for (HStaff s : hospitalStaff) {
			System.out.println("員工姓名: "+ s.getName() + "年終獎金: " + s.calculateBonus() );
		}
        
    }

}

class HStaff{
	private String name;
	protected double salary;
	
	public HStaff() {
		super();
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public HStaff(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}


	public double calculateBonus() {
		return salary * 0.1;
	}
	
}

class Doctor extends HStaff{
	
		public Doctor() {
			super();
		}

		public Doctor(String name, double salary) {
			super(name , salary);
		}

		@Override
		public double calculateBonus () {
			return  salary * 0.1 +10000;
		}
	}


class Nurse extends HStaff{
	
	private int workShifts;
	public Nurse() {
		super();
	}
	
	public Nurse(String name ,double salary,int workShifts) {
		super(name,salary);
		this.workShifts=workShifts;
	}


	
		@Override
		public double calculateBonus () {
			double bonus;
			bonus = salary * 0.1 + workShifts * 100;
			return bonus;
		}   
	
}


