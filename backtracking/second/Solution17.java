package backtracking.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    List<String>res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, String>map  =new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        int length = digits.length();
        backtracking(0,length,digits ,map);
        return res;

    }

    public void backtracking(int index,int length,String digits,Map<Character, String>map){
        if (index == length){
            res.add(sb.toString());
            return;
        }

        String s = map.get(digits.charAt(index));
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backtracking(index+1,length,digits,map);
            sb.delete(sb.length()-1,sb.length());
        }

    }
    public static void main(String[] args) {
        Solution17 s=new Solution17();
        List<String>res=s.letterCombinations("23");
        System.out.println(res);
    }

}
