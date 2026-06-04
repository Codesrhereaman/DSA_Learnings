package Pratice;

import java.util.*;
public class array_revision {

    public static void main(String[] args) {
        int [][] arr = {{0,2,3},{4,0,6},{7,8,9}};
//        System.out.println(spiralMatrix(arr));
        int[] srr = {-2,1,-3,4,-1,2,1,-5,4};
//        rotate(srr,3);
//        System.out.println(Arrays.toString(srr));

//        setZeroes(arr);
//        for(int[] row:arr){
//            for (int col:row){
//                System.out.print(col+" ");
//            }
//            System.out.println();
//        }

//        System.out.println(maxSubArray(srr));
//        System.out.println(Arrays.toString((srr)));
//        lastRotate(srr);
//        System.out.println(Arrays.toString((srr)));
        System.out.println(Arrays.toString(findCarVehicle(15,42)));

    }

    //question 560
    public int subarraySum(int[] nums, int k) {
        int currSum = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(currSum==k){
                count++;
                currSum = nums[i];
            }
            if(currSum<k){
                currSum+=nums[i];
            }else{
                currSum = nums[i];
            }
        }
        return count;
    }

    //question 53
    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i],nums[i]+currSum);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        int overlap = overlapWidth * overlapHeight;

        return area1 + area2 - overlap;
    }

    //question54
    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++)
                res.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    res.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }
    static void rotate(int[] nums, int k) {
        int index  = nums.length-k-1;
        int s = 0,end = index;
        //swap from start to index
        while(s<end){
            swap(nums,s,end);
            s++;
            end--;
        }
        //swap from index+1 to last
        s = index+1;
        end = nums.length-1;
        while(s<end){
            swap(nums,s,end);
            s++;
            end--;
        }

        //reverse whole array
        s=0;
        end=nums.length-1;
        while(s<end){
            swap(nums,s,end);
            s++;
            end--;
        }
    }
    static void swap(int[]arr,int index1,int index2){
        int temp  = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    static void lastRotate(int[] arr){
        int temp  = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0]  = temp;
    }

    static int[] findCarVehicle(int vehicle,int tyres){
        if((tyres & 1) ==1 || tyres<2*vehicle || tyres>4*vehicle) return new int[]{-1,-1};
        int c ,b;
        c = (tyres - 2* vehicle)/2;
        b  = vehicle - c;
        return new int[]{b,c};
    }

    //Question 73
    static void setZeroes(int [][] arr){
        int tr = arr.length;
        int tc = arr[0].length;
        boolean zeroRowIndex = false;
        boolean zeroColIndex = false;

        for (int row = 0; row < tr; row++) {
            for (int col = 0; col < tc; col++) {
                if(arr[row][col] ==0){
                    if(row==0) zeroRowIndex = true;
                    if(col==0) zeroColIndex = true;
                    arr[row][0]=0;
                    arr[0][col] = 0;
                }
            }
        }
        //going in row
        for (int i = 1; i < tr; i++) {
            if(arr[i][0]==0){
                for (int j = 0; j < tc; j++) {
                    arr[i][j]=0;
                }
            }
        }
        //for column
        for (int i = 1; i < tc; i++) {
            if(arr[0][i]==0){
                for (int j = 0; j < tr; j++) {
                    arr[j][i]=0;
                }
            }
        }
        if(zeroRowIndex) {
            for (int i = 0; i < tc; i++) {
                arr[0][i] = 0;
            }
        }
        if(zeroColIndex){
            for (int j = 0; j < tr; j++) {
                arr[j][0] =0;
            }
        }
    }







}
