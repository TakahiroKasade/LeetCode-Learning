# Spec: Spring Boot 循環依賴與三級快取模擬解密

## Objective
本專案的目標是透過在純 Java 環境下「手寫一個簡化版的 IoC 容器與三級快取機制」，讓開發者徹底理解 Spring Boot 如何解決 Bean 之間的循環依賴問題，以及為什麼建構子注入會失效。

* **學習核心**：
  1. 理解三級快取各層的職責（`singletonObjects`、`earlySingletonObjects`、`singletonFactories`）。
  2. 觀察 Bean 生命週期的物理階段（實例化 ➔ 提前曝光 ➔ 屬性填充 ➔ 初始化 ➔ AOP 代理）。
  3. 驗證 Setter 注入（可成功解決）與建構子注入（當機失敗）的效能與異常差異。

## Tech Stack
* **Language**: Java 17
* **Framework**: 無（純 Java SE 實作，免除複雜相依性）

## Commands
* **編譯**：
  ```powershell
  javac -encoding UTF-8 src/main/java/java_projects/basics/Q_TestCircularDependency.java
  ```
* **執行**：
  ```powershell
  java "-Dfile.encoding=UTF-8" -cp src/main/java java_projects.basics.Q_TestCircularDependency
  ```

## Project Structure
* `src/main/java/java_projects/basics/Q_TestCircularDependency.java` ➔ 存放 IoC 容器模擬與測試主程式的實作檔案。
* `docs/spec_circular_dependency.md` ➔ 本規格書檔案。

## Code Style
* 採用清晰的物件導向設計。
* 變數名稱與 Spring 原始碼保持一致，以利對齊學習：
  - 一級快取：`singletonObjects` (完整的 Bean)
  - 二級快取：`earlySingletonObjects` (半成品的 Bean，解決循環依賴與多重注入)
  - 三級快取：`singletonFactories` (生產半成品 Bean 的工廠，解決 AOP 代理問題)
* 關鍵邏輯處撰寫詳細的繁體中文註解。

## Testing Strategy
* **測試場景 A (Setter 注入)**：
  - 模擬 `ServiceA` 與 `ServiceB` 互相依賴，且均使用 Setter 注入。
  - **預期輸出**：程式執行成功，`ServiceA` 順利持有 `ServiceB` 實體，`ServiceB` 也順利持有 `ServiceA` 實體，無當機。
* **測試場景 B (建構子注入)**：
  - 模擬兩者使用 Constructor 注入。
  - **預期輸出**：拋出 `CircularDependencyException` 並中斷，模擬 Spring 的 `BeanCurrentlyInCreationException`。

## Boundaries
* **Always**: 執行編譯與執行命令時加上 UTF-8 編碼設定，避免中文亂碼。
* **Ask first**: 修改 package 結構或移動檔案位置。
* **Never**: 直接引入外部 Spring 依賴到 `pom.xml` 中，維持輕量化手寫教學。

## Success Criteria
* [ ] `Q_TestCircularDependency.java` 能順利通過編譯，無語法錯誤。
* [ ] 執行輸出能詳細印出 Bean 建立的五個階段日誌。
* [ ] 當 Setter 注入完成後，雙方物件在 Heap 中的記憶體參考正確互指。
* [ ] 當建構子注入觸發時，系統能精準拋出異常並停止，不發生 StackOverflow。
