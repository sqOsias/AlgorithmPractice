package DP;



class Solution213 {
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        return Math.max(robAction(nums,0,nums.length-1),robAction(nums,1,nums.length));



    }
    int robAction(int[] nums,int start,int end){

//        int x=0,y=0,z=0;
//        for (int i=start;i<end;i++){
//            y=z;
//            x=y;
//            z=Math.max(x+nums[i],y);
//
//        }
        if(start==end){
            return nums[start];
        }
        if (end-start==1){
            return Math.max(nums[start],nums[end]);
        }
        int[]dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for (int i = start+2 ; i <=end ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);

        }

        return dp[end];


    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(new int[]{1,2,3,1}));
        solution198.rob(new int[]{2,7,9,3,1});
    }
}