package leetCode热题100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution76 {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        int tlength = t.length();
        for (int i=0;i<tlength;i++){
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l=0,r=-1;
        int len=Integer.MAX_VALUE,ansL=-1,ansR=-1;
        int slen = s.length();
        while(r<slen){
            r++;
            if (r<slen&&ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while(check()&&l<=r){
                if (r-l+1<len){
                    len = r-l+1;
                    ansL = l;
                    ansR = r;
                }
                if (ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL==-1?"":s.substring(ansL, ansR+1);


    }

    public boolean check(){
        Iterator iterator = ori.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Character key = (Character) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = solution76.minWindow(s, t);
        System.out.println(res);
    }
}