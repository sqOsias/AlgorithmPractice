package singleStack;

import java.util.*;

class Solution503 {
    public int[] nextGreaterElements(int[] nums) {

        int lens = nums.length;
        int[]res = new int[lens];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < lens*2; i++) {

            if (nums[i%lens]<=nums[stack.peek()]){
                stack.push(i%lens);
            }else {
                while(!stack.isEmpty()&&nums[i%lens]>nums[stack.peek()]){
                    Integer pop = stack.pop();
                    res[pop] = nums[i%lens];

                }
                stack.push(i%lens);
            }
        }
        return res;


        }

}