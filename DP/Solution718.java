package DP;

class Solution718 {
    public int findLengthOfLCIS(int[] nums1, int[] nums2) {

        int min=Math.min(nums1.length,nums2.length);
        int res=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int count=0;
                for (int k = 0; i+k<nums1.length&&j+k<nums2.length; k++) {
                    if (nums1[i+k]==nums2[j+k]){
                        count++;
                    }else{
                        break;
                    }

                }
                res=Math.max(res,count);
            }
        }
        return res;

    }

    public int findLengthOfLCIS2(int[] nums1, int[] nums2) {
        int [][]dp=new int[nums1.length+1][nums2.length+1];

//        for (int i = 0; i < nums1.length; i++) {
//            dp[i][0]=0;
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            dp[0][i]=0;
//        }
        int res=0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }

    public int findLengthOfLCIS3(int[] nums1, int[] nums2) {
        int [][]dp=new int[nums1.length][nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i]==nums2[0]){
                dp[i][0]=1;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i]==nums1[0]){
                dp[0][i]=1;
            }
        }
        int res=0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++){
                if(nums1[i]==nums2[j]&&i>0&&j>0){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();
        int i = solution718.findLengthOfLCIS(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7});
        System.out.println(i);
        i = solution718.findLengthOfLCIS(new int[]{0,1,1,1,1}, new int[]{1,0,1,0,1});
        System.out.println(i);
    }
}