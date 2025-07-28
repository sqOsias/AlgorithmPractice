package LingOneFixedLengthSlipWindow;

class Solution11_3499 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] free = new int[n+1];
        free[0]= startTime[0];
        for (int i =1;i<n;i++){
            free[i]=startTime[i]- endTime[i-1];
        }
        free[n]=eventTime-endTime[n-1];

        int res=0;
        int sum=0;
        for (int i=0;i<=n;i++){
            sum+=free[i];

            if(i<k+1){
                continue;
            }
            res= Math.max(res,sum);
            sum-=free[i-k];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] startTime = {0,2,9};
        int[] endTime = {1,4,10};
        int eventTime = 5;
        int k = 1;
        Solution11_3499 s = new Solution11_3499();
        System.out.println(s.maxFreeTime(eventTime, k, startTime, endTime));
    }
}