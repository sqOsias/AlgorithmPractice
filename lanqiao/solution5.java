package lanqiao;

import java.util.Scanner;

/**
 * 对于一个长度为 K 的整数数列：A1,A2，···，AK，我们称之为接龙数列当且仅当 A;的首位数字恰好等于
 * Ai-1的末位数字(2≤≤K)。例如12,23,35,56,61,11是接龙数列；12,23,34,56不是接龙数列，
 * 因为56的首位数字不等于34的末位数字。所有长度为1的整数数列都是接龙数列。
 * 现在给定一个长度为N的数列A1，A2，···，AN，请你计算最少从中删除多少个数，可以使剩下的序列是接
 * 龙序列?
 */
public class solution5 {
    static int res=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        long []A=new long[n];
        for (int i = 0; i < n; i++) {
            A[i]=scanner.nextLong();
        }
        dfs(0,0,-1,A );
        System.out.println(n-res);

    }

    static long get_first(long x){
        while (x>=10){
            x/=10;
        }
        return x;
    }
    public static long get_last(long x){
        return x%10;
    }

    //index 考虑到第几位
    //last 表示方案中已选的最后一个
    //count 表示方案中已选的个数
    public  static int dfs(int index,int count,long last,long []A){
        if(index==A.length){
            return Math.max(count,res);
        }
        if(last==-1 ||get_first(A[index])==get_last(last)){
            return dfs(index+1,count+1,A[index],A);
        }
        return dfs(index+1,count,last,A);
    }



}
