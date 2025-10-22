package LingTwoNoFixedLengthSlipWindow;

/**
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * <p>
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * <p>
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
 */
class Solution22_3258 {
    public int countKConstraintSubstrings(String s, int k) {
        char[] S = s.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[2];
        for (int i = 0; i < S.length; i++) {
            cnt[S[i] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[S[left] & 1]--;
                left++;
            }
            ans += i - left + 1;
        }
        return ans;

    }

    public int countKConstraintSubstrings1(String s, int k) {
        char[] S = s.toCharArray();
        int[] cnt = new int[2];
        int res = 0;
        for (int left = 0, right = 0; right < S.length; right++) {
            cnt[S[right] & 1]++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[S[left] & 1]--;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
