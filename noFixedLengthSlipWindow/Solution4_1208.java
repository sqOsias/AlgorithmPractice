package noFixedLengthSlipWindow;

import backtracking.Solution;

class Solution4_1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int n = sCharArray.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = Math.abs(sCharArray[i] - tCharArray[i]);
        }
        int count = 0;
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++) {
            count += cnt[right];

            while (count > maxCost) {
                count -= cnt[left];
                left++;
            }
            res = Math.max(res, right - left + 1);

        }
        return res;
    }

    public static void main(String[] args) {
        Solution4_1208 s = new Solution4_1208();
        int res = s.equalSubstring("abcd", "cdef", 3);
        System.out.println(res);
    }
}