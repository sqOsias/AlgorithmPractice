package LingTwoNoFixedLengthSlipWindow;

import java.util.Arrays;
import java.util.List;
//你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
//
//我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
//todo 困难

class Solution15_632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int resLeft = 0, resRight = Integer.MAX_VALUE; // 结果区间
        int ansLeft = Integer.MAX_VALUE, ansRight = 0;// 二维数据的区间

        for (List<Integer> num : nums) {
            ansLeft = Math.min(ansLeft, num.getFirst());
            ansRight = Math.max(ansRight, num.getLast());
        }
        int[] res = new int[ansRight-ansLeft];
        for (int left = 0, right =0;right<ansRight;right++){
            res[right] = ansLeft++;
            while(left<res.length && check(res,nums)){
                if (res[right]-res[left]<resRight-resLeft){
                    resLeft = res[left];
                    resRight = res[right];
                }
                left++;

            }

        }
        return new int[]{resLeft,resRight};
    }

    public static void main(String[] args) {
        Solution15_632 solution15_632 = new Solution15_632();
        int[] ints = solution15_632.smallestRange(List.of(List.of(4,10,15,24,26), List.of(0,9,12,20), List.of(5,18,22,30)));
        System.out.println(Arrays.toString(ints));
    }

    public boolean check(int[] res,List<List< Integer>> nums){
        int count = 0;
        for (int i = 0;i<res.length;i++){
            for (int re : res) {
                if (nums.get(i).contains(re)) {
                    count++;
                    break;
                }
            }
        }
        return count==res.length;
    }

}