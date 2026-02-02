import java.util.Arrays;

public class t5_binarySearch_in_2d_arrays {
    public static void main(String[] args){
        //Q1
//        int[][] arr = {
//                {3,8,9},
//                {5,10,13},
//                {10,12,15},
//                {11,19,20}
//        };
//        int target  = 20;
//        int[] result = targetin2d(arr,target);
//        System.out.printf(Arrays.toString(result));

        //Q2
        int [][] arr =  {
                {1,2,3,4}
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16},
//                {17,18,19,20}
        };


        int target = 1;
        System.out.println(Arrays.toString(targetInSortedArray(arr,target)));

    }


    //Q2 -> finding element in array that is sorted fully
    private static int[] targetInSortedArray(int[][] nums,int target){
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        int rows = nums.length;
//        int cols = (nums[0].length ); ? nums[0].length : -1;   //checked if it empty or not
        int cStart = 0;
        int cEnd = nums[0].length-1;
        int rStart = 0;
        int rEnd = nums.length -1;
        int midC = (cStart + cEnd) / 2;
        if(rows == 1){
            return search(nums,0,target,0,nums[0].length-1);
        }

        else{
            while (rStart < (rEnd-1)){ //while this is true , then we have atLeast two remaining
                int midR  = (rStart + rEnd) / 2;
                if (nums[midR][midC] == target){
                    return new int[]{midR,midC};
                }
                else if(nums[midR][midC] < target){
                    rStart = midR ;
                }
                else{
                    rEnd = midR;
                }
            }
        }
        //Now we have two rows
        if(nums[rStart][midC] == target ){
            return new int[]{rStart,midC};
        }
        if(nums[rStart+1][midC] == target){
            return new int[]{rStart+1,midC};

        }

        //let divide into four segments
        //1st half
        else if(nums[rStart][midC-1] >= target  ){ // element will found in 1st row
            return search(nums,rStart,target,0,midC - 1);
        }
        //2nd half
        else if(nums[rStart][midC+1] <= target && nums[rStart][cEnd] >= target ){
            return search(nums,rStart,target,midC +1,cEnd);
        }
        //4th half
        else if(nums[rStart+1][midC+1] <= target && nums[rStart+1][cEnd] >= target ){
            return search(nums,rStart+1,target,midC + 1,cEnd);
        }
        //3rd half
        else{
            return search(nums,rStart+1,target,0,midC - 1);
        }
    }
    static int []search(int[][] arr,int row,int target,int cStart,int CEnd){
        while(CEnd >= cStart){
            int mid = (cStart + CEnd)/2;
            if(arr[row][mid] == target){
                return new int[]{row,mid};
            } else if (arr[row][mid]>target) {
                CEnd = mid-1;
            }
            else{
                cStart = mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    //Q1 -> finding the element in the sorted 2d array with optimum searching
    //array is sorted columnswise and rowwise
//    private static int[] targetin2d(int [][] nums,int target){
//        int r = 0;
//        int c = (nums.length) - 2;
//        while(r < nums.length && c >= 0){
//            if (nums[r][c] == target){
//                return new int[]{r,c};
//            }
//            else if(nums[r][c] < target){
//                r ++;
//            }
//            else{
//                c --;
//            }
//        }
        //this can be done also
//        for (int r = 0,int c = nums.length - 2; r < nums.length && c >= 0; ) {
//            if (nums[r][c] == target) {
//                return new int[]{r, c};
//            } else if (nums[r][c] < target) {
//                r++;
//            } else {
//                c--;
//            }
//        }

//        return new int[] {-1,-1};
//    }
}
