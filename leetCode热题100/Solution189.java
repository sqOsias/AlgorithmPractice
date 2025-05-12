package leetCode热题100;

class Solution189 {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int []newNums=new int[n];
        for (int i = 0; i < n; i++){
            newNums[(i+k)%n]=nums[i];
        }
        System.arraycopy(newNums,0,nums,0,n);
    }
}