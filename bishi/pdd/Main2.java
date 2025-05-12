package bishi.pdd;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t= scanner.nextInt();
        int n;//n各个顾客
        int m;//m个糖果
        int k;// 单张兑换券可换k个糖果
        while (t-->0){
            n=scanner.nextInt();
            m=scanner.nextInt();
            k=scanner.nextInt();
            System.out.println(getLeast(n,m,k));
        }
    }

    //兑换完所有糖果至少需要的兑换券数
    public static int getLeast(int n,int m,int k){
        int res=0;
        while (m>0&&n>0){
            if(m%k>=Math.ceil(k/2)){
                res+=Math.ceil(m/k);
                m = (int) (m-k*Math.ceil(m/k));
                n--;
            }
            else{
                res+=Math.floor(m/k);
                m= (int) (m-k*Math.floor(m/k));
                n--;
            }
        }
        return res;
    }
}
