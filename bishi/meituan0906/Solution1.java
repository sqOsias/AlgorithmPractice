package bishi.meituan0906;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 已知一套试卷包含多个x-dp算法，即x类型的dp（保证x不为空且不含‘d’和‘p
 * 两个字符）。例如sosdp，adp，其拼接起来为sosdpadp，构成了一套完整的试卷。
 * 现在便可以得到该试卷中存在若干类型的dp算法，你需要知道有多少种本质不同的dp
 * 算法，即有多少种不同类型的算法。保证s 可以被唯一地分割为一个或多个形如x+dp
 * 的段。
 */

/**
 * 输入：在一行上输入一个仅由小写字母组成的字符串s，表示试卷
 * 输出一个整数，表示给定试卷中存在多少中不同类型的的dp算法
 * 输入：adpbdpadp
 * 输出：2
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(getDpCount(s));
        }
    }


    public static int getDpCount(String s) {
        int count = 0;
        int i = 0;
        if (s.isEmpty()) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) != 'd'
                    && s.charAt(j) != 'p') {
                j++;
            }
            if (j > i) {
                if (map.containsKey(s.substring(i, j))){
                    map.merge(s.substring(i, j), 1, (a, b)->a+1);
                }else{
                    map.put(s.substring(i, j), 1);
                    count++;
                }
            }
            i = j + 1;
        }
        return count;
    }
}
