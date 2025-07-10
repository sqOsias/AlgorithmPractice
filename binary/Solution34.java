package binary;

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left=0 ,right=nums.length-1;
        int index=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                index=mid;
                break;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if(index==-1){
            return new int[]{-1,-1};
        }
        int leftIndex=index;
        while(leftIndex>0 && nums[leftIndex-1]==target){
            leftIndex--;
        }
        int rightIndex=index;
        while(rightIndex<nums.length-1 && nums[rightIndex+1]==target){
            rightIndex++;
        }
        return new int[]{leftIndex,rightIndex};

    }
}