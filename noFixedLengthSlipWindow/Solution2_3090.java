package noFixedLengthSlipWindow;

class Solution2_3090 {
    public int maximumLengthSubstring(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int res=0;
        int left=0;
        int[]cnt=new int[128];
        for (int right= 0;right<n;right++){
            cnt[charArray[right]]++;
            while (cnt[charArray[right]] > 2) {
                cnt[charArray[left]]--;
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}