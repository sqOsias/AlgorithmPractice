package LingSingleStack.two;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1793 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        // 计算左边界：使用单调栈找出每个柱子左侧第一个比它矮的柱子位置
        for (int i = 0; i < n; i++) {
            int h = nums[i];
            while (!st.isEmpty() && nums[st.peek()] >= h) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        //计算右边界：同样使用单调栈找出每个柱子右侧第一个比它矮的柱子位置
        int[] right = new int[n];
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            int h = nums[i];
            while (!st.isEmpty() && nums[st.peek()] >= h) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = right[i];
            int l = left[i];
            int h = nums[i];
            if (l < k && k < r) {
                ans = Math.max(ans, h * (r - l - 1));
            }
        }
        return ans;
    }
}