package LingBinaryAlgorithm.BinarySearch;

/**
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 */
class Solution4_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int i = lowerBound(letters, target);
        return i == letters.length ? letters[0] : letters[i];
    }

    public int lowerBound(char[] letters, char target){
        int left =-1,right = letters.length;
        while(left+1<right){
            int mid = left + (right-left)/2;
            //这里就是找到第一个大于target的元素下标
            if(letters[mid]>target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right;
    }
}