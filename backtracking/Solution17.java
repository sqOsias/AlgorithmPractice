package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution17 {
    private List<String> result=new ArrayList<>();
    StringBuffer path = new StringBuffer();
    Map<Character, char[]> map = Map.of(
            '2', new char[]{'a', 'b', 'c'},
            '3', new char[]{'d', 'e', 'f'},
            '4', new char[]{'g', 'h', 'i'},
            '5', new char[]{'j', 'k', 'l'},
            '6', new char[]{'m', 'n', 'o'},
            '7', new char[]{'p', 'q', 'r', 's'},
            '8', new char[]{'t', 'u', 'v'},
            '9', new char[]{'w', 'x', 'y', 'z'}
    );
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        backtracking(digits, 0);
        return result;

    }

    public void backtracking(String digits, int index) {
        if(index==digits.length()){
            result.add(path.toString());
            return;
        }
        char[] chars = map.get(digits.charAt(index));
        for (char c : chars) {
            path.append(c);
            backtracking(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        String digits = "23";
        List<String> strings = solution17.letterCombinations(digits);
        System.out.println(strings);
    }


}