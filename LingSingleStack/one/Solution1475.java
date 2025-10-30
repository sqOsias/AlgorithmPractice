package LingSingleStack.one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
 * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 */
class Solution1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int price = prices[i];
            while (!st.isEmpty() && price < st.peek()) {
                st.pop();
            }
            ans[i] =st.isEmpty()? price : price - st.peek();
            st.push(price);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution1475 solution1475 = new Solution1475();
        int[] ints = solution1475.finalPrices(new int[]{8, 4, 6, 2, 3});
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}