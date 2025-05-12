package leetCode热题100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.function.Predicate.isEqual;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int slength = s.length();
        int plength = p.length();
        if (slength < plength) {
            return new ArrayList<>();
        }
        List<Integer>ans=new ArrayList<>();
        int[]sCount=new int[26];
        int[]pCount=new int[26];

        for (int i = 0; i < plength; i++) {
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }

        if(Arrays.equals(sCount,pCount)){
            ans.add(0);
        }
        for (int i = 0; i < slength - plength; i++) {
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+plength)-'a']++;
            if(Arrays.equals(sCount,pCount)){
                ans.add(i+1);
            }

        }
        return ans;

    }
}