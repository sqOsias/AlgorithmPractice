package leetCode热题100;

class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            // 计算当前面积
            int area = Math.min(height[left], height[right]) * (right - left);
            // 更新最大面积
            max = Math.max(max, area);
            // 移动指针
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
