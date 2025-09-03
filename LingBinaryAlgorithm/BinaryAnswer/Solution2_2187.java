package LingBinaryAlgorithm.BinaryAnswer;

import java.util.Arrays;

/**
 * 给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
 * 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行且互不影响。
 * 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
 */
class Solution2_2187 {
    public long minimumTime(int[] time, int totalTrips) {
        int minT=Integer.MAX_VALUE;
        for (int t:time){
            minT = Math.min(minT,t);
        }
        long left = minT-1;
        long right =(long) minT * totalTrips;
        while(left+1<right){
            long mid = (left+right)>>>1;
            if (check(mid,time,totalTrips)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public boolean check(long index, int[] time, int totalTrips ){
        long sum = 0;
        for (int i = 0; i < time.length; i++){
            sum+= index / time[i];
            if (sum >= totalTrips){
                return true;
            }
        }
        return false;
    }
}