package t16_backtraking;

import java.util.*;
import java.util.List;


public class backtraking {
    public static void main(String[] args) {
        int n = 3;
//        boolean[][] board = new boolean[n][n];
//                {false,false,false,false,false},
//                {false,false,false,false,false},
//                {false,false,false,false,false},
//                {false,false,false,false,false},
//                {false,false,false,false,false},


//        int [][] path = new int[board.length][board[0].length];
//        ratInMaze(board,"",0,0,path,1);
//        System.out.println(NQueen(board,0));
//        System.out.println(NKnight(board, 0));

        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
//        if(solveSodoku2(sudoku)){
//            displaySudokuInt(sudoku);
//        }
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},

                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},

                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        if(solveSudoku(board,0,0)){

        }
    }

    static void ratInMaze(boolean[][] arr, String sub, int i, int j, int[][] path, int steps) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            path[i][j] = steps;
            for (int[] ele : path) {
                System.out.println(Arrays.toString(ele));
            }
            System.out.println(sub);
            System.out.println();
            return;
        }
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
            return;
        }
        if (!arr[i][j]) {
            return;
        }
        path[i][j] = steps;
        arr[i][j] = false;
        ratInMaze(arr, sub + "U", i - 1, j, path, steps + 1);
        ratInMaze(arr, sub + "R", i, j + 1, path, steps + 1);
        ratInMaze(arr, sub + "T", i + 1, j + 1, path, steps + 1);
        ratInMaze(arr, sub + "D", i + 1, j, path, steps + 1);
        ratInMaze(arr, sub + "L", i, j - 1, path, steps + 1);
        arr[i][j] = true;
        path[i][j] = 0;
    }

    //for LeetCode nQueen


    static int NQueen(boolean[][] arr, int r) {
        if (r == arr.length) {
            display(arr);
            return 1;
        }
        int count = 0;
        for (int col = 0; col < arr.length; col++) {
            if (check(arr, r, col)) {
                arr[r][col] = true;
                count += NQueen(arr, r + 1);
                arr[r][col] = false;
            }
        }
        return count;
    }

    private static boolean check(boolean[][] arr, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (arr[i][c]) {
                return false;
            }
        }
        //for left side
        for (int row = 1; row <= Math.min(r, c); row++) {
            if (arr[r - row][c - row]) {
                return false;
            }
        }
        //for right side
        for (int row = 1; row <= Math.min(r, arr.length - c - 1); row++) {
            if (arr[r - row][c + row]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] arr) {
        for (boolean[] row : arr) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static int NKnight(boolean[][] arr, int r) {
        if (r == arr.length) {
            displayKnight(arr);
            return 1;
        }
        int count = 0;
        for (int col = 0; col < arr.length; col++) {
            if (checkKnight(arr, r, col)) {
                arr[r][col] = true;
                count += NKnight(arr, r + 1);
                arr[r][col] = false;
            }
        }
        return count;
    }

    private static boolean checkKnight(boolean[][] arr, int r, int c) {
        if (r > 0) {
            if (c > 1) {
                if (arr[r - 1][c - 2]) return false;
            }
            if (c < arr[0].length - 2) {
                if (arr[r - 1][c + 2]) return false;
            }
        }
        if (r > 1) {
            if (c > 0) {
                if (arr[r - 2][c - 1]) return false;
            }
            if (c < arr[0].length - 1) {
                if (arr[r - 2][c + 1]) return false;
            }
        }
        return true;
    }

    private static void displayKnight(boolean[][] arr) {
        for (boolean[] row : arr) {
            for (boolean element : row) {
                if (element == true) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static void displaySudokuInt(int[][]board){
        for(int[] rows:board){
            for(int col:rows){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean solveSodoku2(int[][]board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean isLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isLeft = false;
                    break;
                }
            }
            if (!isLeft) {
                break;
            }
        }

        if (isLeft) {
            return true;
        }

        for (int number = 1; number < 10; number++) {
            if (isSafeInt(board, number, row, col)) {
                board[row][col] = number;
                if (solveSodoku2(board)) {
                    //if number is accepted
                    return true;
                } else { //backtrack
                    board[row][col] = 0;
                }
            }
        }
        return false; //sudoku can not be solved
    }
    static boolean isSafeInt(int[][] board,int number,int r,int c) {

        //checking in row
        for (int j = 0; j < board[0].length; j++) {
            if (board[r][j] == number) return false;
        }
        //checking at columns
        for (int j = 0; j < board.length; j++) {
            if (board[j][c] == number) return false;
        }
        //checking in grid
        int sq = (int) Math.sqrt(board.length);
        int startR = r - (r % sq);
        int startC = c - (c % sq);
        for (int i = startR; i < startR + sq; i++) {
            for (int j = startC; j < startC + sq; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }



    static void displaySudoku(char[][]board){
        for(char[] rows:board){
            for(char col:rows){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    static boolean solveSudoku(char[][] board, int r, int c) {
        if (r == board.length) {
            return true;
        }
        if (c == board[0].length) {
            return solveSudoku(board, r + 1, 0);
        }
        if(board[r][c]!='.'){
            return solveSudoku(board, r ,1+c);
        }
        if (board[r][c] == '.') {
            for (int i = 1; i < 10; i++) {
                char ch = (char)(i +'0');
                if (isSafe(board, ch, r, c)) {
                    board[r][c] = ch;
                    if(solveSudoku(board, r, c + 1)) return true;
                    board[r][c] = '.';
                }
            }
        }
        return false;
    }
    static boolean isSafe(char[][] board,char ch,int r,int c){
        //checking in row
        for (int j = 0; j < board[0].length; j++) {
            if(board[r][j]==ch) return false;
        }
        //checking at columns
        for (int j = 0; j < board.length; j++) {
            if(board[j][c]==ch) return false;
        }
        //checking in grid
        int sq = (int)Math.sqrt(board.length);
        int startR = r-(r%sq);
        int startC = c-(c%sq);
        for (int k = startR; k < startR + sq; k++) {
            for (int j = startC; j < startC + sq; j++) {
                if (board[k][j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();

        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] anti = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        solve(0, board, list, col, diag, anti);
        return list;
    }

    private void solve(int r, char[][] board, List<List<String>> list,
                       boolean[] col, boolean[] diag, boolean[] anti) {

        int n = board.length;

        if (r == n) {
            List<String> res = new ArrayList<>();
            for (char[] row : board) {
                res.add(new String(row));
            }
            list.add(res);
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || diag[r + c] || anti[r - c + n])
                continue;

            board[r][c] = 'Q';
            col[c] = true;
            diag[r + c] = true;
            anti[r - c + n] = true;

            solve(r + 1, board, list, col, diag, anti);

            board[r][c] = '.';
            col[c] = false;
            diag[r + c] = false;
            anti[r - c + n] = false;
        }
    }
}
