package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));//按照左边界的升序排序
        List<int[]> result = new LinkedList<>();
        int start=intervals[0][0];
        int rightmost=intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0]<=rightmost){
                rightmost=Math.max(rightmost,intervals[i][1]);
            }else{
                result.add(new int[]{start,rightmost});
                start=intervals[i][0];
                rightmost=intervals[i][1];
            }
        }
        result.add(new int[]{start,rightmost});



        return result.toArray(new int[result.size()][]);
    }
}