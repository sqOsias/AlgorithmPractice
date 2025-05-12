package binarytree;

import java.util.*;
import java.util.stream.Collectors;

class Solution501 {
    public int[] findMode(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer>map = new HashMap<>();
        if (root==null) return list.stream().mapToInt(Integer::intValue).toArray();

        searchBST(root,map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());

        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    void searchBST(TreeNode root, Map<Integer, Integer>map){
        if (root == null) return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        searchBST(root.left,map);
        searchBST(root.right,map);
    }
}