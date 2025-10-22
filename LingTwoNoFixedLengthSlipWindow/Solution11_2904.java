package LingTwoNoFixedLengthSlipWindow;

class Solution11_2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        if(s.replace("0","").length()<k){
            return "";
        }
        char[] sarray = s.toCharArray();
        int n = sarray.length;
        String res = s;
        int left = 0;
        int count = 0;
        for (int right = 0; right < n; right++){
            count +=sarray[right] - '0';
            while (count > k || sarray[left] == '0'){
                count -=sarray[left++] - '0';

            }
            if (count == k){
                String temp = s.substring(left,right+1);
                if(temp.length()<res.length() || (temp.length() == res.length() &&temp.compareTo(res)<0)){
                    res = temp;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution11_2904 s = new Solution11_2904();
        System.out.println(s.shortestBeautifulSubstring("000", 1));
    }
}