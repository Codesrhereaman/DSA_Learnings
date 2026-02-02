import java.util.ArrayList;
import java.util.List;

public class t13_Recursion_Questions {
    public static void main(String[] args) {
        int [] arr = {5,6,7,8,1,2,3,4};
        System.out.println(sorted(arr,0));
        System.out.println(find(arr,0,5));
        ArrayList<Integer> s = new ArrayList<>();
        System.out.println(find2(arr,0,8));
        System.out.println(rbs(arr,3,0,arr.length-1));
    }
    //is sorted
    static boolean sorted(int[] arr,int index){
        if(index+1==arr.length){
            return true;
        }
        return (arr[index] < arr[index+1]) && sorted(arr,index+1);
    }
    //is target present
    static boolean find(int [] arr,int index,int target){
        if(arr.length==index){
            return false;
        }
        return arr[index] == target || find(arr,index+1,target);
    }
    //list contain all target indices
    static List<Integer> find(int[] arr, int index, int target, ArrayList<Integer> s){
        if(index==arr.length){
            return s;
        }
        if(target==arr[index]){
            s.add(index);
        }
        return find(arr,index+1,target,s);
    }
    //similar above without list in the argument
    static ArrayList<Integer> find2(int[] arr, int index, int target){
        ArrayList<Integer> s = new ArrayList<>();
        if(index==arr.length){
            return s;
        }
        if(target==arr[index]){
            s.add(index);
        }
        ArrayList<Integer> ansFromBelow = find2(arr,index+1,target);
        s.addAll(ansFromBelow);
        return s;
    }
    //find in rotated binary search
    static int rbs(int[] arr,int target,int start,int end){
        if(start>end) return -1;

        int mid = (start+end)/2;
        if(arr[mid]==target) return mid;
        if(arr[start]<=arr[mid]){
            if(target>=arr[start] && target<=arr[mid]){
                return rbs(arr,target,start,mid-1);
            }else{
                return rbs(arr,target,mid+1,end);
            }
        }
        if(target>=arr[mid] && target<=arr[end]){
            return rbs(arr,target,mid+1,end);
        }else{
            return rbs(arr,target,start,mid-1);
        }
    }

}
