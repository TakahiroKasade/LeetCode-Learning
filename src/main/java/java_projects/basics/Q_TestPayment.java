package java_projects.basics;

// 1. 定義付款介面 (合約)
interface PaymentGateway {
    void pay(int amount);
}

// 2. 定義抽象類別 (半成品/模板)，用來放所有付款方式共用的邏輯
abstract class BasePayment implements PaymentGateway {
    // 共用的屬性
    protected String gatewayName;

    public BasePayment(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    // 共用的方法 (所有付款方式都要記錄日誌)
    public void logTransaction(int amount) {
        System.out.println("【系統日誌】使用 " + gatewayName + " 成功交易，金額: " + amount + " 元");
    }

    // 🔴 雖然繼承了 PaymentGateway，但我們不在此處寫 pay() 的具體內容，
    // 因為每種付款方式的扣款邏輯都不同。我們把它留給子類別去實現。
}

// 3. 信用卡付款實作
class CreditCardPayment extends BasePayment {
    public CreditCardPayment() {
        super("信用卡支付");
    }

    @Override
    public void pay(int amount) {
    		System.out.println("正在向銀行發送信用卡授權請求，金額: " + amount + " 元...");
        logTransaction(amount); // 呼叫父類別共用的日誌方法
    }
}

// 4. LINE Pay 付款實作
class LinePayPayment extends BasePayment {
    public LinePayPayment() {
        super("LINE Pay");
    }

    @Override
    public void pay(int amount) {
    		System.out.println("正在生成 LINE Pay 付款 QR Code，請掃碼支付: " + amount + " 元...");
        logTransaction(amount); // 呼叫父類別共用的日誌方法
    }
}

// 5. 購物車結帳服務 (Checkout Service)
class CheckoutService {
    // 這裡只依賴合約 (PaymentGateway 介面)，完全不關心是信用卡還是 LINE Pay！
    public void executeCheckout(PaymentGateway gateway, int amount) {
        System.out.println("--- 開始處理訂單結帳 ---");
        gateway.pay(amount); // 多型 (Polymorphism) 呼叫
        System.out.println("--- 訂單處理完成 ---\n");
    }
}

public class Q_TestPayment {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService();

        // 模擬使用者選擇不同的付款方式
        PaymentGateway creditCard = new CreditCardPayment();
        PaymentGateway linePay = new LinePayPayment();

        // 結帳
        checkoutService.executeCheckout(creditCard, 1500);
        checkoutService.executeCheckout(linePay, 800);
    }
}
