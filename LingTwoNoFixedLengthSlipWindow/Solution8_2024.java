package LingTwoNoFixedLengthSlipWindow;

class Solution8_2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] charArray = answerKey.toCharArray();
        int[]cnt = new int[2];
        int res=0;
        for (int left = 0, right = 0; right < charArray.length; right++) {
            cnt[charArray[right] >>1  & 1]++;
            while (Math.min(cnt[0], cnt[1]) > k) {
                cnt[charArray[left]>>1&1]--;
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution8_2024 solution5_2024 = new Solution8_2024();
        System.out.println(solution5_2024.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}