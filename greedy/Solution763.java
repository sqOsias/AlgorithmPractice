package greedy;

import java.util.ArrayList;
import java.util.List;


class Solution763 {
    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        int[] lastIndex=new int[26];
        for (int i = 0; i < charArray.length; i++) {
            lastIndex[charArray[i]-'a']=i;
        }

        int left=0;
        int right=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            right=Math.max(right,lastIndex[charArray[i]-'a']);
            if(i==right){
                list.add(right-left+1);
                left=right+1;
            }
        }
        return list;
    }
}