package binary;

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        Solution35 s=new Solution35();
        int[] nums={1,3,5,6};
        int target=7;
        System.out.println(s.searchInsert(nums, target));
    }
}