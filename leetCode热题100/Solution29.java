package leetCode热题100;

import java.io.File;


class Solution29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        //todo
        return (int) (dividend/divisor > 0? Math.floor(dividend/divisor) : Math.ceil(dividend/divisor));

    }






    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        int divide = solution29.divide(7, -3);
        System.out.println(divide);




//        File file = new File("D:\\codefile\\JavaCode\\suanfa");
//        int javaFileCount = countJavaFiles(file);
//        System.out.println("Number of .java files: " + javaFileCount);
    }

    public static int countJavaFiles(File directory) {
        int javaFileCount = 0;
        File[] files = directory.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    javaFileCount += countJavaFiles(f); // 递归调用
                } else if (f.isFile() && f.getName().endsWith(".java")) {
                    javaFileCount++;
                }
            }
        }

        return javaFileCount;
    }
}

