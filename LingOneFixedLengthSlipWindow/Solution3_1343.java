package LingOneFixedLengthSlipWindow;

class Solution3_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int amount=0;
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(i<k-1){
                continue;
            }
            if (sum/k>=threshold){
                amount++;
            }
            sum-=arr[i-k+1];
        }
        return amount;
    }
}