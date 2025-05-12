package lanqiao;


import java.util.Scanner;

public class solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k= scanner.nextInt();
        long[] A=new long[n];
        boolean[]flag=new boolean[n];
        for (int i = 0; i < n; i++) {
            A[i]=scanner.nextLong();
        }

        for (int i = 0; i < k; i++) {
            long min=Long.MAX_VALUE;
            int minIndex=-1;
            for (int j = 0; j < n; j++) {
                if (!flag[j]&& A[j]<min){
                    min=A[j];
                    minIndex=j;
                }
            }
            flag[minIndex]=true;
            for (int a=minIndex-1;a>=0;a--){
                if(!flag[a]){
                    A[a]+=min;
                    break;
                }
            }
            for (int b=minIndex+1;b<n;b++){
                if(!flag[b]){
                    A[b]+=min;
                    break;
                }
            }

        }
        for (int i = 0; i < n-1; i++){
            if (!flag[i]){
                System.out.print(A[i]+" ");
            }
        }
        System.out.print(A[n-1]);

    }
}
