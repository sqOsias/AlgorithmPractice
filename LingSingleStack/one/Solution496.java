package LingSingleStack.one;

import java.util.*;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n= nums1.length;
        Map<Integer,Integer> idx= new HashMap<>(n,1);
        for (int i=0;i<n;i++){
            idx.put(nums1[i],i);
        }
        int[]ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st= new ArrayDeque<>();
        for(int i= nums2.length-1;i>=0;i--){
            int x= nums2[i];
            while(!st.isEmpty()&&x>=st.peek()){
                st.pop();
            }
            if (!st.isEmpty()&&idx.containsKey(x)){
                ans[idx.get(x)] = st.peek();
            }
            st.push(x);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution496 solution496 = new Solution496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ints = solution496.nextGreaterElement(nums1, nums2);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}