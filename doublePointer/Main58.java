package doublePointer;

import java.util.Scanner;

public class Main58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int[] vec = new int[n];
        int []pre=new int[n];

        int presum=0;
        for (int i = 0; i < n; i++) {
            vec[i]=scanner.nextInt();
            presum+=vec[i];
            pre[i]=presum;
        }
        while(scanner.hasNext()){
            int a=scanner.nextInt();
            int b=scanner.nextInt();

            int sum=0;
            if(a==0){
                sum=pre[b];
            }else {
                sum=pre[b]-pre[a-1];
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}
