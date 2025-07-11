package fixedLengthSlipWindow;

class Solution9_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0 ;
        for (int i = 0; i < customers.length; i++){
            if (grumpy[i] == 0){
                sum += customers[i];
            }
        }
        int res = sum;
        for (int i = 0; i < customers.length; i++){
            if (grumpy[i]==1){
                sum += customers[i];
            }

            if (i<minutes-1){
                continue;
            }
            res = Math.max(res,sum);
            if (grumpy[i-minutes+1]==1){
                sum -= customers[i-minutes+1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        Solution9_1052 s = new Solution9_1052();
        System.out.println(s.maxSatisfied(customers, grumpy, minutes));
    }
}