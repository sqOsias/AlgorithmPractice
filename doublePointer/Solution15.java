package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res.stream().toList();
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    path = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        path.add(nums[i]);
                        path.add(nums[j]);
                        path.add(nums[k]);
                        path.sort(Integer::compareTo);
                        res.add(path);
                    }
                }
            }
        }
        return res.stream().toList();
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path;
        if (nums == null || nums.length < 3) {
            return res.stream().toList();
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0){
                return res.stream().toList();
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0) {
                    path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);

                    res.add(path);
                    left++;
                    right--;
                } else if (temp > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res.stream().toList();


    }


    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum1(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}