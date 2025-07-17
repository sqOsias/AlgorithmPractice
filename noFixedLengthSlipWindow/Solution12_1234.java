package noFixedLengthSlipWindow;

//替换子串得到平衡字符串
//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
//
//假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
//
//
//
//给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
//
//你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
//
//请返回待替换子串的最小可能长度。
//
//如果原字符串自身就是一个平衡字符串，则返回 0。
class Solution12_1234 {
    public int balancedString(String s) {
        char[] S = s.toCharArray();
        int[]  cnt = new int ['x'];
        for (char c : S){
            cnt[c]++;
        }
        int n = S.length;
        int k = n / 4;
        if (cnt['Q'] == k && cnt['W'] == k && cnt['E'] == k && cnt['R'] == k){
            return 0;
        }
        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++){
            cnt[S[right]]--;
            while (cnt['Q'] <= k && cnt['W'] <= k && cnt['E'] <= k && cnt['R'] <= k){
                ans = Math.min(ans,right-left+1);
                cnt[S[left]]++;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution12_1234 solution = new Solution12_1234();
        System.out.println(solution.balancedString("QWER"));
        System.out.println(solution.balancedString("QQWE"));
        System.out.println(solution.balancedString("QQQW"));
        System.out.println(solution.balancedString("QQQQ"));
    }
}