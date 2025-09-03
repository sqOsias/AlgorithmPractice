package LingBinaryAlgorithm.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 */
class Solution12_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = lowerBound(arr,x);
        int left = right-1;
        while(k-->0){
            if (left<0){
                right++;
            }else if(right>=arr.length){
                left--;
            }else if(x-arr[left]<=arr[right]-x){
                left--;
            }else{
                right++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;

    }

    public int lowerBound(int[] arr ,int target){
        int left =-1,right = arr.length;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if(arr[mid]>=target){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }
}