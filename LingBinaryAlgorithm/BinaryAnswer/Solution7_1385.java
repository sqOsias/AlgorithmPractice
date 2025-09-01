package LingBinaryAlgorithm.BinaryAnswer;

import java.util.Arrays;

/**
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 */

/**
 * 思路：
 * 把 arr2从小到大排序，这样我们可以二分查找。
 * 在arr2中二分查找>=x-d的最小的数，如果不存在或者大于x+d，则说明arr2没有在【x-d,x+d】区间内的元素，ans++
 */
class Solution7_1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans=0;
        for(int x:arr1){
            //如果未找到目标值，返回负数，表示插入位置的负值减1
            int i= Arrays.binarySearch(arr2,x-d);
            if (i < 0) {
                i = ~i; // -i - 1 处理Arrays.binarySearch的返回值,
            }
            if(i == arr2.length || arr2[i]>x+d){
                ans++;
            }
        }
        return ans;
    }
}