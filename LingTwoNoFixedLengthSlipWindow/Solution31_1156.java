package LingTwoNoFixedLengthSlipWindow;

import java.util.HashMap;

/**
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 */
class Solution31_1156 {
    public int maxRepOpt1(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] S = text.toCharArray();
        for (char s: S ){
            map.merge(s,1,Integer::sum);
        }
        int res = 0;
        for (int i=0;i<S.length;){
            int j =i;
            while(j<S.length && S[i]==S[j]){
                j++;
            }
            int cnt = j-i;

            if(cnt <map.getOrDefault(S[i],0)&&(j<S.length||i>0)){
                res = Math.max(res, cnt+1);
            }
            int k= j+1;
            while(k<S.length && S[k]==S[i]){
                k++;
            }
            res=Math.max(res,Math.min(k-i,map.getOrDefault(S[i],0)));
            i=j;
        }
        return res;
    }
}