package leetCode热题100;

import java.util.HashMap;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j=i;j>=0;j--){
                sum+=nums[j];
                if (sum==k){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;

    }
}