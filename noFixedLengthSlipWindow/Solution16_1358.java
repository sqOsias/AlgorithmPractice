package noFixedLengthSlipWindow;

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 */
class Solution16_1358 {
    public int numberOfSubstrings(String s) {
        char[] S = s.toCharArray();
        int n = S.length;
        int[] last = new int[3];
        int ans=0;
        for (int left =0 , i = 0; i < n;i++) {
            last[S[i] - 'a'] ++;
            while(last[0] > 0 && last[1] > 0 && last[2] > 0){
                last[S[left] - 'a'] --;
                left++;
            }
            ans += left;
        }
        return ans;
    }
}