package binary;

import java.util.Arrays;

class Solution153 {
    public int findMin2(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }



    public static void main(String[] args) {
        Solution153 s = new Solution153();
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(s.findMin(nums));
    }
}