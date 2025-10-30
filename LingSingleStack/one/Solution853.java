package LingSingleStack.one;

import java.util.*;

/**
 * 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
 *
 * 给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i 辆车的速度(单位是英里/小时)。
 *
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并以较慢车的速度在另一辆车旁边行驶。
 *
 * 车队 是指并排行驶的一辆或几辆汽车。车队的速度是车队中 最慢 的车的速度。
 *
 * 即便一辆车在 target 才赶上了一个车队，它们仍然会被视作是同一个车队。
 *
 * 返回到达目的地的车队数量 。
 */
class Solution853 {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double>speedMap= new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            speedMap.put(position[i],(double)(target-position[i])/speed[i]);
        }
        Arrays.sort(position);
        Deque<Integer> stack= new ArrayDeque<>();
        stack.push(position[position.length-1]);
        //当前车到达终点的时间 跟 前面车队到达终点的时间 进行比较
        //在前面车队到终点时还未能到终点 说明赶不上 入栈构成新车队
        for (int i = position.length-2; i >=0 ; i--){
            if (speedMap.get(position[i])>speedMap.get(stack.peek())){
                stack.push(position[i]);
            }
        }
        return stack.size();
    }
    public static void main(String[] args) {
        Solution853 solution853 = new Solution853();
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int i = solution853.carFleet(12, position, speed);
        System.out.println(i);
    }
}