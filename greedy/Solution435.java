package greedy;

import java.util.Arrays;

class Solution435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int result = 1;//非交叉区间
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                result++;
                end = intervals[i][1];
            }
        }
        return intervals.length - result;

    }
}