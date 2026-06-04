package Pratice.twoPointer;

public class maxArea_ques11 {

    static void main() {
        int []arr = {1,3,5,7,3,8};
        System.out.println(maxArea(arr));
    }

    //question 11
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        while(l<r){
            int minHeight = Math.min(height[l],height[r]);
            maxArea = Math.max(maxArea,minHeight*(r-l));
            while(l<r && height[l]<=minHeight){
                l++;
            }while(l<r && height[r]<=minHeight){
                r--;
            }
            //height lower than previous height can not produce a more area
//            if(height[l]<=height[r]){
//                maxArea = Math.max(maxArea,(r-l)*height[l]);
//                l++;
//            }else{
//                maxArea = Math.max(maxArea,(r-l)*height[r]);
//                r--;
//            }
        }
        return maxArea;
    }
}
