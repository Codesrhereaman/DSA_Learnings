package Pratice.effortforSLP;

import java.util.HashMap;
import java.util.Map;

public class l1 {

    int[] twoSum(int[] arr,int target){
        Map<Integer,Integer> map  = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.get(target-arr[i]) != null){
                return new int[]{i,(int)map.get(target-arr[i])};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }
}
