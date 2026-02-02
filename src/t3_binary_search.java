public class t3_binary_search {
    public static void main(String[] args) {
        int [] arr = {
                1,2,3,4,5,6,7,8,9,67,467,5785
        };
        int []arr2 = {
                89,67,56,45,34,23,12,9,6,4,2,1,1
        };

        int target = 1;
        System.out.println(OrderAgnosticBS(arr2,target));
    }



    //search in a sorted array in any form
    static int OrderAgnosticBS(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        boolean isAsc = arr[start] < arr[end];

        while(end >= start){
            int mid = start + (end - start)/2;
            if(arr[mid]==target){
                System.out.println("element found ");
                return mid;
            }
            if(isAsc){
                if (arr[mid]>target) {
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if (arr[mid]<target) {
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }

        }
        System.out.println("element not found");
        return -1;
    }

    //search in sorted ascending array
    static int search(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        int mid;
        while(end >= start){
            mid = (start + end)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]>target) {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
