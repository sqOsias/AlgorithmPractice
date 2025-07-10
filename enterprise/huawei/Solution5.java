package enterprise.huawei;

class Solution5 {
    public String longestPalindrome(String s) {
        int len =s.length();
        if (len<2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int L=1;L<len;L++){
            for (int i = 0; i < len; i++){
                int j = i+L;
                if (j>=len){
                    break;
                }
                if (s.charAt(i)==s.charAt(j)){
                    if (L<2){
                        dp[i][j] = true;
                    }else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j]){
                    maxLen = L+1;
                    begin = i;
                }
            }

        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String str = "babad";
        System.out.println(s.longestPalindrome(str));
    }
}