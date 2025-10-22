package bishi.meituan0906;

import java.util.Scanner;

/**
 * 小美有一棵n个节点（编号为1～n）、由n－1条边构成的无向树，根节点为1。每个节
 * 点有一个值。对于任意节点，其权值定义如下：
 * ·如果u有子节点，则权值为该节点与所有子节点值的按位异或的最大值，即
 * ·如果u是叶子节点，则权值为αu。
 * 接下来小美会对这棵树进行m次操作，每次操作从以下三种类型中选择一种执行：
 * ·类型1 输入x y:将节点的值αx修改为y，(1≤x≤n，1≤y≤10e9);
 * ·类型2 输入x y：查询当前所有编号在区间[x,y]内的节点的最大权值，(1≤x≤y≤n);
 * ·类型3 输入x：查询以节点x为根的子树中所有节点的最大权值，（1≤x1≤n)。
 */

/**
 * 输入：
 * 第一行输入两个整数 n, m,分别表示节点数和操作次数。
 * 第二行输入 n个整数 α1,a2,.··,an，表示初始时每个节点的值。
 * 接下来n -1 行, 第 i行输入两个整数ui 和 vi, 表示树上第 i条树边。
 * 随后m行，每行对应一次操作，格式如题目描述所示。
 * 输出：
 * 对于每个查询操作（类型2或3），输出一行，表示查询结果（最大权值），
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[][] edges = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                edges[i][0] = in.nextInt();
                edges[i][1] = in.nextInt();
            }
            int[] res = new int[m];
            for (int i = 0; i < m; i++) {
                int type = in.nextInt();
                switch (type) {
                    case 1:
                        int x = in.nextInt();
                        int y = in.nextInt();
                        break;
                    case 2:
                        int x1 = in.nextInt();
                        int y1 = in.nextInt();
                        break;
                    case 3:
                        int x2 = in.nextInt();
                        break;
                }



            }
        }

    }

}


