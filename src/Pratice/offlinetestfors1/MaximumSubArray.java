package Pratice.offlinetestfors1;

import t13_Generics_Collections.clonning.Main;

public class MaximumSubArray {
    static void main() {
    }
    static int max(int [] arr){
        int currSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int a:arr){
            currSum = Math.max(currSum+a,a);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}
