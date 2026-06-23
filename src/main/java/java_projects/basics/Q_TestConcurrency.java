package java_projects.basics;

// 1. 模擬單例模式的服務 (Singleton Service)
class ConcurrencyOrderService {
    // 🔴 致命的成員變數（共享狀態）
    // 正常情況下，Service 不應該有可變的成員變數！
//    private String currentCustomer;

    public void processOrder(String customerName, int amount) {
        // 1. 將目前的使用者存入成員變數
//        this.currentCustomer = customerName;
        System.out.println("【系統】開始處理 " + customerName + " 的訂單，金額: " + amount);

        try {
            // 2. 模擬呼叫第三方支付延遲 500 毫秒
            // 在這 500 毫秒期間，另一個執行緒會進來改寫 currentCustomer！
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. 完成訂單並輸出
        // 🔴 預期車禍現場：Alice 的訂單會顯示成 Bob 的名字！
        System.out.println("【扣款成功】" + customerName + " 扣款 " + amount + " 元 ➔ 系統記錄買家為: " + customerName);
    }
}

public class Q_TestConcurrency {
    public static void main(String[] args) {
        // 單例模式：全伺服器只有這「一個」ConcurrencyOrderService 實體
        ConcurrencyOrderService orderService = new ConcurrencyOrderService();

        // 模擬使用者 Alice 的執行緒
        Thread threadAlice = new Thread(() -> {
            orderService.processOrder("Alice", 1000);
        });

        // 模擬使用者 Bob 的執行緒（晚 Alice 100 毫秒進來，此時 Alice 還在 sleep）
        Thread threadBob = new Thread(() -> {
            try {
                Thread.sleep(100); // 稍微延遲以確保 Alice 先執行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orderService.processOrder("Bob", 5000);
        });

        // 啟動兩個併發執行緒
        threadAlice.start();
        threadBob.start();

        // 等待執行緒結束
        try {
            threadAlice.join();
            threadBob.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
