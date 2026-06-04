package Pratice.SlidingWindow;

public class minSubArrayLen_ques209 {
    static void main() {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }
    static int minSubArrayLen(int target, int[] nums) {
        int length = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int l=0,r=0;
        while(l<nums.length && r<nums.length){
            sum += nums[r];
            length++;
            if(sum>=target){
                while(sum>=target){
                    minLength = Math.min(minLength,length);
                    sum -= nums[l];
                    l++;
                    length--;
                }
            }
            r++;
        }
        return minLength == Integer.MAX_VALUE?0:minLength;
    }
}
