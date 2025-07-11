package fixedLengthSlipWindow;

//几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
//
//每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
//
//你的点数就是你拿到手中的所有卡牌的点数之和。
//
//给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
class Solution8_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int total=0;

        int windowSize = n - k;
        for (int cardPoint : cardPoints) {
            total += cardPoint;
        }
        if(windowSize==0){
            return total;
        }
        for (int i=0;i<n;i++){
            sum += cardPoints[i];

            if(i<windowSize-1){
                continue;
            }
            res=Math.min(res,sum);
            sum -= cardPoints[i-windowSize+1];
        }
        return total-res;
    }

    public static void main(String[] args) {
        int[] cardPoints = {9,7,7,9,7,7,9};
        int k = 7;
        Solution8_1423 solution8_1423 = new Solution8_1423();
        System.out.println(solution8_1423.maxScore(cardPoints,k));
    }
}