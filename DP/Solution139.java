package DP;

import java.util.List;

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[]dp = new boolean[s.length()+1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i]=false;
        }
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]&& wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];

    }

//    public static void main(String[] args) {
//        Solution139 solution139 = new Solution139();
//        System.out.println(solution139.wordBreak("leetcode", List.of("leet","code")));
//        solution139.wordBreak("applepenapple", List.of("apple","pen"));
//        solution139.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));
//        solution139.wordBreak("cars", List.of("car","ca","rs"));
//
//    }
}