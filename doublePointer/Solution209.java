package doublePointer;

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    count = j - i + 1;
                    min = Math.min(min, count);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        int sum=0;
        int i=0;

        for (int j = 0; j < nums.length; j++) {
            sum+=nums[j];
            while(sum>=target){
                count=j-i+1;
                min = Math.min(min, count);
                sum-=nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }


    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int i = solution209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
}