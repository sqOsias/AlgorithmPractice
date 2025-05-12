package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r=scanner.nextInt();
        int d=scanner.nextInt();
        int x=scanner.nextInt();
        List list = new ArrayList(10);
        for (int i=0;i<10;i++){
            x=x*r-d;
            list.add(x);
        }
        for (int i=0;i<10;i++){
            System.out.println(list.get(i));
        }

    }
}
