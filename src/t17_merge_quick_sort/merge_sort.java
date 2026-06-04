package t17_merge_quick_sort;

import java.util.Arrays;

public class merge_sort {
    public static void main() {
        int[] arr = {8,3,4,12,5,6};
        int  [] sorted = MergeSort(arr);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Arrays.toString(arr));
        MergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(sorted));

    }

    static void MergeSort(int [] arr,int start,int end){
        if(start<end){
        int mid  = (start+end)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[start+i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int k = start;


        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        if (j < right.length) {
            while(j<right.length) arr[k++] = right[j++];
        }
        if(i<left.length){
            while(i<left.length) arr[k++] = left[i++];
        }
    }


    static int [] MergeSort(int [] arr){
        if(arr.length==1){
            return arr;
        }

        int mid  = arr.length/2;
        int[] left = MergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return mergeUsingArrays(left,right);
    }

    private static int[] mergeUsingArrays(int[] left, int[] right) {
        int [] merged  = new int[left.length+right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                merged[k] = left[i];
                i++;
            }
            else{
                merged[k] = right[j];
                j++;
            }
            k++;
        }
        if (i == left.length) {
            while(j<right.length) merged[k++] = right[j++];
        }
        if(j==right.length){
            while(i<left.length) merged[k++] = left[i++];
        }
        return merged;
    }
}
