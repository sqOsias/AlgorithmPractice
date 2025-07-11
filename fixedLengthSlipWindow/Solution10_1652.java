package fixedLengthSlipWindow;

class Solution10_1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] newCode = new int[3*n];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        System.arraycopy(code, 0, newCode, 2*n, n);
        int [] res = new int[n];
        int index = Math.abs(k);
        for (int i = 0;i<n;i++){
            if (k>0){
                for (int j = 1 ;j<=index;j++){
                    res[i] += newCode[i+j];
                }
            }else if (k<0){
                for (int j = 1 ;j<=index;j++){
                    res[i] += newCode[i+n-j];
                }
            }else{
                res[i] = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        Solution10_1652 s = new Solution10_1652();
        int[] res = s.decrypt(code, k);
        for (int i = 0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}