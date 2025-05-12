package doublePointer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Q2 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> pd = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(pd.size()<k){
                pd.add(new int[]{entry.getKey(),entry.getValue()});
            }else {
                if(entry.getValue()>pd.peek()[1]){
                    pd.poll();
                    pd.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }

        int [] res = new int[k];
        for (int i=k-1;i>=0;i--){
            res[i] = pd.poll()[0];
        }
        return res;

    }

}
