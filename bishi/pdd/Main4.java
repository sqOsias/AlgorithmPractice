package bishi.pdd;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        //购物车有n件商品，第i件商品价格是p[i]，有m张优惠券，每张优惠券只能用一次
        //第j张优惠券需要商品价格至少为a[j]，使用后可减免b[j]元，
        // 每张优惠券最多分配给一个商品，每个商品最多使用一张优惠券
        // 现在想购买购物车中所有商品，设计一种优惠券分配规划，输出最大总减免
        //
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        int sum = 0;
        //将p按值从大到小排序
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (p[i] < p[j]) {
                    int temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        int curFree = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] >= a[curFree]) {
                sum += b[curFree];
                curFree = curFree + 1;

            }
            if (curFree == m) {
                break;
            }
        }
        System.out.println(sum);

    }
}
