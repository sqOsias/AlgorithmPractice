package DP;

class Solution509 {
    public int fib(int n) {
        System.out.println("========当前传入数字为：=========="+n);
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            int i = fib(n - 1) + fib(n - 2);
            System.out.println("返回的数字为："+i);
            return i;
        }
    }

    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        solution509.fib(10);
    }
}