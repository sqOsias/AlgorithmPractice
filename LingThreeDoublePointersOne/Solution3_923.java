package LingThreeDoublePointersOne;

import java.util.Arrays;

class Solution3_923 {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1_000_000_007; // 取模
        long res = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n-2; i++){
            int j = i + 1, k = n - 1;
            int x= arr[i];
//            if (i>0&&arr[i-1]== x) continue;
            if(x+arr[i+1]+arr[i+2]> target) break;
            if(x+arr[n-2]+arr[n-1]< target) continue;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum>target){
                    k--;
                }else if (sum<target){
                    j++;
                }else{
                    // 满足条件后，需要求排列组合
                    // 分两种情况
                    // 1.nums[l] = nums[r]
                    // 2.l,r 旁边有多少重复数字
                    if (arr[j] == arr[k]) {
                        // 如果j和k之间所有元素都相等
                        int count = k - j + 1;
                        // 从count个数中选2个数组成一对的组合数
                        res += (long) count * (count - 1) / 2;
                        res %= MOD;
                        break;
                    } else {
                        // 如果j和k指向的值不相等，分别计算两边重复元素的个数
                        int leftCount = 1, rightCount = 1;
                        while (j + leftCount <= k && arr[j] == arr[j + leftCount]) {
                            leftCount++;
                        }
                        while (k - rightCount >= j && arr[k] == arr[k - rightCount]) {
                            rightCount++;
                        }
                        // 左边有leftCount种选择，右边有rightCount种选择，总共leftCount*rightCount种组合
                        res += (long) leftCount * rightCount;
                        res %= MOD;
                        j += leftCount;
                        k -= rightCount;
                    }

                }
            }
        }
        return (int) (res % MOD);
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        int i = new Solution3_923().threeSumMulti(arr, target);
        System.out.println(i);
    }
}