package singleStack;

import java.util.Deque;
import java.util.LinkedList;

class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int lens = temperatures.length;
        int[]res = new int[lens];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < lens; i++) {

            if (temperatures[i]<=temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    Integer pop = stack.pop();
                    res[pop] = i-pop;

                }
                stack.push(i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] ints = solution739.dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }
}