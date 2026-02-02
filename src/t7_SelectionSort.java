import java.util.Arrays;
//Selection Sort means select an item and put that at correct index
public class t7_SelectionSort {
    public static void main(String[] args) {
        int [] arr = {
                1,0,45,3,656,56,7,3,2,6,575,57
        };
        SelectionSortViaMin(arr);
    }
    //Selection sort
    private static void SelectionSort(int[] nums){
        if (nums.length == 1){
            System.out.println("only one element found to sort");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int maxIndex = 0;
            int lastIndex = nums.length - i - 1;
            for (int j = 1 ; j<nums.length - i ;j++){
                if(nums[j] > nums[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = nums[lastIndex];
            nums[lastIndex] = nums[maxIndex];
            nums[maxIndex ] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
    //trying this with smallest number
    private static void SelectionSortViaMin(int []nums){
        if (nums.length == 1){
            System.out.println("only one element found to sort");
            return ;
        }
        boolean isSwap = false;
        for (int i = 0; i < nums.length - 1 ; i++) {

            int smallestIndex = i;
            for (int j = 1 + i; j < nums.length  ; j++) {  //remember to iterate correctly
                if(nums[j] < nums[smallestIndex]){
                    smallestIndex = j;
                    isSwap = true;
                }
            }
            if(!isSwap){
                System.out.println("already Sorted");
            }
            int temp = nums[i];
            nums[i] = nums[smallestIndex];
            nums[smallestIndex] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
