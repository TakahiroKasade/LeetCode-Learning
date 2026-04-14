# 📖 Java & SQL 快速參考指南

## Java 常用代碼片段（LeetCode）

### 1. 基本數據結構

#### ArrayList（動態陣列）
```java
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
list.add(5);              // 添加元素
list.get(0);              // 獲取第 0 個元素
list.size();              // 獲取大小
list.remove(0);           // 刪除第 0 個
list.contains(5);         // 是否包含

// 遍歷
for (int num : list) {
    System.out.println(num);
}
```

#### HashMap（哈希表）
```java
import java.util.HashMap;

HashMap<Integer, String> map = new HashMap<>();
map.put(1, "Alice");          // 添加鍵值對
map.get(1);                   // 獲取值
map.containsKey(1);           // 檢查鍵是否存在
map.remove(1);                // 刪除鍵值對
map.size();                   // 獲取大小

// 遍歷
for (int key : map.keySet()) {
    System.out.println(key + " -> " + map.get(key));
}

// 遍歷值
for (String value : map.values()) {
    System.out.println(value);
}
```

#### HashSet（哈希集合，無重複）
```java
import java.util.HashSet;

HashSet<Integer> set = new HashSet<>();
set.add(1);           // 添加元素
set.contains(1);      // 檢查是否存在
set.remove(1);        // 刪除元素
set.size();           // 獲取大小

// 遍歷
for (int num : set) {
    System.out.println(num);
}
```

#### Stack（棧，先進後出）
```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(5);        // 入棧
stack.pop();          // 出棧並返回值
stack.peek();         // 查看頂部元素但不刪除
stack.isEmpty();      // 是否為空
stack.size();         // 棧的大小
```

#### Queue（隊列，先進先出）
```java
import java.util.Queue;
import java.util.LinkedList;

Queue<Integer> queue = new LinkedList<>();
queue.add(5);         // 入隊
queue.poll();         // 出隊並返回值
queue.peek();         // 查看首部元素但不刪除
queue.isEmpty();      // 是否為空
queue.size();         // 隊列大小
```

#### 鏈表
```java
// LeetCode 提供的鏈表定義
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// 基本操作
ListNode head = new ListNode(1);
head.next = new ListNode(2);

// 遍歷
ListNode current = head;
while (current != null) {
    System.out.println(current.val);
    current = current.next;
}

// 插入節點
ListNode newNode = new ListNode(100);
newNode.next = head.next;
head.next = newNode;

// 刪除節點
head.next = head.next.next;
```

#### 二叉樹
```java
// LeetCode 提供的樹節點定義
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// 遞歸遍歷（前序）
void preorder(TreeNode root) {
    if (root == null) return;
    System.out.println(root.val);        // 訪問
    preorder(root.left);                 // 左子樹
    preorder(root.right);                // 右子樹
}

// 遞歸遍歷（中序）
void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.println(root.val);
    inorder(root.right);
}

// 遞歸遍歷（後序）
void postorder(TreeNode root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.println(root.val);
}
```

---

### 2. 字符串常用操作

```java
String s = "Hello World";

// 基本方法
s.length();                      // 字符串長度
s.charAt(0);                     // 獲取第 0 個字符
s.substring(0, 5);               // 截取 [0, 5) 的子串
s.indexOf("o");                  // 第一次出現的位置
s.lastIndexOf("o");              // 最後一次出現的位置
s.toCharArray();                 // 轉換為字符陣列

// 字符串比較
s.equals("Hello World");         // 內容比較
s.equalsIgnoreCase("hello world"); // 忽略大小寫比較

// 字符串轉換
s.toLowerCase();                 // 轉小寫
s.toUpperCase();                 // 轉大寫
s.trim();                        // 移除前後空格
s.replace('l', 'x');            // 替換字符
s.split(" ");                    // 按空格分割

// 字符串拼接
String result = "Hello" + " " + "World";
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" ");
sb.append("World");
String result = sb.toString();
```

---

### 3. 常用算法技巧

#### 雙指針
```java
// 两数之和（排序數組）
int left = 0, right = nums.length - 1;
while (left < right) {
    int sum = nums[left] + nums[right];
    if (sum == target) {
        return new int[]{left, right};
    } else if (sum < target) {
        left++;
    } else {
        right--;
    }
}

// 移動零
int left = 0;
for (int right = 0; right < nums.length; right++) {
    if (nums[right] != 0) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
    }
}
```

#### 滑動窗口
```java
// 無重複字符最長子串
int maxLen = 0;
Map<Character, Integer> map = new HashMap<>();
int left = 0;

for (int right = 0; right < s.length(); right++) {
    char ch = s.charAt(right);
    if (map.containsKey(ch)) {
        left = Math.max(left, map.get(ch) + 1);
    }
    map.put(ch, right);
    maxLen = Math.max(maxLen, right - left + 1);
}
```

#### 二分查找
```java
int left = 0, right = nums.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        return mid;
    } else if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
return -1; // 未找到
```

#### DFS（深度優先搜索）
```java
// 樹的深度
int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
}

// 圖的 DFS
void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    visited[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited);
        }
    }
}
```

#### BFS（廣度優先搜索）
```java
import java.util.Queue;
import java.util.LinkedList;

void bfs(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.println(node.val);
        
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}
```

#### 排序
```java
// 數組排序
int[] nums = {3, 1, 4, 1, 5};
Arrays.sort(nums);  // 升序
// 降序需要用 Integer[]
Integer[] nums2 = {3, 1, 4, 1, 5};
Arrays.sort(nums2, Collections.reverseOrder());
```

---

## SQL 常用語句（LeetCode Database）

### 1. 基本查詢

#### SELECT 和 WHERE
```sql
-- 基本查詢
SELECT name, age FROM users;

-- 帶條件
SELECT * FROM users WHERE age > 18;

-- 多個條件
SELECT * FROM users 
WHERE age > 18 AND city = 'New York';

-- OR 條件
SELECT * FROM users 
WHERE age > 30 OR city = 'Los Angeles';

-- 非空檢查
SELECT * FROM users WHERE name IS NOT NULL;
```

#### DISTINCT（去重）
```sql
-- 查詢不重複的城市
SELECT DISTINCT city FROM users;

-- 查詢不重複的用戶和城市組合
SELECT DISTINCT user_id, city FROM orders;
```

#### ORDER BY（排序）
```sql
-- 按年齡升序
SELECT * FROM users ORDER BY age ASC;

-- 按年齡降序
SELECT * FROM users ORDER BY age DESC;

-- 多列排序
SELECT * FROM users ORDER BY city ASC, age DESC;

-- 結合 LIMIT
SELECT * FROM users ORDER BY age DESC LIMIT 5; -- 前 5 個
```

---

### 2. 聚合函數

```sql
-- COUNT：計數
SELECT COUNT(*) FROM users;
SELECT COUNT(age) FROM users;  -- 不計 NULL

-- SUM：求和
SELECT SUM(salary) FROM employees;

-- AVG：平均值
SELECT AVG(salary) FROM employees;

-- MAX / MIN：最大/最小值
SELECT MAX(salary), MIN(salary) FROM employees;

-- 多個聚合函數
SELECT COUNT(*), AVG(age), MAX(salary) FROM users;
```

---

### 3. GROUP BY（分組）

```sql
-- 按部門分組統計員工人數
SELECT department, COUNT(*) as emp_count
FROM employees
GROUP BY department;

-- 按部門統計平均薪水
SELECT department, AVG(salary) as avg_salary
FROM employees
GROUP BY department;

-- 多列分組
SELECT department, job_title, COUNT(*)
FROM employees
GROUP BY department, job_title;
```

#### HAVING（分組篩選）
```sql
-- 找出員工數超過 5 的部門
SELECT department, COUNT(*) as emp_count
FROM employees
GROUP BY department
HAVING COUNT(*) > 5;

-- 找出平均薪水超過 50000 的部門
SELECT department, AVG(salary) as avg_salary
FROM employees
GROUP BY department
HAVING AVG(salary) > 50000;
```

---

### 4. JOIN（連接）

#### INNER JOIN（內連接）
```sql
-- 基本 INNER JOIN
SELECT users.name, orders.order_date
FROM users
INNER JOIN orders ON users.id = orders.user_id;

-- 簡寫（INNER 可省略）
SELECT u.name, o.order_date
FROM users u
JOIN orders o ON u.id = o.user_id;
```

#### LEFT JOIN（左連接）
```sql
-- 返回 users 表的所有記錄，加上匹配的 orders 記錄
SELECT u.name, o.order_date
FROM users u
LEFT JOIN orders o ON u.id = o.user_id;
```

#### RIGHT JOIN（右連接）
```sql
-- 返回 orders 表的所有記錄，加上匹配的 users 記錄
SELECT u.name, o.order_date
FROM users u
RIGHT JOIN orders o ON u.id = o.user_id;
```

#### FULL OUTER JOIN（完全外連接）
```sql
-- 返回兩個表的所有記錄
SELECT u.name, o.order_date
FROM users u
FULL OUTER JOIN orders o ON u.id = o.user_id;

-- MySQL 不支持 FULL OUTER，可用 UNION 替代
SELECT u.name, o.order_date
FROM users u
LEFT JOIN orders o ON u.id = o.user_id
UNION
SELECT u.name, o.order_date
FROM users u
RIGHT JOIN orders o ON u.id = o.user_id;
```

---

### 5. 子查詢

```sql
-- 子查詢在 WHERE 中
SELECT * FROM employees
WHERE salary > (
    SELECT AVG(salary) FROM employees
);

-- 子查詢返回多行
SELECT * FROM employees
WHERE department_id IN (
    SELECT id FROM departments WHERE location = 'NYC'
);

-- EXISTS 子查詢
SELECT * FROM employees e
WHERE EXISTS (
    SELECT 1 FROM orders o WHERE o.user_id = e.id
);

-- 相關子查詢
SELECT name, (
    SELECT COUNT(*) FROM orders o WHERE o.user_id = u.id
) as order_count
FROM users u;
```

---

### 6. CASE 語句

```sql
-- 簡單 CASE
SELECT 
    name,
    CASE status
        WHEN 1 THEN 'Active'
        WHEN 2 THEN 'Inactive'
        ELSE 'Unknown'
    END as status_name
FROM users;

-- 搜索 CASE
SELECT 
    name,
    CASE 
        WHEN age < 18 THEN 'Minor'
        WHEN age >= 18 AND age < 65 THEN 'Adult'
        ELSE 'Senior'
    END as age_group
FROM users;
```

---

### 7. 日期函數

```sql
-- 當前日期和時間
SELECT NOW(), CURDATE(), CURTIME();

-- 日期計算
SELECT DATE_ADD(NOW(), INTERVAL 1 DAY);  -- 加 1 天
SELECT DATE_SUB(NOW(), INTERVAL 1 MONTH); -- 減 1 月

-- 日期提取
SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW());

-- 日期比較
SELECT * FROM orders 
WHERE order_date > DATE('2023-01-01');

-- 時間差
SELECT DATEDIFF('2023-12-31', '2023-01-01');  -- 天數
```

---

### 8. 窗口函數（進階）

```sql
-- ROW_NUMBER：行號
SELECT 
    name,
    salary,
    ROW_NUMBER() OVER (ORDER BY salary DESC) as rank
FROM employees;

-- RANK：排名（有並列）
SELECT 
    name,
    salary,
    RANK() OVER (ORDER BY salary DESC) as rank
FROM employees;

-- DENSE_RANK：密集排名
SELECT 
    name,
    salary,
    DENSE_RANK() OVER (ORDER BY salary DESC) as rank
FROM employees;

-- 分組排名
SELECT 
    department,
    name,
    salary,
    RANK() OVER (PARTITION BY department ORDER BY salary DESC) as rank
FROM employees;
```

---

## 快速查詢表

### Java 時間複雜度

| 操作 | HashMap | HashSet | ArrayList | LinkedList | Stack | Queue |
|------|---------|---------|-----------|------------|-------|-------|
| 添加 | O(1) | O(1) | O(n) | O(1) | O(1) | O(1) |
| 刪除 | O(1) | O(1) | O(n) | O(n) | O(1) | O(1) |
| 查詢 | O(1) | O(1) | O(1) | O(n) | O(1) | O(1) |
| 排序 | - | - | O(n log n) | O(n log n) | - | - |

### SQL 子句執行順序
```
1. FROM
2. WHERE
3. GROUP BY
4. HAVING
5. SELECT
6. ORDER BY
7. LIMIT
```

---

## 常用代碼模板

### LeetCode 1：Two Sum
```java
class Solution {
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
}
```

### LeetCode 20：Valid Parentheses
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
```

### LeetCode 206：Reverse Linked List
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
```

### LeetCode 104：Maximum Depth of Binary Tree
```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```

---

## 調試技巧

### Java 調試
```java
// 打印陣列
System.out.println(Arrays.toString(nums));

// 打印集合
System.out.println(map.keySet());
System.out.println(map.values());

// 鏈表調試
ListNode current = head;
while (current != null) {
    System.out.print(current.val + " -> ");
    current = current.next;
}
System.out.println("null");
```

### SQL 調試
```sql
-- 先查詢分組前的數據
SELECT * FROM orders;

-- 再加上 GROUP BY
SELECT user_id, COUNT(*) FROM orders GROUP BY user_id;

-- 驗證 JOIN 條件
SELECT * FROM users 
LEFT JOIN orders ON users.id = orders.user_id
LIMIT 10;
```

---

**記住：這份指南是你的速查手冊，經常回來查閱就能越來越熟練！** 🚀
