package LingSingleStack.one;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 */
class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int lens = nums.length;
        int[]res = new int[lens];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i=2*lens-1;i>=0;i--){
            int num = nums[i % lens];
            while(!stack.isEmpty()&&stack.peek()<=num){
                stack.pop();
            }
            if (!stack.isEmpty()){
                res[i%lens] = stack.peek();
            }
            stack.push(num);


        }

        return res;

    }
    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] nums = {1,2,1};
        int[] ints = solution503.nextGreaterElements(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}