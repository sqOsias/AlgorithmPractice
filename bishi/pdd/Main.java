package bishi.pdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //t 组数
        //n 石砖数量
        //s 长度为n字符串 1表示有青蛙，0表示没有青蛙
        //当最长的相邻青蛙数为9时认为这条路时幸运的
        Scanner scanner = new Scanner(System.in);
        int n;
        String str;
        int t=scanner.nextInt();
        while(t-->0){
            n=scanner.nextInt();
            str=scanner.next();
            if (isLuck(str)){
                System.out.println("lucky");
            }else {
                System.out.println("unlucky");
            }
        }
    }
    public static boolean isLuck(String str){
        char[] charArray = str.toCharArray();
        int[]dp=new int[charArray.length];
        dp[0]=charArray[0]=='1'?1:0;
        for(int i=1;i<charArray.length;i++){
            if (charArray[i]=='1'){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=0;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]>=9){
                return true;
            }
        }
        return false;
    }

}
