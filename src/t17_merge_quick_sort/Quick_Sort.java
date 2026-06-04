package t17_merge_quick_sort;

import java.util.Arrays;

public class Quick_Sort {
    static void main() {
        int[] arr ={5,4,1,3,2};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[]arr ,int l,int h){
        if(l>=h){
            return;
        }
        int s = l,e =  h;
        int mid  =s+(e-s)/2;
        int pivot = arr[mid];
        while(s<=e){
            while(arr[s]<pivot) s++;
            while(arr[e]>pivot) e--;
            if(s<=e){
                swap(arr,s,e);
                s++;
                e--;
            }
        }
        quickSort(arr,l,e);
        quickSort(arr,s,h);
    }
    //taking last element as pivot
    static void quickSort2(int []arr,int l,int h){
        if(l>=h){
            return;
        }
        int s = l,e =  h-1;
        int pivot = arr[h];
        while(s<=e){
            while(arr[s]<pivot ) s++;
            while(e>=l && arr[e]>pivot) e--;
            if(s<=e){
                swap(arr,s,e);
                s++;
                e--;
            }
        }
        swap(arr,s,h);
        quickSort2(arr,l,e);
        quickSort2(arr,s+1,h);
    }
    static void swap(int[]arr,int index1,int index2){
        int temp  = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
