package java_projects.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q_TestStream {
    public static void main(String[] args) {
        // 原始的整數清單
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 🔴 請在下方使用 Stream API 完成任務：
        // 任務：篩選出「偶數」（n % 2 == 0），並將它們「乘上 10 倍」（n * 10），最後收集成新的 List。
        // 提示：
        // 1. numbers.stream() 開啟 Stream
        // 2. .filter(n -> 篩選偶數的條 件)
        // 3. .map(n -> 乘上 10 的轉換)
        // 4. .collect(Collectors.toList()) 收集結果
        List<Integer> result = numbers.stream()
        		.filter(n -> n % 2 == 0)
        		.map(n -> n * 10)
        		.collect(Collectors.toList());

        // 印出結果，預期輸出: [20, 40, 60, 80, 100]
        System.out.println("原始清單: " + numbers);
        System.out.println("處理後的清單: " + result);

        System.out.println("\n--- 🔴 練習二：方法參照 (Method Reference) ---");
        // 任務：使用 result.forEach() 搭配「方法參照 System.out::println」逐行印出 result 中的元素。
        // 提示：原本寫法是 result.forEach(n -> System.out.println(n));
//        result.forEach(n -> System.out.println(n));
        result.forEach(System.out ::println);

        System.out.println("\n--- 🔴 練習三：聚合操作 (Reduce) ---");
        // 任務：使用 result.stream().reduce() 計算 result 清單中所有數字的「加總」。
        // 提示：使用 reduce(初始值, (累加值, 當前值) -> 累加值 + 當前值)
        // [請在此處編寫代碼]
        int sum = result.stream().reduce(0, (sumVal, n) -> sumVal + n);
        System.out.println("所有數字加總結果（預期為 300）: " + sum);
    }
}
