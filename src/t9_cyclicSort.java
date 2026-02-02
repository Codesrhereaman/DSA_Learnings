import java.util.*;
//import java.util.Arraylist;

public class t9_cyclicSort {
    public static void main(String[] args) {
        //Cyclic Sort
        int [] arr = {
                100000,3,4000,2,15,1,99999
        };
        System.out.println(firstMissingPositive(arr));
    }

    private static void cyclicSort(int [] nums){
        for(int i = 0;i<nums.length;i++){
            boolean isAtIndex = (nums[i] == i+1);
            while(!isAtIndex){
                swap(nums,i,nums[i]-1);
                isAtIndex = (nums[i] == i+1);
//                if(!isAtIndex){
//                    System.out.println(nums[i]);
//                    return ;
//                }
            }
        }
    }
    //for values [0,n]
    private static int cyclicSort2(int []nums){
        int i =0;
        while(i<nums.length){
            //not needed
//            if(nums[i] == nums.length){
//                i++;  //skip that i is the last element found as we hve one missing number
//            }
            if(nums[i] < nums.length && nums[i] != i){
                swap(nums,nums[i],i);
            }
            else{
                i++;
            }
        }
        for(i = 0 ;i<nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return -1;
    }
    //the most optimum way to do it
    public int missingNumber(int[] nums) {
        int n = nums.length,sum=0;
        for (int num : nums) {
            sum += num;
        }
        return (n*(n+1))/2 - sum;
    }
    private static void swap(int []nums,int index1 ,int index2){
        int temp  = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    //Q2
    private static ArrayList<Integer>findAllMissing(int []nums){
        int i = 0;
        while(i<nums.length){
            if( nums[i] == nums[nums[i]-1]){
                i++;
            }
            else{
                swap(nums,nums[i]-1,i);
            }
        }
        ArrayList<Integer> list  = new ArrayList<Integer> ();
        int count = 0;
        for(i = 0 ;i<nums.length;i++){
            if(nums[i] != i+1){
                list.add(i+1);
            }
        }
        return list;
    }
        //Q41 on leetcode
        public static int firstMissingPositive(int[] nums) {
            int i = 0,n=nums.length;
            while (i < n) {
                if (nums[i] != i+1 ){
                    int correct = nums[i] - 1;
                    if (correct > 0 && nums[i] < n && nums[i] != nums[correct] ){
                        swap(nums,correct,i);
                    }else{
                        i++;
                    }
                }
                else{
                    i++;
                }
            }
            int smallest = 1;
            for(int in=0;in<nums.length;in++){
                if(nums[in] != smallest && nums[in] >= 0){
                    return smallest;
                }else{
                    smallest++;
                }
            }
            return n+1;
    }
}
//import java.util.*;
//class t9_cyclicSort {
//
//    //using counting sort instead of insertion sort
//    public static void sortColors(int[] nums) {
//        int [] count = new int[3];
//        for (int num : nums) {
//            count[num]++;
//        }
//        for (int j = 1; j <= 2; j++) {
//            count[j] = count[j] + count[j-1];
//        }
//        int []updated_nums = Arrays.copyOf(nums,nums.length);
//        for(int k=nums.length-1; k>0; k--){
//            int index = count[nums[k]]--;
//            updated_nums[index] = nums[k];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            updated_nums[i] = nums[i];
//        }
//    }
//    public static void main(String[] args){
//        int[] nums ={2,0,2,1,1,0};
//        sortColors(nums);
//    }
//
//}
