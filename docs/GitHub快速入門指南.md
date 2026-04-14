# ⚡ GitHub 快速入門：5 分鐘搭建你的 LeetCode 學習項目

## 前置準備（2 分鐘）

### 1. 安裝 Git

**Windows:**
- 下載：https://git-scm.com/download/win
- 安裝（一直下一步）
- 打開 Command Prompt，輸入 `git --version` 驗證

**Mac:**
```bash
brew install git
```

**Linux:**
```bash
sudo apt-get install git
```

### 2. 註冊 GitHub 帳號

- 去 https://github.com
- 點「Sign Up」
- 填郵箱、密碼、用戶名
- 驗證郵箱
- 完成！

### 3. 配置 Git

```bash
git config --global user.name "你的名字"
git config --global user.email "你的郵箱"
```

---

## 創建項目（3 分鐘）

### 步驟 1：在 GitHub 上創建倉庫

1. 登錄 GitHub，點右上角 **`+`** → **`New repository`**
2. Repository name 輸入：**`LeetCode-Learning`**
3. Description 輸入：**`My LeetCode solutions and Java learning journey`**
4. 選擇 **`Public`**（這樣面試官可以看到）
5. ☑️ 勾選 **`Add a README file`**
6. 點 **`Create repository`**

### 步驟 2：複製倉庫到電腦

```bash
# 在你要放項目的文件夾打開終端
# 例如 C:\Users\你的用戶名\Projects 或 ~/Documents/Projects

# 複製倉庫
git clone https://github.com/你的用戶名/LeetCode-Learning.git

# 進入項目文件夾
cd LeetCode-Learning
```

### 步驟 3：建立項目結構

```bash
# 創建文件夾
mkdir Java-Fundamentals
mkdir LeetCode-Solutions
mkdir LeetCode-Solutions/Easy
mkdir LeetCode-Solutions/Medium
mkdir LeetCode-Solutions/Hard
mkdir Learning-Notes
mkdir Projects

# 創建各個文件夾的 README.md
touch Java-Fundamentals/README.md
touch LeetCode-Solutions/README.md
touch Learning-Notes/README.md
touch Projects/README.md
```

---

## 編寫主 README.md（關鍵！）

用記事本或 VS Code 打開項目根目錄的 `README.md`，改成：

```markdown
# LeetCode 和 Java 學習記錄

![Language](https://img.shields.io/badge/Language-Java-orange)
![LeetCode](https://img.shields.io/badge/LeetCode-50%2B%20Solved-blue)
![Progress](https://img.shields.io/badge/Progress-In%20Progress-brightgreen)

## 📊 學習進度

| 分類 | 進度 | 目標 |
|------|------|------|
| LeetCode Easy | 0/30 | 30 題 |
| LeetCode Medium | 0/15 | 15 題 |
| Java 核心概念 | 0/12 | 12 個主題 |
| 完整項目 | 0/3 | 3 個 |

## 📁 項目結構

### [Java-Fundamentals](./Java-Fundamentals)
系統學習 Java 基礎，包括：
- 基本語法
- 物件導向設計
- 集合框架
- 異常處理

### [LeetCode-Solutions](./LeetCode-Solutions)
按難度分類的題目解答：
- **Easy** - 30 道題
- **Medium** - 15 道題  
- **Hard** - 5 道題

每道題包含：
- ✅ 多種解法（從暴力到最優）
- 📊 複雜度分析
- 💡 學習心得

### [Learning-Notes](./Learning-Notes)
系統性的學習筆記和總結

### [Projects](./Projects)
完整的項目實現：
- 銀行系統
- 學生成績管理系統
- 圖書館管理系統

## 🎯 學習計劃

- **第 1-2 週**：Java 基礎語法
- **第 3-5 週**：物件導向設計（OOP）
- **第 6-8 週**：集合框架和高級特性
- **第 9-12 週**：項目實戰和優化

## 📖 快速開始

### 查看 Java 基礎
```bash
cd Java-Fundamentals
# 每個主題都有詳細的代碼和 README.md
```

### 查看 LeetCode 解答
```bash
cd LeetCode-Solutions/Easy
# 每個文件都有完整的解答和思路
```

### 運行代碼
大多數代碼可以直接在 Eclipse 或 IntelliJ IDEA 中運行。

## 💡 為什麼開設這個項目？

我用了一年的 AI 輔助編程，導致代碼都是自動生成的。
這個項目的目的是重新掌握 Java，從「看得懂」到「能手寫」。

我的方法：
1. **動手實踐** - 每道題都手寫代碼
2. **深入思考** - 記錄複雜度分析
3. **知識輸出** - 寫詳細的筆記和總結
4. **定期複習** - 確保真正掌握

## 🚀 更新日誌

### 2024 年 X 月
- [x] 初始化項目結構
- [ ] 完成 Java 基礎（12 個主題）
- [ ] 完成 30 道 Easy 題目
- [ ] 完成 15 道 Medium 題目
- [ ] 完成 5 道 Hard 題目
- [ ] 完成 3 個項目

## 📚 參考資源

- [Oracle Java 官方文檔](https://docs.oracle.com/javase/tutorial/)
- [LeetCode](https://leetcode.com)
- 《Head First Java》
- 《Java 核心技術》

## 📞 聯繫我

- 📧 Email: your.email@example.com
- 🔗 LinkedIn: [你的 LinkedIn]
- 📝 Blog: [你的博客]

---

**最後更新**: 2024 年 X 月 X 日  
**學習狀態**: 🔥 持續更新中

⭐️ 如果這個項目對你有幫助，請給個星吧！
```

---

## 上傳你的第一個 LeetCode 解答（1 分鐘）

### 第 1 步：創建文件

在 `LeetCode-Solutions/Easy/` 文件夾中創建文件：`001-TwoSum.java`

內容：

```java
/**
 * LeetCode #1 - Two Sum
 * 難度：Easy
 * 
 * 題目：給定整數數組和目標值，返回兩個數的索引，使其和等於目標值
 * 
 * 解法：使用 HashMap 存儲已見過的數字，時間 O(n)，空間 O(n)
 */

import java.util.*;

public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    
    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(result));  // [0, 1]
    }
}
```

### 第 2 步：上傳到 GitHub

```bash
# 進入項目目錄
cd LeetCode-Learning

# 查看修改狀態
git status

# 添加所有修改
git add .

# 提交（commit message 要清楚）
git commit -m "feat: Add LeetCode #1 Two Sum solution with HashMap approach"

# 推送到 GitHub
git push origin main
```

完成！刷新你的 GitHub 頁面，就能看到你的代碼了！

---

## 日常使用流程（之後每天都這樣）

### 每次你做完一道題或學完一個主題：

```bash
# 1. 進入項目文件夾
cd LeetCode-Learning

# 2. 查看修改
git status

# 3. 添加文件
git add .

# 4. 提交（寫清楚你做了什麼）
git commit -m "feat: Add LeetCode #2 solution"
# 或
git commit -m "docs: Add Java OOP notes with inheritance examples"
# 或
git commit -m "refactor: Optimize BankSystem exception handling"

# 5. 推送到 GitHub
git push origin main
```

### 好的 Commit Message 範例

```
✅ 好的：
git commit -m "feat: Add LeetCode #20 Valid Parentheses with Stack solution"
git commit -m "docs: Add detailed HashMap explanation in Learning Notes"
git commit -m "refactor: Improve Student class with better validation"

❌ 不好的：
git commit -m "update"
git commit -m "fix"
git commit -m "新增"
```

---

## 常用 Git 命令速查

```bash
# 查看現在的狀態
git status

# 查看你修改了什麼
git diff

# 添加所有修改的文件
git add .

# 只添加某個文件
git add 文件名

# 提交修改
git commit -m "你的提交信息"

# 查看 commit 歷史
git log

# 推送到 GitHub（第一次）
git push -u origin main

# 推送到 GitHub（之後）
git push

# 拉取最新的代碼（如果在多台電腦上工作）
git pull

# 查看遠程倉庫
git remote -v
```

---

## 📱 視覺化你的 GitHub（額外加分）

### 在 GitHub 個人資料中 Pin 你的項目

1. 進入你的 GitHub 個人資料頁面
2. 找到 `LeetCode-Learning` 倉庫
3. 點 **`...`** → **`Pin`**

這樣當別人訪問你的 GitHub 時，第一眼就能看到這個項目！

### 添加 Badge（讓項目看起來更專業）

在你的 README.md 開頭添加：

```markdown
![Java](https://img.shields.io/badge/Java-17-orange)
![LeetCode](https://img.shields.io/badge/LeetCode-50%2B%20Solved-blue)
![Update](https://img.shields.io/badge/Updated-2024%2F1%2F15-green)
```

---

## 🎯 接下來要做什麼

### 今天（日期：______）

```
□ 創建 GitHub 倉庫
□ 複製到電腦
□ 建立項目結構
□ 寫主 README.md
□ 上傳第一個 LeetCode 解答
□ 推送到 GitHub

預計時間：30 分鐘
```

### 這週

```
□ 上傳 3 道 LeetCode 題目
□ 寫 Java 基礎筆記
□ 在 LinkedIn 分享這個項目
□ 邀請朋友給你的項目 star

預計時間：每天 10 分鐘
```

### 這個月

```
□ 上傳 20+ 道 LeetCode 題目
□ 寫完 Java 基礎部分
□ 發表第一篇博客文章
□ 獲得 10+ 個 star

預計時間：每天 20 分鐘
```

---

## 💡 常見問題

### Q: 應該用 HTTPS 還是 SSH？
**A:** 初學者用 HTTPS 更簡單。後期可以轉 SSH。

### Q: Commit 要多頻繁？
**A:** 建議每完成一小部分就 commit 一次。這樣 commit 歷史會更清楚。

### Q: 代碼有 bug 怎麼辦？
**A:** 直接修改，再 commit。完整的修改歷史對面試官來說反而加分。

### Q: 可以修改已經 push 的代碼嗎？
**A:** 可以，但盡量避免。Git 的目的是記錄歷史，修改歷史反而顯得不專業。

### Q: 需要寫多少 commit message？
**A:** 一句話足夠。清楚、簡潔就好。

---

## 🚀 提示和技巧

### 1. 編輯器推薦
- **VS Code** - 最輕量，Git 集成也好
- **IntelliJ IDEA** - 功能強大，但比較重

### 2. 用 VS Code 的 Git 功能（視覺化）

如果你用 VS Code，可以用內建的 Git 功能：
1. 左邊欄點「Source Control」（第三個圖標）
2. 直接在 UI 上操作，不用打命令

### 3. 定期檢查你的 GitHub 統計

每個月看一下：
- 有多少個 commit
- 有多少個 star
- 有多少人 fork

這些都是面試時吹牛的資本！😄

---

## ✅ 檢查清單

```
□ 安裝了 Git
□ 註冊了 GitHub 帳號
□ 配置了 Git 用戶名和郵箱
□ 創建了 LeetCode-Learning 倉庫
□ 複製到了電腦
□ 建立了項目結構
□ 寫了主 README.md
□ 上傳了第一個代碼文件
□ 推送到了 GitHub
□ 在 GitHub 上看到了你的代碼

全部完成？恭喜！你已經開始了！🎉
```

---

## 📞 遇到問題？

### 常見錯誤和解決方案

**錯誤 1：Permission denied (publickey)**
```bash
# 解決：按照這個指南設置 SSH
# https://docs.github.com/en/authentication/connecting-to-github-with-ssh
```

**錯誤 2：git push 提示 rejected**
```bash
# 解決：先 pull 再 push
git pull origin main
git push origin main
```

**錯誤 3：不知道怎麼寫 commit message**
```bash
# 使用這個格式：
git commit -m "type: description"

# type 可以是：
# feat: 新功能
# docs: 文檔
# fix: 修復 bug
# refactor: 代碼重構
```

---

**祝你成功！GitHub 見！** 🚀

記住：今天的一個小 commit，就是面試時的加分項！
