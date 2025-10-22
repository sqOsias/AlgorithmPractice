package LingBinaryAlgorithm.BinaryAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 */
class Solution11_1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int left = ladders;
        int right = heights.length+1;


        while(left+1<right){
            int mid = left + (right-left)/2;
            if(check(heights,mid,bricks,ladders)){
                left=mid;
            }else{
                right=mid;
            }
        }
        return left-1;


    }

    public boolean check(int[] heights,int mid,int bricks,int ladders){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < mid-1; i++){
            if (heights[i+1] > heights[i]){
                list.add(heights[i+1]-heights[i]);
            }
        }
        Collections.sort(list);
        int sum = 0;
        for (int i = 0; i < list.size()-ladders; i++){
            sum+=list.get(i);
            if (sum>bricks){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution11_1642 solution = new Solution11_1642();
        int[] heights = {4,12,2,7,3,18,20,3,19};
        System.out.println(solution.furthestBuilding(heights,10,2));



    }
}