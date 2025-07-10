package binary;

class Solution33 {
    public int search(int[] nums, int target) {
        int firstNum=nums[0];
        int leftNum=0;
        int rightIndex=nums.length-1;
        while(firstNum>nums[rightIndex]){
            leftNum++;
            rightIndex--;
        }
        int mid = nums.length-1-leftNum;
        int res=-1;
        int left=0,right=mid;
        while(left<=right){
            int midIndex=(left+right)/2;
            if(nums[midIndex]==target){
                res=midIndex;
                break;
            }
            if(nums[midIndex]>target){
                right=midIndex-1;
            }else{
                left=midIndex+1;
            }
        }
        if(res==-1){
            left=mid+1;
            right=nums.length-1;
            while(left<=right){
                int midIndex=(left+right)/2;
                if(nums[midIndex]==target){
                    res=midIndex;
                    break;
                }
                if(nums[midIndex]>target){
                    right=midIndex-1;
                }else{
                    left=midIndex+1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(new Solution33().search2(nums, target));
    }

    public int search2(int[] nums, int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return mid;
            }
            if(nums[0]<=nums[mid]){
                if(nums[0]<=target&&target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(nums[mid]<target&&target<=nums[nums.length-1]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}