package greedy;

import java.util.Arrays;
import java.util.LinkedList;

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {

        int n = people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]) {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();
        for(int[] p:people){
            que.add(p[1],p);
        }
        return que.toArray(new int[n][]);


    }
}