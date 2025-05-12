package greedy;

class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        // 把n变成一个字符串
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int flag=s.length()-1;
        for(int i=s.length()-1;i>0;i--){
            if(charArray[i-1]>charArray[i]){
                flag=i;
                charArray[i-1]--;
            }
        }
        for(int i=flag;i<s.length();i++){
            charArray[i]='9';
        }
        return Integer.parseInt(new String(charArray));


    }

    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(332));
    }

}