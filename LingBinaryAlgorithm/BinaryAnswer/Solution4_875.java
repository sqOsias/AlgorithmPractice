package LingBinaryAlgorithm.BinaryAnswer;


/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 */
class Solution4_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int right = max+1;
        while (left+1 < right) {
            int mid = (left+right)>>>1;
            if (check(piles, mid, h)){
                right = mid;
            }
            else {
                left = mid;
            }
        }
        return right;

    }

    private boolean check(int[] piles, int mid, int h) {
        for (int pile : piles) {
            int hour = (pile + mid - 1) / mid;
            h -= hour;
            if (h < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        Solution4_875 solution = new Solution4_875();
        int res = solution.minEatingSpeed(piles, h);
        System.out.println(res);
    }

}