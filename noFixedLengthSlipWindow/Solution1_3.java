package noFixedLengthSlipWindow;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
class Solution1_3 {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int res=0;
        int left=0;
        int[]cnt=new int[128];
        for (int right= 0;right<n;right++){
            // 1、向右扩展窗口
            cnt[charArray[right]]++;
            // 2、缩小窗口
            while (cnt[charArray[right]] > 1) {
                cnt[charArray[left]]--;
                left++;
            }
            // 3、更新答案
            res=Math.max(res,right-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1_3 solution1_3 = new Solution1_3();
        String s = "pwwke";
        int res = solution1_3.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}