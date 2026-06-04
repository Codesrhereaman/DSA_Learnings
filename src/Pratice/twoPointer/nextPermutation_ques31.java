package Pratice.twoPointer;

import java.util.Arrays;

public class nextPermutation_ques31 {
    static void main() {
        int[] arr = {1,8,6,2,5,9,8,7};

        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }


    //question 31
    public static void nextPermutation(int[] nums) {
        int r = nums.length-2;
        int idx = -1;
        for (int i = r; i >= 0; i--) {
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums,0,r+1);
            return;
        }
        for (int i = r+1; i > idx; i--) {
            if(nums[idx]<nums[i]){
                swap(nums,i,idx);
                break;
            }
        }
        reverse(nums,idx+1,r+1);
    }
    static void reverse(int[] nums,int l, int r) {
        while(r>l){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    static void swap(int[] nums, int i, int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
}
