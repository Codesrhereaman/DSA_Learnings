package Pratice.offlinetestfors1;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubArraySum {
    static void main() {
        System.out.println(subarraySum(new int[]{1,2,3},3));
    }

    public static int subarraySum(int[] nums, int k) {
        if(nums.length<1) return -1;
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        int sum = 0;
        prefixSumCount.put(0,1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(prefixSumCount.containsKey(sum - k)){
                count += prefixSumCount.get(sum-k);
            }
            prefixSumCount.put(sum,prefixSumCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
