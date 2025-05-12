package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//N 皇后问题
class Solution51 {
    List<List<String>>res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char [][] chessboard=new char[n][n];
        for (char [] c:chessboard){
            Arrays.fill(c,'.');
        }
        backTrack(n,0,chessboard);
        return res;
    }

    public void backTrack(int n,int row,char[][]chessboard){
        if (row==n){
            res.add(Array2List(chessboard));
            return ;
        }
        for (int col = 0; col< n; col++) {
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col]='Q';
                backTrack(n,row+1,chessboard);
                chessboard[row][col]='.';
            }
        }
    }
    public List Array2List(char[][]chessboard){
        List<String>list=new ArrayList<>();
        for (char[] c:chessboard){
            list.add(String.valueOf(c));
        }
        return list;
    }

    public boolean isValid(int row,int col,int n,char[][]chessboard){
        //判断同一列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col]=='Q'){
                return false;
            }
        }
        //判断45度同一斜线
        for (int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }
        //判断135度同一斜线
        for (int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }
}