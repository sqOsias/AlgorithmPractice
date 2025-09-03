package LingBinaryAlgorithm.BinaryAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个仅由小写英文字母组成的字符串 s 。
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 */
class Solution7_2982 {
    public int maximumLength(String s) {
        char[] S = s.toCharArray();
        List<Integer>[]groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for (int i = 0; i < S.length; i++){
            cnt ++;
            if (i == S.length - 1 || S[i] != S[i + 1]){
                groups[S[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }

        int ans = 0;
        for (List<Integer> a: groups){
            if (a.isEmpty())continue;
            a.sort(Collections.reverseOrder());
            a.add(0);
            a.add(0);
            ans=Math.max(ans,Math.max(a.get(0)-2,Math.max(Math.min(a.get(0)-1,a.get(1)),a.get(2))));
        }
        return ans>0?ans:-1;
    }
}