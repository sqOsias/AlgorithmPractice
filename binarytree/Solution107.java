package binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>path=new ArrayList<>();

        Queue<TreeNode> que=new LinkedList<>() ;
        if (root==null) return res;
        que.offer(root);

        while (!que.isEmpty()){
            path=new ArrayList<>();
            int len =que.size();

            while(len>0){
                TreeNode poll = que.poll();
                path.add(poll.val);
                if (poll.left!=null) que.add(poll.left);
                if (poll.right!=null) que.add(poll.right);
                len--;
            }
            res.add(path);
        }
        for (int i = 0; i < res.size() / 2; i++) {
            List<Integer> integers = res.get(i);
            res.set(i, res.get(res.size() - i - 1));
            res.set(res.size() - i - 1, integers);
        }

        return res;
    }
}