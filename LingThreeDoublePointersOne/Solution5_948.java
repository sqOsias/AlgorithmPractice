package LingThreeDoublePointersOne;

import java.util.Arrays;

/**
 * 你的初始 能量 为 power，初始 分数 为 0，只有一包令牌以整数数组 tokens 给出。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
 *
 * 你的目标是通过有策略地使用这些令牌以 最大化 总 分数。在一次行动中，你可以用两种方式中的一种来使用一个 未被使用的 令牌（但不是对同一个令牌使用两种方式）：
 *
 * 朝上：如果你当前 至少 有 tokens[i] 点 能量 ，可以使用令牌 i ，失去 tokens[i] 点 能量 ，并得到 1 分 。
 * 朝下：如果你当前至少有 1 分 ，可以使用令牌 i ，获得 tokens[i] 点 能量 ，并失去 1 分 。
 * 在使用 任意 数量的令牌后，返回我们可以得到的最大 分数 。
 */
class Solution5_948 {
    // 贪心算法+双指针
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int score = 0;
        while(left<=right){
            if(power>=tokens[left]){
                power-=tokens[left];
                score++;
                left++;
            }else if(left!=right && score>0){
                power+=tokens[right];
                score--;
                right--;
            }else{
                break;
            }
        }
        return score;
    }
    public static void main(String[] args){
        Solution5_948 solution5948 = new Solution5_948();
        System.out.println(solution5948.bagOfTokensScore(new int[]{100,200,300,400},200));
    }
}