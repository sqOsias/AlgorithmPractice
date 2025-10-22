package bishi.huawei0917;

import java.util.Scanner;

/**
 * 在一个虚拟货币挖矿系统中，每个矿工拥有一定的算力值n（范围在1到10^18之间），
 * 系统需要为每个矿工分配一个算力裆位，这个裆位必须是小于等于矿工当前算力n的最大“稳定算力档”，并且这个裆位的算力值各个数位之和必须是一个质数。
 * “稳定算力档”定义为从左到右每一位数字都不小于前一位数字，例如123、111、399都是符合要求的稳定算力档
 * 合理分配算力档有助于提高挖矿的效率和稳定性
 * 输入：一个正整数
 * 输出：返回小于等于n的最大稳定算力档，且该整数的所有位数之和为质数，如果不存在这样的整数，则返回-1
 * 案例1：输入123 输出122
 */
public class Main2 {
    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            long n = scanner.nextLong();
            System.out.println(maxStable(n));
        }
        scanner.close();
    }
    /**
     * 获取最大稳定算力档
     * @param n
     */
    public static long maxStable(long n){
        String str = String.valueOf(n);
        char[] digits = str.toCharArray();

        // 先检查原数字是否满足条件
        if (isStable(n) && isPrime(digitSum(n))) {
            return n;
        }

        // 从右往左尝试减少某一位，并将右边的位设置为合适的值
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > '0') {
                digits[i]--;
                // 将右边所有位设置为与当前位相同，确保是非递减的
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = digits[i];
                }

                // 构造新数字
                long candidate = Long.parseLong(new String(digits));
                long sum = digitSum(candidate);

                // 检查是否满足条件
                if (isStable(candidate) && isPrime(sum)) {
                    return candidate;
                }
            }
        }

        // 如果上面的方法找不到，尝试构造一些较小的稳定数
        // 例如：99, 999, 9999, ...
        for (int len = str.length() - 1; len >= 1; len--) {
            // 构造全为9的数字
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append('9');
            }
            long candidate = Long.parseLong(sb.toString());
            if (isPrime(digitSum(candidate))) {
                return candidate;
            }

            // 构造全为8的数字
            sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append('8');
            }
            candidate = Long.parseLong(sb.toString());
            if (isPrime(digitSum(candidate))) {
                return candidate;
            }

            // 构造全为7的数字
            sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append('7');
            }
            candidate = Long.parseLong(sb.toString());
            if (isPrime(digitSum(candidate))) {
                return candidate;
            }
        }

        return -1;
    }
    /**
     * 计算各位数字之和
     * @param n
     * @return
     */
    public static long digitSum(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    /**
     * 判断是否是质数
     * @param n
     */
    public static boolean isPrime(long n){
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 判断是否是稳定算力档
     */
    public static boolean isStable(long n){
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < chars[i-1]) {
                return false;
            }
        }
        return true;
    }

}