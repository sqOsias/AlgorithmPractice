package leetCode热题100;

import java.util.HashMap;

class Solution26 {
    public int removeDuplicates(int[] nums) {
        HashMap < Integer, Integer > mp = new HashMap < > ();
        int fastIndex= 0, slowIndex = 0;
        while(fastIndex<nums.length){
            if(!mp.containsKey(nums[fastIndex])){
                mp.put(nums[fastIndex],1);
                nums[slowIndex++]=nums[fastIndex++];
            }else{
                fastIndex++;

            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = {1, 1, 2};
        int i = solution26.removeDuplicates(nums);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
}