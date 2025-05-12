package greedy;

class Solution6 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//
//        for (int i = 0; i < n; i++) {
//            int sum = gas[i] - cost[i];
//            int index = (i + 1) % n;
//            while (sum > 0 && index != i) {
//                sum += gas[index] - cost[index];
//                index = (index + 1) % n;
//            }
//            if (sum >= 0 && index == i) {
//                return i;
//            }
//
//        }
//        return -1;


        int curSum=0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            int rest=gas[i]-cost[i];
            curSum+=rest;
            if(curSum<min){
                min=curSum;
            }
        }

        if(curSum<0) return -1;
        if(min>=0) return 0;
        for(int i=gas.length-1;i>=0;i--){
            int rest=gas[i]-cost[i];
            min+=rest;
            if(min>=0){
                return i;
            }
        }
        return -1;

    }
}