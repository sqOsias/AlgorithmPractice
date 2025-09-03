package LingBinaryAlgorithm.BinaryAnswer;

/**
 * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
 * 返回每个小孩可以拿走的 最大糖果数目 。
 */
class Solution6_2226 {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        int right =max +1;
        int left = 0;

        while (left + 1 < right) {
            int mid = (left+right)>>>1;
            if (check(candies, mid, k)){
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return left;

    }

    private boolean check(int[] candies, int mid, long k) {
        for (int i = 0; i < candies.length; i++){
            k -= candies[i] / mid;
        }
        return k <= 0;
    }

    public static void main(String[] args) {
        int[] candies = {1,2,3,4,10};
        long k = 5;
        System.out.println(new Solution6_2226().maximumCandies(candies, k));
    }
}