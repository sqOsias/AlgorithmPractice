package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuffer sb = new StringBuffer();
    List<String> result = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        backtracking(digits, 0);
        return result;
    }

    public void backtracking(String digits, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;

        }
        String str = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);

        }

    }


}