package stackk;

import java.util.Stack;

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i=1;i<s.length();i++){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else {
                char c = stack.peek();
                if (c=='('&&s.charAt(i)==')'||c=='['&&s.charAt(i)==']'||c=='{'&&s.charAt(i)=='}'){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        Solution20 s = new Solution20();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("{[]}"));
    }
}