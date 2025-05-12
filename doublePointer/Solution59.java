package doublePointer;

class Solution59 {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int loop= 1;
        int startX=0,startY=0;
        int offset=1;
        int count=1;

        while(loop<=n/2){
            for(int i=startY;i<n-offset;i++){
                res[startX][i]=count++;
            }
            for (int i=startX;i<n-offset;i++){
                res[i][n-offset]=count++;
            }
            for (int i=n-offset;i>startY;i--){
                res[n-offset][i]=count++;
            }
            for(int i=n-offset;i>startX;i--){
                res[i][startY]=count++;
            }
            startX++;
            startY++;
            offset++;
        }
        if (n%2==1){
            res[n/2][n/2]=count;
        }
        return res;
    }
}