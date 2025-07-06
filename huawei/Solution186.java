package huawei;

import java.util.ArrayList;
import java.util.List;

class Solution186 {

    public void reverseWords(char[] s) {

        // e u l b "" s i "" y k s "" e h t
        // b l u e "" i s "" s k y "" t h e
        reverse(s, 0, s.length - 1);
        int start = 0;
        for (int end = 0; end <= s.length; end++) {
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }

    }

    public void reverse(char[] s, int start, int end) {

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }
    public static void main(String[] args) {
        Solution186 solution186 = new Solution186();
        char[] s = "the sky is blue".toCharArray();
        solution186.reverseWords(s);
        System.out.println(s);
    }
}