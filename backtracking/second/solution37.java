package backtracking.second;

class Solution37 {
    public void solveSudoku(char[][] board) {
        solveSudoKuHelper(board);

    }

    private boolean solveSudoKuHelper(char[][] board){
        for (int i=0;i<9;i++){
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){
                    if (isValidSudoku(i,j,k,board)){
                        board[i][j]=k;
                        if (solveSudoKuHelper(board)){
                            return true;
                        }
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValidSudoku(int row,int col,char k,char[][] board){
        // 判断同一列
        for (int i = 0; i < 9; i++){
            if (board[i][col]==k){
                return false;
            }
        }
        // 判断同一行
        for (int j = 0; j < 9; j++) {
            if (board[row][j]==k){
                return false;
            }
        }
        // 判断同一块九宫格
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol+3; j++) {
                if (board[i][j]==k){
                    return false;
                }
            }
        }
        return true;
    }

}