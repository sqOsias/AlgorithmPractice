package LingSingleStack.one;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    private final Deque<int[]> stack = new ArrayDeque<>();
    private int curDay = -1;

    public StockSpanner() {
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        while(price>=stack.peek()[1]){
            stack.pop();
        }
        curDay++;
        int ans = curDay - stack.peek()[0];
        stack.push(new int[]{curDay, price});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */