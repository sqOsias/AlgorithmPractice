package backtracking.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution51 {
    List<List<String>>res=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char [][] chessboard=new char[n][n];
        for (char [] c:chessboard){
            Arrays.fill(c,'.');
        }
        backtracking(n,0,chessboard);
        return res;
        
    }

    public void backtracking(int n,int row,char[][]isUsed){
        if(row==n){
            res.add(Array2List(isUsed));
            return ;
        }
        for (int col=0;col <n;col++){
            if(isvalid(row,col,n,isUsed)){
                isUsed[row][col]='Q';
                backtracking(n,row+1,isUsed);
                isUsed[row][col]='.';
            }
        }
    }

    private List<String> Array2List(char[][] isUsed) {
        List<String>list=new ArrayList<>();
        for (char[] c:isUsed){
            list.add(String.valueOf(c));
        }
        return list;
    }

    public boolean isvalid(int row,int col,int n,char[][]isUsed){
        for (int i = 0; i < row; i++) {
            if (isUsed[i][col]=='Q'){
                return false;
            }
        }
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (isUsed[i][j]=='Q'){
                return false;
            }
        }

        for (int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if (isUsed[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution51 s=new Solution51();
        System.out.println(s.solveNQueens(4));
    }
}