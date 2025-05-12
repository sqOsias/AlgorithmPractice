package jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//给出一个仅由大写字母"AB"构成的字符串s，
// 请你求出s中包含'A'和'B'个数相同的连续区间的最长长度。
public class t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int maxLen = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1); // 初始化，处理从起始位置开始的子串

        for (int i = 0; i < s.length(); i++) {
            // 将'A'视为+1，'B'视为-1
            currentSum += (s.charAt(i) == 'A') ? 1 : -1;

            // 若当前差值已存在，计算区间长度
            if (sumIndexMap.containsKey(currentSum)) {
                maxLen = Math.max(maxLen, i - sumIndexMap.get(currentSum));
            } else {
                sumIndexMap.put(currentSum, i); // 记录首次出现该差值的索引
            }
        }
        System.out.println(maxLen);
    }

    public static int longestSubstring(String s) {
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='A'){
                count++;
            }
        }
        return Math.min(count,s.length()-count);
    }

    public static void longestSubstring1(String s) {
        int i = longestSubstring(s);
        System.out.println(2*i);
    }
}
