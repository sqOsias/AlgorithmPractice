package fixedLengthSlipWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution6_2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        if(nums.size()==1){
            return nums.getFirst();
        }
        long res = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =0 ;i<nums.size();i++){
            sum += nums.get(i);
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);

            if(i<k-1){
                continue;
            }
            if(map.size()>=m){
                res=Math.max(res, sum);
            }
            sum -= nums.get(i-k+1);
            map.put(nums.get(i-k+1), map.get(nums.get(i-k+1))-1);
            if(map.get(nums.get(i-k+1))==0){
                map.remove(nums.get(i-k+1));
            }


        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,2);
        int m = 2;
        int k = 2;
        System.out.println(new Solution6_2841().maxSum(nums, m, k));


    }
}