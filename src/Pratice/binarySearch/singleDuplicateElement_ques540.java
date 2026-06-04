package Pratice.binarySearch;

public class singleDuplicateElement_ques540 {
    static void main() {

        int []arr = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));
    }

    static int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int s = 0, r = n - 1;

        while (s <= r) {
            int mid = s + (r - s) / 2;
            boolean leftDiff = (mid == 0 || arr[mid] != arr[mid - 1]);
            boolean rightDiff = (mid == n - 1 || arr[mid] != arr[mid + 1]);
            if (leftDiff && rightDiff) {
                return arr[mid];
            }
            if ((mid & 1) == 0) {
                if (mid +1<n && arr[mid + 1] == arr[mid]) {
                    s = mid + 2;
                } else{
                    r = mid-2;
                }
            }else{
                if (mid +1 < n  && arr[mid + 1] == arr[mid]) {
                    r = mid-1;
                } else {
                    s = mid+1;
                }
            }
        }
        return -1;
    }
}
