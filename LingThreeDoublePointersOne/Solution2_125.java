package LingThreeDoublePointersOne;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
class Solution2_125 {

    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else if (Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2_125 solution2_125 = new Solution2_125();
        boolean palindrome = solution2_125.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}