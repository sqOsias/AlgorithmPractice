package bishi.bishiShopee;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
   public TreeNode(int val) {
     this.val = val;
   }
 }


public class Solution3 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param root TreeNode类
     * @return int整型二维数组
     */
    public int[][] levelOrder(TreeNode root) {
        // write code here
        if (root == null) {
            return new int[0][0];
        }
        if (root.left == null && root.right == null) {
            return new int[][]{{root.val}};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res=new LinkedList<>();

        List<Integer>path=new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            path=new LinkedList<>();
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();
                path.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            res.add(path);
        }
        // 将 List<List<Integer>> 转换为 int[][]
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> level = res.get(i);
            result[i] = new int[level.size()];
            for (int j = 0; j < level.size(); j++) {
                result[i][j] = level.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Solution3 solution3 = new Solution3();
        TreeNode root1 =new TreeNode(1);
        int[][] ints = solution3.levelOrder(root1);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }
    }
}