package lanqiao;

import java.util.Scanner;

/**
 * todo 二分
 * 第一行包含一个整数K。
 * 第二行包含一个字符串S和两个字符c1和C2。
 * 输出格式
 * 一个整数代表答案
 */

public class solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k;
        String s;
        char c1,c2;
        k=scanner.nextLong();
        s=scanner.next();
        c1=scanner.next().charAt(0);
        c2=scanner.next().charAt(0);

        long res=0;

        for (long i = 0; i < s.length(); i++) {
            if (s.charAt((int) i)!=c1){
                continue;
            }
            long fastIndex=i+1;
            while(fastIndex<s.length()){
                if(s.charAt((int) i)==c1&&s.charAt((int) fastIndex)==c2&&fastIndex-i+1>=k){
                    res++;
                }
                fastIndex++;
            }
        }
        System.out.println(res);

    }
}
