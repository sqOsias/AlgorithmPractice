package lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class solution1 {
    //todo 二分
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n);
        ArrayList<Integer> b=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
            b.add(scanner.nextInt());
        }
        for (int i=1;i<1e6;i++){
            boolean flag=true;
            for (int j=0;j<n;j++){
                if (b.get(j)!=a.get(j)/i){
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.print(i+" ");
                break;
            }
        }
        for (int i = (int) 1e6; i>0; i--){
            boolean flag=true;
            for (int j=0;j<n;j++){
                if (b.get(j)!=a.get(j)/i){
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println(i);
                break;
            }

        }
    }
}
