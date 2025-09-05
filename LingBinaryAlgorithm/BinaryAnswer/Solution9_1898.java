package LingBinaryAlgorithm.BinaryAnswer;

import java.util.Arrays;

/**
 *给你两个字符串 s 和 p ，其中 p 是 s 的一个 子序列 。同时，给你一个元素 互不相同 且下标 从 0 开始 计数的整数数组 removable ，该数组是 s 中下标的一个子集（s 的下标也 从 0 开始 计数）。
 * 请你找出一个整数 k（0 <= k <= removable.length），选出 removable 中的 前 k 个下标，然后从 s 中移除这些下标对应的 k 个字符。整数 k 需满足：在执行完上述步骤后， p 仍然是 s 的一个 子序列 。更正式的解释是，对于每个 0 <= i < k ，先标记出位于 s[removable[i]] 的字符，接着移除所有标记过的字符，然后检查 p 是否仍然是 s 的一个子序列。
 * 返回你可以找出的 最大 k ，满足在移除字符后 p 仍然是 s 的一个子序列。
 * 字符串的一个 子序列 是一个由原字符串生成的新字符串，生成过程中可能会移除原字符串中的一些字符（也可能不移除）但不改变剩余字符之间的相对顺序。
 */
class Solution9_1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length+1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(s, p, removable, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left ;
    }

    private boolean check(String s, String p, int[] removable, int mid) {
        char[] S = s.toCharArray();
        for (int i = 0; i < mid; i++) {
            S[removable[i]] = '0';
        }
        String s1 = Arrays.toString(S);
        char[] P = p.toCharArray();
        int i = 0,j=0;
        while (i < s1.length() && j < P.length) {
            if (s1.charAt(i) == P[j]){
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == P.length;
    }

    public static void main(String[] args) {
        Solution9_1898 solution = new Solution9_1898();
        String s = "qlevcvgzfpryiqlwy";
        String p = "qlecfqlw";
        int[] removable = {12,5};
        int ans = solution.maximumRemovals(s, p, removable);
        System.out.println(ans);
    }
}