package java_projects.basics;


// 1. 自定義商業邏輯異常 (Business Exception)
// 實務上繼承 RuntimeException，以便於 Spring 事務自動回滾且不需要強制宣告 throws
class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}

// 2. 模擬庫存服務 (Stock Service)
class StockService {
    private int stock = 3; // 模擬商品庫存只有 3 件

    public void reduceStock(int quantity) {
        System.out.println("【庫存系統】正在嘗試扣減庫存，數量: " + quantity);
        
        // 🔴 任務一：請在此處編寫庫存檢查邏輯
        // 如果 quantity 大於目前的 stock，請拋出自定義的 OutOfStockException，並帶有訊息 "商品庫存不足，剩餘: " + stock
        // 如果庫存足夠，則減去庫存 (stock = stock - quantity) 並印出 "扣減成功，剩餘庫存: " + stock
        if(quantity>stock) {
        		throw new OutOfStockException("商品庫存不足，剩餘: " + stock);
        }else {
        		stock = stock -quantity ;
       		System.out.println("扣減成功，剩餘庫存: " +  stock);
		}
    }
}

// 3. 模擬結帳服務 (Order Service)
class OrderService {
    private StockService stockService = new StockService();

    public void processOrder(int quantity) {
        System.out.println("=== 🛒 開始處理訂單結帳 ===");
        
        // 🔴 任務二：請在此處用 try-catch 包裝庫存扣減邏輯
        // 呼叫 stockService.reduceStock(quantity)
        // 捕捉 OutOfStockException 異常：
        //   - 捕捉後印出: "🟢 結帳攔截成功：無法完成結帳，原因: " + e.getMessage()
        //   - 不讓異常導致程式崩潰，而是優雅地完成訂單失敗處理
        // 捕捉其他未知異常 (Exception)：
        //   - 捕捉後印出: "🔴 系統錯誤：請聯繫管理員"
        try {
        	 	stockService.reduceStock(quantity);
		} catch (OutOfStockException e) {
			System.out.println( "🟢 結帳攔截成功：無法完成結帳，原因: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("🔴 系統錯誤：請聯繫管理員");
		}
        
        
        System.out.println("=== 🛒 訂單結帳流程結束 ===\n");
    }
}

public class Q_TestException {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        // 第一次購買 2 件（預期成功）
        orderService.processOrder(2);

        // 第二次購買 2 件（預期庫存不足，觸發異常被優雅捕獲）
        orderService.processOrder(2);
    }
}
