package LingThreeDoublePointersTwo;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
class Solution1_611 {
    // 双指针
    //定住最长边 思考两条短边
    //两条短边一左一右 同样定住较长边 移动短边
    public int triangleNumber(int[] nums) {
        int res=0;
        Arrays.sort(nums);
        for(int k=2;k<nums.length;k++){
            int i=0,j=k-1;
            while(i<j){
                if(nums[i]+nums[j]>nums[k]){
                    res+=j-i;
                    j--;
                }else{
                    i++;
                }
            }
        }
        return res;
    }


}