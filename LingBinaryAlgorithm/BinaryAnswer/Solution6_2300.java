package LingBinaryAlgorithm.BinaryAnswer;

import java.util.Arrays;

/**
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 */
class Solution6_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //暴力解法 超时
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        for (int i = 0; i < n; i++) {
            int count=0;
            int left = 0;
            int right = m - 1;
            for (int potion : potions) {
                long sum = (long) spells[i] * potion;
                if (sum >= success) {
                    count++;
                }
            }
            pairs[i]=count;
        }
        return pairs;
    }

    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++){
            long target= (success - 1) / spells[i]; //将多次乘法转化为一次除法
            if (target<potions[potions.length-1]){
                spells[i] = potions.length - upperBound(potions,(int) target);

            }else{
                spells[i] = 0;
            }
        }
        return spells;
    }

    private int upperBound(int[] nums, int target){
        int left = -1, right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;//right 就是第一个 > target 的元素下标
    }
}