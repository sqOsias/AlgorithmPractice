package noFixedLengthSlipWindow;

import java.util.HashMap;

class Solution25_68 {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int left = 0 ,right=0;right<flowers.length;right++){
            map.merge(flowers[right],1,Integer::sum);
            while (map.get(flowers[right])>cnt){
                map.merge(flowers[left],-1,Integer::sum);
                if (map.get(flowers[left])==0){
                    map.remove(flowers[left]);
                }
                left++;
            }
            res += right - left + 1;
        }
        return res%1000000007;
    }
}