package LingOneFixedLengthSlipWindow;

class Solution2_1456 {
    //定长字串中最大数目的元音
    public int maxVowels(String s, int k) {
        char[] charArray = s.toCharArray();
        int ans = 0;
        int vowel = 0;
        for (int i=0;i<s.length();i++){
            //1.进入窗口
            if(charArray[ i]=='a'||charArray[ i]=='e'||charArray[ i]=='i'||charArray[ i]=='o'||charArray[ i]=='u'){
                vowel++;
            }
            if (i<k-1){
                continue;
            }
            //2.更新答案
            ans = Math.max(ans,vowel);
            //3.离开窗口
            char out = charArray[i-k+1];
            if(out=='a'||out=='e'||out=='i'||out=='o'||out=='u'){
                vowel--;
            }
        }
        return ans;
    }
}