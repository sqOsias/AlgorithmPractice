package bishi.pdd;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n,m;//表示s1和s2的长度
        //接收数列
        int s1,s2;

        while (t-- > 0) {
            n=scanner.nextInt();
            m=scanner.nextInt();
            s1=scanner.nextInt();
            s2=scanner.nextInt();
            int res = changes1(n, m, s1, s2);
            System.out.println(res);
        }
    }
    //对s1进行任意次操作，每次操作置换s1任意两个数字位置，要求s1尽可能大，但是要小于s2
    public static int changes1(int n, int m, int s1, int s2){
        if (n>m){
            return -1;
        }
        char[] charArray = String.valueOf(s1).toCharArray();
        //创建一个数组，用来存储s1的数字
        int[] s1Array=new int[n];
        for (int i = 0; i < charArray.length; i++) {
            s1Array[i]=charArray[i]-'0';
        }
        //降序排序
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++){
                if (s1Array[i]<s1Array[j]){
                    int temp=s1Array[i];
                    s1Array[i]=s1Array[j];
                    s1Array[j]=temp;
                }
            }
        }
        int currentS1 = Integer.parseInt(s1Array.toString());
        if (n<m){
            return currentS1;
        }
        int max=0;
        while(currentS1>=s2){
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    int temp=s1Array[i];
                    s1Array[i]=s1Array[j];
                    s1Array[j]=temp;
                    currentS1=Integer.parseInt(s1Array.toString());
                    if (currentS1<s2){
                        max=Math.max(max,currentS1);
                    }
                }
            }

        }
        return Integer.parseInt(s1Array.toString());
    }
}
