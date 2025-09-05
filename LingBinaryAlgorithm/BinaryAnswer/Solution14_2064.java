package LingBinaryAlgorithm.BinaryAnswer;

/**
 * 给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，其中 quantities[i] 表示第 i 种商品的数目。
 * 你需要将 所有商品 分配到零售商店，并遵守这些规则：
 * 一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。
 * 分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，你希望 x 越小越好。也就是说，你想 最小化 分配给任意商店商品数目的 最大值 。
 * 请你返回最小的可能的 x 。
 */
class Solution14_2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left =0 ,right =Integer.MIN_VALUE;
        for (int x:quantities){
            right = Math.max(right,x);
        }
        while(left+1<right){
            int mid = (left+right)>>>1;
            if (check(mid,quantities,n)){
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public boolean check(int mid, int[] quantities, int n) {
        int count = 0;
        for (int x : quantities){
            int num = (x + mid - 1) / mid;
            count += num;
        }
        return count <= n;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] quantities = {15,10,10};
        System.out.println(new Solution14_2064().minimizedMaximum(n,quantities));
    }
}