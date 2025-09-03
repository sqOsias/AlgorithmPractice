package LingBinaryAlgorithm.BinaryAnswer;

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
class Solution3_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int weight : weights) {
            min = Math.min(min, weight);
            sum += weight;
        }
        int left = min-1;
        int right = sum;
        while (left +1 < right){
            int mid = left + (right - left)/2;
            if (check(weights, mid, days)){
                right = mid;
            }else{
                left = mid ;
            }
        }
        return right;
    }


    public boolean check(int[]weights , int index, int days){
        int sum =0;
        for (int weight : weights) {
            if(weight > index) return false;
            sum += weight;
            if (sum > index) {
                days--;
                sum = weight;
            }
            if (days < 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 1;
        System.out.println(new Solution3_1011().shipWithinDays(weights, days));
    }
}