package jd;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

            String str=scanner.next();
            int n = str.length();
            String res = "pacman";
            int count=0; //记录res当前字符

            for (int i = 0; i < n-7; i++){
                if(str.substring(i,i+6).equals(res)){
                    count++;
                    i+=5;
                }
            }


            System.out.println(count);
    }

}
