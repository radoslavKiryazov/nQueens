public class Solution {
    int n = 4;

    public void printSolution(int[][] board) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1){
                    System.out.print(" Q ");
                } else {
                    System.out.print(" [] ");
                }
            }
            System.out.println();
        }
    }

    public boolean isSafe(int[][] board, int row, int col) {
        int i;
        int j;
        // check row
        for(i=0; i<col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }
        // check upper diagonal
        for(i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        // check lower diagonal
        for(i=row, j=col; i<n && j>=0; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean tryToPlace(int[][] board, int col) {
        if(col >= n) {
            return true; //return true if all queens are placed
        }
        for(int i=0; i<n; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 1;
                if(tryToPlace(board, col+1)) {
                    return true;
                }
                board[i][col] = 0; //backtrack, if there is no solution
            }
        }
        return false; //if the queen cant be placed in anywhere in this column, abort
    }

    public void solveNQ() {
        int[][] board = new int[n][n];
        if(!tryToPlace(board, 0)) {
            System.out.println("No Valid Solution Found");
        }
        printSolution(board);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solveNQ();
    }
}
