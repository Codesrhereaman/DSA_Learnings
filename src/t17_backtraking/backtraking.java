package t17_backtraking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class backtraking {
    public static void main(String[] args) {
        int n = 3;
        boolean [] [] board = new boolean[n][n];
//                {false,false,false,false,false},
//                {false,false,false,false,false},
//                {false,false,false,false,false},
//                {false,false,false,false,false},
//                {false,false,false,false,false},


//        int [][] path = new int[board.length][board[0].length];
//        ratInMaze(board,"",0,0,path,1);
//        System.out.println(NQueen(board,0));
        System.out.println(NKnight(board,0));
    }
    static void ratInMaze(boolean[][]arr,String sub,int i,int j,int [][] path,int steps){
        if(i==arr.length-1 && j==arr[0].length-1){
            path[i][j] = steps;
            for(int[] ele:path){
                System.out.println(Arrays.toString(ele));
            }
            System.out.println(sub);
            System.out.println();
           return ;
        }
        if(i<0||j<0||i>=arr.length||j>=arr[0].length){
            return ;
        }
        if(!arr[i][j]){
            return ;
        }
        path[i][j] = steps;
        arr[i][j] = false;
        ratInMaze(arr,sub+"U",i-1,j,path,steps+1);
        ratInMaze(arr,sub+"R",i,j+1,path,steps+1);
        ratInMaze(arr,sub+"T",i+1,j+1,path,steps+1);
        ratInMaze(arr,sub+"D",i+1,j,path,steps+1);
        ratInMaze(arr,sub+"L",i,j-1,path,steps+1);
        arr[i][j] = true;
        path[i][j] = 0;
    }
    static int NQueen(boolean[] [] arr,int r){
        if(r==arr.length){
            display(arr);
            return 1;
        }
        int count =0;
        for (int col = 0; col < arr.length; col++) {
            if(check(arr,r,col)){
                arr[r][col]  =true;
                count += NQueen(arr,r+1);
                arr[r][col] = false;
            }
        }
        return count;
    }

    private static boolean check(boolean[][] arr,int r,int c) {
        for (int i = 0; i < r; i++) {
            if(arr[i][c]){
                return false;
            }
        }
        //for left side
        for (int row = 1; row <=Math.min(r,c) ; row++) {
            if(arr[r-row][c-row]){
                return false;
            }
        }
        //for right side
        for (int row = 1; row <=Math.min(r,arr.length-c-1) ; row++) {
            if(arr[r-row][c+row]){
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] arr) {
        for(boolean[] row:arr){
            for(boolean element:row){
                if(element==true){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static int NKnight(boolean[] [] arr,int r){
        if(r==arr.length){
            displayKnight(arr);
            return 1;
        }
        int count =0;
        for (int col = 0; col < arr.length; col++) {
            if(checkKnight(arr,r,col)){
                arr[r][col]  =true;
                count += NKnight(arr,r+1);
                arr[r][col] = false;
            }
        }
        return count;
    }

    private static boolean checkKnight(boolean[][] arr,int r,int c) {
        if(r>0){
            if(c>1){
                if(arr[r-1][c-2]) return false;
            } if(c<arr[0].length-2) {
                if(arr[r-1][c+2]) return false;
            }
        }
        if(r>1){
            if(c>0){
                if(arr[r-2][c-1]) return false;
            } if(c<arr[0].length-1) {
                if(arr[r-2][c+1]) return false;
            }
        }
        return true;
    }

    private static void displayKnight(boolean[][] arr) {
        for(boolean[] row:arr){
            for(boolean element:row){
                if(element==true){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
