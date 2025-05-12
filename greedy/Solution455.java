package greedy;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start=s.length-1;

        for (int i = g.length-1; i >=0; i--) {
            if(start>=0&&s[start]>=g[i]){
                count++;
                start--;
            }
        }
        return count;

    }
}