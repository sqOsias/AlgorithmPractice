package DP;

class Solution329 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i=0,j=0;
        while(i<n&&j<m ){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==n;
    }

    public boolean isSubsequence1(String s, String t) {
        int[][]dp=new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < t.length() + 1; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()]==s.length();

    }



    public static void main(String[] args) {
        Solution329 solution329 = new Solution329();
        boolean subsequence = solution329.isSubsequence1("abc", "ahbgdc");
        System.out.println(subsequence);

        boolean subsequence1 = solution329.isSubsequence1("axc", "ahbgdc");
        System.out.println(subsequence1);
        boolean subsequence2 = solution329.isSubsequence1("acb", "ahbgdc");
        System.out.println(subsequence2);
    }


}