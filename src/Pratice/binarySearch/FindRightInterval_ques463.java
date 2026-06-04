package Pratice.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval_ques463 {
    static void main() {
        int[][] intervals = {
                {8,10},
                {1,3},
                {5,7},
                {2,4}
        };
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }
    static int[] findRightInterval(int[][] intervals) {
        int[] returnable = new int[intervals.length];
        int[][] pre = new int[intervals.length][intervals[0].length];
        for (int i = 0; i < intervals.length; i++) {
            pre[i][0] = intervals[i][0];
            pre[i][1] = i;
        }
        Arrays.sort(pre, new Comparator<int[]>() {
            @Override
            public int compare(int[]a , int[] b){
                return a[0]-b[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int preIndex = binarySearch2d(pre,intervals[i][1]);
            returnable[i] = (preIndex==-1)?-1:pre[preIndex][1];
        }
        return returnable;

    }

    private static int binarySearch2d(int[][] arr, int target) {

        int s = 0;
        int e = arr.length - 1;

        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid][0] >= target) {
                ans = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }

        return ans;
    }


}
