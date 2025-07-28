package LingTwoNoFixedLengthSlipWindow;

/**
 * 给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
 *
 * 子字符串 是字符串中的一个连续、 非空 的字符序列。
 * 输入： s = "abacb", k = 2
 *
 * 输出： 4
 */
class Solution18_3325 {
    public int numberOfSubstrings(String s, int k) {
        char[] S = s.toCharArray();
        int n = S.length;
        int[]cnt = new int[128];
        int ans = 0;
        for (int left = 0 ,right = 0; right < n; right++) {
            cnt[S[right]]++;
            while(cnt[S[right]] == k){
                cnt[S[left]]--;
                left++;
            }
            ans += left;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution18_3325 s = new Solution18_3325();
        System.out.println(s.numberOfSubstrings("abcde", 1));
    }
}