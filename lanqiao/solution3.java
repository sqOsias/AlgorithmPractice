package lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * N架飞机准备降落到某个只有一条跑道的机场。其中第架飞机在T时刻到
 * 达机场上空，到达时它的剩余油料还可以继续盘旋D：个单位时间，即它最早
 * 方
 * 可以于T时刻开始降落，最晚可以于T+D时刻开始降落。降落过程需要
 * L个单位时间。
 * -架飞机降落完毕时，另一架飞机可以立即在同一时刻开始降落，但是不能在
 * 前一架飞机完成降落前开始降落。
 * 请你判断N架飞机是否可以全部安全降落。
 */
public class solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t;
        t=scanner.nextInt();
        int[] T ;
        int[] D ;
        int[] L ;
        boolean[] isFall ;
        while (t-->0){
            int n;
            n=scanner.nextInt();
            T=new int[n];
            D=new int[n];
            L=new int[n];
            for (int i = 0; i < n; i++) {
                T[i]=scanner.nextInt();
                D[i]=scanner.nextInt();
                L[i]=scanner.nextInt();
            }
            isFall=new boolean[n];
            for (int i = 0; i < n; i++) {
                isFall[i]=false;
            }
            if(dfs(0, 0, n, T, D, L, isFall)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }


    }
    public static boolean dfs(int index,int time,int n, int[] T,int[] D,int[] L,boolean[] isFall){
        if(index==n){
            return true;
        }
        for (int i = 0; i < n; i++) {
            if(isFall[i]==false){
                isFall[i]=true;
                if(T[i]+D[i]<time){
                    isFall[i]=false;
                    return false;
                }
                int t=Math.max(time,T[i])+L[i];
                if(dfs(index + 1, t, n, T, D, L, isFall)) {
                    return true;
                }
               isFall[i]=false;
            }
        }
        return false;

    }

}
