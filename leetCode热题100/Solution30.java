//package leetCode热题100;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class Solution30 {
//    public List<Integer> findSubstring(String s, String[] words) {
//        List list = new ArrayList();
//        int sLen = s.length();
//
//        int wordLen = words[0].length();
//        List<List<Integer>> listList = new ArrayList();
//        for (int i = 0; i < words.length; i++) {
//            char[] charArray = words[i].toCharArray();
//            List<Integer> list1 = new ArrayList();
//            for (int j = 0; j < wordLen; j++){
//
//                list1.add(charArray[j]-'a');
//            }
//            listList.add(list1);
//        }
//    }
//}