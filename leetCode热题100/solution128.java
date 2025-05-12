package leetCode热题100;

import java.util.Arrays;

public class solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                res[i] = res[i - 1] + 1;
            } else if (nums[i] == nums[i - 1]) {
                res[i] = res[i - 1];
            } else {
                res[i] = 1;
            }
        }
        int max = res[0];
        for (int i = 1; i < res.length; i++) {
            max = Math.max(max, res[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        solution128 solution128 = new solution128();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int res = solution128.longestConsecutive(nums);
        System.out.println(res);
    }
}
