package leetCode热题100;
// 给定一个字符串 s，请你找出其中不含有重复字符的 最长 子串 的长度。

// 示例 1:

// 输入:s="abcabcbb"输出:3 解释:因为无重复字符的最长子串是"abc"，所以其长度为 3。示例 2:

// 输入:s="bbbbb"输出:1 解释:因为无重复字符的最长子串是"b"，所以其长度为 1。示例 3:

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// 输入:s="pwwkew"输出:3 解释:因为无重复字符的最长子串是"wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
public class solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int[] res = new int[s.length()];
        ArrayList chars = new ArrayList<Character>();
        chars.add(s.charAt(0));
        res[0] = 1;
        for (int i = 1; i <s.length(); i++) {
            if (!chars.contains(s.charAt(i))) {
                res[i] = res[i - 1] + 1;
                chars.add(s.charAt(i));
            } else {
//                res[i] = 1;
//                chars.clear();
//                chars.add(s.charAt(i));
                int index = chars.indexOf(s.charAt(i));
                chars = new ArrayList<>(chars.subList(index + 1, chars.size()));
                res[i] = res[i - 1] - index;
                chars.add(s.charAt(i));

            }

        }
        int max = 0;
        for (int i = 0; i < res.length; i++) {
            max = Math.max(max, res[i]);

        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for(int i=0;i<n;i++){
            if(i!=0){
                occ.remove(s.charAt(i-1));
            }
            while(rk+1<n&&!occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }


    public static void main(String[] args) {
        solution3 s = new solution3();
        String str = "dvdf";
        System.out.println(s.lengthOfLongestSubstring(str));
    }

}
