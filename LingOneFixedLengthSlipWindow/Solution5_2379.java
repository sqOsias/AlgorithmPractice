package LingOneFixedLengthSlipWindow;

// 2379. 得到 K 个黑块的最少涂色次数
class Solution5_2379 {

    public int minimumRecolors(String blocks, int k) {
        int res=k;
        int num =0;
        char[] charArray = blocks.toCharArray();
        for(int i =0;i<charArray.length;i++){
            if(charArray[i]=='W'){
                num++;
            }
            if(i<k-1){
                continue;
            }
            res=Math.min(res,num);
            if(charArray[i-k+1]=='W'){
                num--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution5_2379 s = new Solution5_2379();
        System.out.println(s.minimumRecolors("WBBWWBBWBW", 7));
    }
}