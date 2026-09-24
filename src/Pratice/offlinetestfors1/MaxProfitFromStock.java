package Pratice.offlinetestfors1;

public class MaxProfitFromStock {
    static void main() {

    }
    static int find(int[] ar){
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int a : ar){
            if(min<a){
                maxProfit = Math.max(maxProfit,a-min);
            }else{
                min = a;
            }
        }
        return maxProfit;
    }
}
