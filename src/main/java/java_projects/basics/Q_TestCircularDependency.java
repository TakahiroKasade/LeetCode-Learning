package java_projects.basics;

// 1. 定義互為循環依賴的兩個類別
class ServiceA {
    private ServiceB serviceB;

    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public ServiceB getServiceB() {
        return this.serviceB;
    }
}

class ServiceB {
    private ServiceA serviceA;

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public ServiceA getServiceA() {
        return this.serviceA;
    }
}

// 2. 第一章的陽春型容器（完全無快取，會發生無窮遞迴）
class SimpleBeanFactory {
    
    public ServiceA getServiceA() {
        System.out.println("【SimpleBeanFactory】正在建立 ServiceA...");
        ServiceA a = new ServiceA();
        
        // 為了裝配 a，必須先去取得 b
        System.out.println("【SimpleBeanFactory】ServiceA 正在等待注入 ServiceB...");
        ServiceB b = getServiceB();
        a.setServiceB(b);
        return a;
    }

    public ServiceB getServiceB() {
        System.out.println("【SimpleBeanFactory】正在建立 ServiceB...");
        ServiceB b = new ServiceB();
        
        // 為了裝配 b，必須先去取得 a
        System.out.println("【SimpleBeanFactory】ServiceB 正在等待注入 ServiceA...");
        ServiceA a = getServiceA(); // 🔴 致命呼叫：這裡會回頭呼叫 getServiceA()，陷入死循環！
        b.setServiceA(a);
        return b;
    }
}

// 3. 第二章：加入一級與二級快取的強型別容器
class DoubleCacheBeanFactory {
    // 一級快取：存放完全組裝好的成品 Bean
    private ServiceA finishedA;
    private ServiceB finishedB;

    // 二級快取：存放剛 new 出來、屬性還沒填充的半成品 Bean
    private ServiceA earlyA;
    private ServiceB earlyB;

    public ServiceA getServiceA() {
        // 🔴 任務一：請在此處編寫三步驟的查找與建立邏輯
        // 1. 檢查一級快取 finishedA，如果不為 null，直接回傳
        if(finishedA != null){
            return finishedA;
        }
        // 2. 檢查二級快取 earlyA，如果不為 null，直接回傳
        if(earlyA != null){
            return earlyA;
        }
        // 3. 如果快取都沒有，則呼叫 createServiceA() 進行建立
        return createServiceA();
    }

    private ServiceA createServiceA() {
        System.out.println("【二級快取容器】正在 new 建立 ServiceA 半成品...");
        ServiceA a = new ServiceA();

        // 💡 關鍵步驟：剛 new 出來，屬性還沒裝配，就立刻「提前曝光」到二級快取中！
        this.earlyA = a;

        System.out.println("【二級快取容器】ServiceA 半成品已放入二級快取，開始等待注入 ServiceB...");
        ServiceB b = getServiceB(); // 這裡會觸發 B 的建立
        a.setServiceB(b);

        // 💡 裝配完成，升級到一級快取，並清除二級快取
        this.finishedA = a;
        this.earlyA = null;
        System.out.println("【二級快取容器】ServiceA 組裝完畢，升級至一級快取！");
        return a;
    }

    public ServiceB getServiceB() {
        // 🔴 任務二：請比照 ServiceA 的邏輯，在此處編寫 ServiceB 的三步驟查找與建立
        // 1. 檢查一級快取 finishedB
        if(finishedB != null){
            return finishedB;
        }
        // 2. 檢查二級快取 earlyB
        if(earlyB != null){
            return earlyB;
        }
        // 3. 如果沒有，呼叫 createServiceB()
        return createServiceB();
    }

    private ServiceB createServiceB() {
        System.out.println("【二級快取容器】正在 new 建立 ServiceB 半成品...");
        ServiceB b = new ServiceB();

        // 💡 提前曝光到二級快取
        this.earlyB = b;

        System.out.println("【二級快取容器】ServiceB 半成品已放入二級快取，開始等待注入 ServiceA...");
        ServiceA a = getServiceA(); // 這裡會回頭拿 A
        b.setServiceA(a);

        // 💡 裝配完成，升級到一級快取，並清除二級快取
        this.finishedB = b;
        this.earlyB = null;
        System.out.println("【二級快取容器} ServiceB 組裝完畢，升級至一級快取！");
        return b;
    }
}

// =========================================================================
// 4. 第三章：加入三級快取（ObjectFactory）與 AOP 代理的強型別容器
// =========================================================================

// 強型別的工廠介面，用來延遲 Bean 的建立或代理邏輯，絕不使用 Object 關鍵字
interface ObjectFactory<T> {
    T getObject();
}

// 模擬 AOP 代理類別：繼承 ServiceA，並包裝原始物件
class ServiceAProxy extends ServiceA {
    private final ServiceA target;

    public ServiceAProxy(ServiceA target) {
        this.target = target;
    }

    @Override
    public void setServiceB(ServiceB serviceB) {
        target.setServiceB(serviceB);
    }

    @Override
    public ServiceB getServiceB() {
        return target.getServiceB();
    }

    // AOP 獨有的增強方法
    public void doAopLog() {
        System.out.println("【AOP 代理】[側邊日誌] 攔截成功！執行 ServiceA 核心業務...");
    }
}

class TripleCacheBeanFactory {
    // 一級快取：存放完全組裝好的成品 Bean
    private ServiceA finishedA;
    private ServiceB finishedB;

    // 二級快取：存放半成品 Bean（如果發生循環依賴且有 AOP，這裡存的是代理 Bean，否則存原始 Bean）
    private ServiceA earlyA;
    private ServiceB earlyB;

    // 三級快取：存放生產半成品 Bean 的工廠 (強型別)
    private ObjectFactory<ServiceA> factoryA;
    private ObjectFactory<ServiceB> factoryB;

    // 模擬配置：ServiceA 是否需要 AOP 代理
    private boolean needAopA = true;
    
    // 標記：ServiceA 是否已經提前曝光且被代理過
    private boolean earlyProxyA = false;

    public ServiceA getServiceA() {
        // 1. 檢查一級快取 finishedA，如果不為 null，直接回傳
        if (finishedA != null) {
            return finishedA;
        }
        // 2. 檢查二級快取 earlyA，如果不為 null，直接回傳
        if (earlyA != null) {
            return earlyA;
        }
        // 3. 檢查三級快取工廠 factoryA
        if (factoryA != null) {
            System.out.println("【三級快取容器】在三級快取中找到 ServiceA 工廠！開始觸發 getObject()...");
            // 🔴 任務三之一：觸發工廠以取得物件，並將其升級到二級快取，最後清除三級快取
            // 提示：
            // 1. 呼叫 factoryA.getObject() 取得物件（可能是原始物件，也可能是代理物件）
            // 2. 將該物件存入 earlyA (二級快取)
            // 3. 將 factoryA 設為 null (清除三級快取)
            // 4. 回傳該物件
            this.earlyA = factoryA.getObject();
            this.factoryA = null;
            return this.earlyA;
        }
        // 4. 如果快取都沒有，則呼叫 createServiceA() 進行建立
        return createServiceA();
    }

    private ServiceA createServiceA() {
        System.out.println("【三級快取容器】正在 new 建立 ServiceA 原始半成品...");
        ServiceA a = new ServiceA();

        // 💡 關鍵步驟：不直接放入二級快取，而是將「工廠」放入三級快取！
        // 透過 Lambda 延遲決定：當 B 回頭來找 A 時，才觸發 getEarlyBeanReferenceA
        this.factoryA = () -> getEarlyBeanReferenceA(a);

        System.out.println("【三級快取容器】ServiceA 工廠已放入三級快取，開始等待注入 ServiceB...");
        ServiceB b = getServiceB(); // 這裡會觸發 B 的建立
        a.setServiceB(b);

        // 💡 初始化與 AOP 代理階段
        ServiceA exposedA = a;
        if (earlyProxyA) {
            // 如果在循環依賴中已經提前曝光並代理過，直接從二級快取獲取代理 Bean
            exposedA = this.earlyA;
        } else if (needAopA) {
            // 如果沒有發生循環依賴（所以沒觸發三級快取），但需要代理，在此時才進行代理
            exposedA = new ServiceAProxy(a);
        }

        // 💡 裝配完成，升級到一級快取，並清除二級快取
        this.finishedA = exposedA;
        this.earlyA = null;
        System.out.println("【三級快取容器】ServiceA 組裝完畢，升級至一級快取！");
        return finishedA;
    }

    // 模擬 Spring 的 getEarlyBeanReference 方法，用來判斷半成品是否需要被代理
    private ServiceA getEarlyBeanReferenceA(ServiceA target) {
        if (needAopA) {
            System.out.println("【三級快取容器】(AOP 偵測) 發現 ServiceA 需要被代理，現場建立 ServiceAProxy 代理物件！");
            this.earlyProxyA = true;
            return new ServiceAProxy(target);
        }
        return target;
    }

    public ServiceB getServiceB() {
        // 🔴 任務三之二：比照 getServiceA() 邏輯，完成 ServiceB 在三級快取下的查找與升級
        if (finishedB != null) {
            return finishedB;
        }
        if (earlyB != null) {
            return earlyB;
        }
        if (factoryB != null) {
            System.out.println("【三級快取容器】在三級快取中找到 ServiceB 工廠！開始觸發 getObject()...");
            this.earlyB = factoryB.getObject();
            this.factoryB = null;
            return this.earlyB;
        }
        return createServiceB();
    }

    private ServiceB createServiceB() {
        System.out.println("【三級快取容器】正在 new 建立 ServiceB 原始半成品...");
        ServiceB b = new ServiceB();

        // 💡 B 不需要 AOP 代理，但我們依然遵循流程，將其工廠放入三級快取（工廠直接回傳原始物件）
        this.factoryB = () -> b;

        System.out.println("【三級快取容器】ServiceB 工廠已放入三級快取，開始等待注入 ServiceA...");
        ServiceA a = getServiceA(); // 這裡會回頭拿 A，會觸發 A 的三級快取工廠！
        b.setServiceA(a);

        // 💡 裝配完成，升級到一級快取，並清除二級快取
        this.finishedB = b;
        this.earlyB = null;
        System.out.println("【三級快取容器】ServiceB 組裝完畢，升級至一級快取！");
        return b;
    }
}

public class Q_TestCircularDependency {
    public static void main(String[] args) {
        System.out.println("=== 🚀 第二章：啟動雙級快取容器 ===");
        DoubleCacheBeanFactory factory2 = new DoubleCacheBeanFactory();
        ServiceA a2 = factory2.getServiceA();
        System.out.println("\n取得 ServiceA 成功: " + a2);
        System.out.println("A 中注入的 B 參考: " + a2.getServiceB());
        System.out.println("B 中注入的 A 參考: " + a2.getServiceB().getServiceA());
        System.out.println("A 與 B 中的 A 是否為同一個物件？ " + (a2 == a2.getServiceB().getServiceA()));

        System.out.println("\n\n=== 🚀 第三章：啟動三級快取容器（模擬 AOP 代理） ===");
        TripleCacheBeanFactory factory3 = new TripleCacheBeanFactory();
        ServiceA a3 = factory3.getServiceA();
        System.out.println("\n取得 ServiceA 成功: " + a3);
        System.out.println("A 中注入的 B 參考: " + a3.getServiceB());
        System.out.println("B 中注入的 A 參考: " + a3.getServiceB().getServiceA());
        System.out.println("A 與 B 中的 A 是否為同一個物件？ " + (a3 == a3.getServiceB().getServiceA()));
        
        // 驗證是否成功注入代理物件，並執行 AOP 方法
        if (a3 instanceof ServiceAProxy) {
            System.out.println("🎉 驗證成功：取得的 A 是 ServiceAProxy 代理物件！");
            ((ServiceAProxy) a3).doAopLog();
        } else {
            System.out.println("❌ 驗證失敗：取得的 A 不是代理物件！");
        }
    }
}

