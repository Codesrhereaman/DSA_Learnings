public class t2_linear_search {
    public static void main(String[] args) {
        // searching for an element
        int [] arr = {
                1,2,3,79,35,7,343,0
        };
        int target = 3;
        System.out.println(search(arr,target,1,4));

        //searching element in 2D array
        int [][] ar = {
                {1,2,3},
                {6,5,41,78},
                {7,89}
        };
        System.out.println(search2d(ar,target));

    }
    static int search(int[]arr,int target){
        for (int j : arr) {
            if (j == target) {
                return j;
            }
        }
        System.out.println("element not found");
        return -1;
    }
    //for specific range
    static int search(int[]arr,int target,int start,int end){
        for (int i = start; start <= end; start++) {
            if(arr[start] == target){
                return arr[start];
            }
        }
        System.out.println("element not found");
        return -1;
    }

    //search in 2d arrays
    static boolean search2d(int[][]arr,int target){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }
        System.out.println("element not found");
        return false;
    }
    

}
