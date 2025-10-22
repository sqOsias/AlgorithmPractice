package bishi.meituan0906;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 小美有一个长度为n的数组α。你可以将α任意重排。定义一个长度为n的数组b，其
 * 中 bi=MEX(α1,α2,...,αi)。你需要最大化数组b 中的元素之和。
 * 你需要输出最大的元素和，以及一个可能的α的重排方案。
 * 【名词解释】
 * MEX：整数数组的MEX定义为没有出现在数组中的最小非负整数。例如
 * MEX{1,2,3} = 0、MEX{0,2,5} = 1.
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            // 重新排列以最大化MEX和
            int[] rearranged = rearrangeForMaxMexSum(a);

            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = getMex(a, i);
            }
            System.out.println(getSum(b));
            for (int i = 0; i < n-1; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.print(a[n-1]);
        }
    }

    private static int[] rearrangeForMaxMexSum(int[] a) {
        int n = a.length;
        int[] result = new int[n];

        // 统计每个数字的出现次数
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : a) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 贪心策略：优先放置较小的数字
        int idx = 0;
        for (int i = 0; i <= n && idx < n; i++) {
            int freq = count.getOrDefault(i, 0);
            // 每个数字最多放置一次在前面位置
            for (int j = 0; j < Math.min(freq, 1) && idx < n; j++) {
                result[idx++] = i;
            }
        }

        // 填充剩余位置
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int j = 1; j < freq && idx < n; j++) {
                result[idx++] = num;
            }
        }

        return result;
    }
    private static int getMex(int[] a, int i) {
        HashMap<Integer, Integer> cnt = new HashMap<>();

        // 统计前i+1个元素的出现次数
        for (int j = 0; j <= i; j++) {
            cnt.put(a[j], cnt.getOrDefault(a[j], 0) + 1);
        }

        // 查找MEX
        for (int j = 0; ; j++) {
            if (!cnt.containsKey(j)) {
                return j;
            }
        }
    }

    private static int getSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

}
