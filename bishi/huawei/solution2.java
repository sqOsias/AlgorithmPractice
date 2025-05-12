package bishi.huawei;

import java.util.Scanner;

public class solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][]grid= new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j]=in.nextInt();
            }
        }
        fun(grid,n);
    }
    public static void fun(int[][]grid,int n){

    }
}
