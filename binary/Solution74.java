package binary;

import static java.util.Collections.binarySearch;

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //将martix转换成一维数组
        int[] arr=new int[matrix.length*matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                arr[i*matrix[0].length+j]=matrix[i][j];
            }
        }
        return binarySearch(arr,target);
    }

    private boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }
}