package doublePointer;

class Solution151 {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=s1.length-1;i>=0;i--){
            if(s1[i].length()>0){
                sb.append(s1[i]+" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String s = "the sky is blue!";
        String s1 = solution151.reverseWords(s);
        System.out.println(s1);
    }
}