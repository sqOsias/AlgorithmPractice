package leetCode热题100;

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[]ansl=new int[nums.length];
        ansl[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            ansl[i]=ansl[i-1]*nums[i];
        }
        int[]ansr=new int[nums.length];
        ansr[nums.length-1]=nums[nums.length-1];
        for (int i = nums.length-2; i >=0 ; i--) {
            ansr[i]=ansr[i+1]*nums[i];
        }
        int[]ans=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                ans[i]=ansr[i+1];
            }else if (i==nums.length-1){
                ans[i]=ansl[i-1];
            }else {
                ans[i]=ansl[i-1]*ansr[i+1];
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        Solution238 solution238=new Solution238();
        int[] nums={1,2,3,4};
        int[] res=solution238.productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}