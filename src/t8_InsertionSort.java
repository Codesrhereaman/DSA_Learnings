import java.util.Arrays;

//Insertion sort means sort array from start to start+1 ,then put next element in the correct place of sorted array
public class t8_InsertionSort {
    public static void main(String[] args) {
        int [] arr = {
                1,0,45,3,656,56,7,3,2,6,575,57
        };

        InsertionSort(arr);
    }
    //Insertion sort
    private static void InsertionSort(int [] nums){
        if (nums.length == 1){
            System.out.println("only one element found to sort");
            return;
        }
        for(int i =0; i < nums.length -1; i++){
//            int element = nums[i];
            for(int j = i +1; j>0; j--){
                if(nums[j] < nums[j-1]){
                    swap(nums,j,j-1);
                }
                else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    private static void swap(int []nums,int index1 ,int index2){
        int temp  = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}

