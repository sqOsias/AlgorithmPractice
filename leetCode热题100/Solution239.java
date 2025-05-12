package leetCode热题100;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution239 {
    //超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0){
            return new int[0];
        }
        int lt=0;
        int rk=lt+k-1;
        int []res=new int[nums.length-k+1];
        while(rk<nums.length){
            int max=nums[lt];
            for (int i = 1; i < k; i++) {
                max=Math.max(max,nums[lt+i]);
            }
            res[lt]=max;
            lt++;
            rk++;
        }
        return res;

    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            System.out.println("当前窗口最大值："+pq.peek()[0]);
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution239 s=new Solution239();
        int []nums={1,7,-1,-3,5,3,6,7};
        int k=3;
        int []res=s.maxSlidingWindow1(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}