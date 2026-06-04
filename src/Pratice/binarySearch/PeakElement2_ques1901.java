package Pratice.binarySearch;

import java.util.Arrays;

public class PeakElement2_ques1901 {
    static void main() {
        int[][] mat = {
                {1,10},
                {50,500},
                {40,2},
                {30,3},
                {20,4}
        };
        System.out.println(Arrays.toString(findPeakGrid(mat)));

    }

    static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int peakRowIndex = -1;
        int cs = 0, ce = n - 1;
        while(ce>cs){
            int mid = cs + (ce-cs)/2;
            peakRowIndex = findMaxRow(mat,mid);
            if((mid+1>n-1 || mat[peakRowIndex][mid+1]<mat[peakRowIndex][mid]) && (mid-1<0 || mat[peakRowIndex][mid-1]<mat[peakRowIndex][mid])){
                return new int[]{peakRowIndex,mid};
            }
            if(mat[peakRowIndex][mid+1]<mat[peakRowIndex][mid]){
                ce = mid;
            }else{
                cs = mid+1;
            }
        }
        return new int[]{findMaxRow(mat,cs),cs};


    }

    static int findMaxRow(int[][] mat, int col){
        int row = 0;
        for(int i=1;i<mat.length;i++){

            if(mat[i][col] > mat[row][col]){
                row = i;
            }
        }
        return row;
    }
}
