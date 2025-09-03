package LingBinaryAlgorithm.BinarySearch;

import java.util.Arrays;

/**
 * 定义一个函数 f(s)，统计 s  中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
 * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
 */
class Solution9_1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int []nums=new int [words.length];
        for (int i = 0; i < words.length; i++){
            nums[i]= f(words[i]);
        }
        Arrays.sort(nums);
        int []ans=new int [queries.length];
        for (int i = 0; i < queries.length; i++){
            int target = f(queries[i]);
            int left =-1, right = nums.length;
            while(left+1 < right){
                int mid = left + (right - left) / 2;
                if (nums[mid] > target){
                    right = mid;
                }else{
                    left = mid;
                }
                }
            ans[i]= nums.length-right;
            }
        return ans;
        }


    public int f(String s){
        int[] cnt = new int[26];
        for (char c : s.toCharArray()){
            cnt[c - 'a']++;
        }
        for (int x: cnt){
            if (x > 0){
                return x;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String[] queries = {"bbb","cc"};
        String[] words = {"a","aa","aaa","aaaa"};
        Solution9_1170 s = new Solution9_1170();
        int[] ans = s.numSmallerByFrequency(queries, words);
        for (int x: ans){
            System.out.print(x+" ");
        }
    }
}