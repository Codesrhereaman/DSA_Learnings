package Pratice.effortforSLP;

public class l238 {
    public static void main(String[]args){
        System.out.println(productExceptSelf(new int[]{1,2,3,4}));

    }
    public static  int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] pl = new int[n];
        int [] pr = new int[n];
        pl[0] = nums[0];
        pr[n-1] = nums[n-1];
        for(int i = 1;i<pl.length;i++){
            pl[i] = pl[i-1]*nums[i];
        }
        for(int i = n-2;i>=0;i--){
            pr[i] = pr[i+1]*nums[i];
        }
        int [] sol = new int[n];
        sol[0] = pr[1];
        sol[n-1] = pl[n-2];
        for(int i = 1 ; i<=n-2;i++){
            sol[i] = pl[i-1]*pr[i+1];
        }
        return sol;
    }
}
