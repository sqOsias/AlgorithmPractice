package DP;

class Solution647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                if (isPalindrome(s, i, j)){
                    count++;
                }
            }

        }
        return  count;
    }
    public int countSubstrings1(String s) {
        int count = 0;
        boolean [][]dp = new boolean[s.length()][s.length()];


        for (int i = s.length(); i >=0; i--){
            for (int j = i; j < s.length(); j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1){
                        dp[i][j]=true;
                        count++;
                    }else if (dp[i+1][j-1]){
                        dp[i][j]=true;
                        count++;
                    }
                }

            }

        }
        return  count;
    }


    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}