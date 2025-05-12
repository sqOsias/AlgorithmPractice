package leetCode热题100;

import java.util.*;
import java.util.stream.Collectors;

public class solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        String[] sortedStr = new String[strs.length];
        boolean [] used = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) sortedStr[i] = strs[i];
        for (int i = 0; i < sortedStr.length; i++){
            System.out.println("排序前"+sortedStr[i]);
            char[] charArray = sortedStr[i].toCharArray();
            Arrays.sort(charArray);
            sortedStr[i] = new String(charArray);
            System.out.println("排序后"+sortedStr[i]);
        }

        for (int i = 0; i < sortedStr.length; i++) {
            List<String>path= new ArrayList<>();
            if (!used[i]){
                path.add(strs[i]);
                used[i]=true;
            }

            for (int j= i+1; j < sortedStr.length; j++){
                if(sortedStr[i].equals(sortedStr[j])&&!used[j]){
                    used[j]=true;
                    path.add(strs[j]);
                }
            }
            if(!path.isEmpty()){
                res.add(path);
            }

        }
        return res;

    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());

    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] array = s.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());

    }


    public static void main(String[] args) {
        solution2 solution2 = new solution2();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution2.groupAnagrams(strs);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
