package LingThreeDoublePointersOne;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 */
class Solution1_344 {
    public void reverseString(char[] s) {
        for (int left =0,right = s.length-1;left<right;left++,right--){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
        }
    }


}