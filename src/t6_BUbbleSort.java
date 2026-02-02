import java.util.Arrays;

public class t6_BUbbleSort {
    public static void main(String[] args) {
        int [] arr = {
                1,2,60,3,4,5
        };
        BubbleSort(arr);
    }
    //bubble sort
    private static void BubbleSort(int[] nums){
        boolean IsSwap = false;
        if (nums.length == 1){
            System.out.println("only one element found to sort");
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i -1; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    IsSwap = true;
                }
            }
            if (!IsSwap){
                System.out.println("Already sorted");
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
