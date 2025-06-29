package leetCode热题100;

import java.util.HashMap;
import java.util.Map;

class Solution169 {
    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param nums 数组
     * @return 多数元素
     */
    public int majorityElement(int[] nums) {
        int target = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() > target){
                return entry.getKey();
            }
        }
        return -1;
    }
}