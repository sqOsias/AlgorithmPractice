package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length<4){
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int left = j+1;
                int right= nums.length-1;

                while (left<right){
                    long temp=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(temp<target){
                        left++;
                    }else if (temp>target){
                        right--;
                    }else {
//                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        List<Integer> path=new ArrayList<>();
                        path.add(nums[i]);
                        path.add(nums[j]);
                        path.add(nums[left]);
                        path.add(nums[right]);
                        if(!res.contains(path)){
                            res.add(path);
                        }
                        left++;
                        right--;

                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Solution18 solution18 = new Solution18();
        List<List<Integer>> lists = solution18.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }


    }
}