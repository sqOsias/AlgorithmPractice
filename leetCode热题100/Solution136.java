package leetCode热题100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;

class Solution136 {
    public int singleNumber(int[] nums) {
        if (nums.length==0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);


        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])==1){
                return nums[i];
            }
        }
        return -1;

    }
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for(int num : nums) {
            ans = num ^ ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution136 solution136 = new Solution136();
        int[] nums = {4,1,2,1,2};
        System.out.println(solution136.singleNumber(nums));
    }
}