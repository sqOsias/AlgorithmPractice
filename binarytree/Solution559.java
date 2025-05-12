package binarytree;

import java.util.List;

class Solution559 {


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

    public int maxDepth(Node root) {
        int maxdepth = 0;
        if (root == null) {
            return 0;
        }
        for(Node node:root.children){
            maxdepth=Math.max(maxdepth,maxDepth(node));
        }
        return maxdepth+1;
    }
}