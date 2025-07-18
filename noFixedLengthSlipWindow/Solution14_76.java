package noFixedLengthSlipWindow;

class Solution14_76 {
    public String minWindow(String s, String t) {

        int[]cntT = new int[128];
        int[]cntS = new int[128];
        for (char c:t.toCharArray()){
            cntT[c]++;
        }

        int n = s.length();
        int m = t.length();
        int ansLeft =-1;
        int ansRight =n;
        char[] S = s.toCharArray();

        for (int left =0 ,right=0;right<n;right++){
            cntS[S[right]] ++;
            while(check(cntS,cntT)){
                if (right-left<ansRight-ansLeft){
                    ansLeft = left;
                    ansRight = right;
                }
                cntS[S[left]]--;
                left++;
            }
        }
        return ansLeft<0?"":s.substring(ansLeft, ansRight+1);
    }

    private boolean check(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution14_76 s = new Solution14_76();
        String ans = s.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd");
        System.out.println(ans);
    }
}