package Pratice.binarySearch;

public class guessTheNumber_ques374 {

    static void main() {
        guessTheNumber_ques374 guess = new guessTheNumber_ques374();
        System.out.println(guess.guessNumber(10));
    }
     int mid;
    public int guessNumber(int n) {
        return guessNumber(1,n);
    }

    private int guessNumber(int s, int n) {
        int mid = (s+n)/2;
        int pick = guess(mid);
        if(pick == 0){
            return mid;
        }
        else if(pick==-1){
            mid = guessNumber(s,mid-1);
        }else{
            mid = guessNumber(mid+1,n);
        }
        return mid;
    }

    int target = 6;
    private int guess(int mid) {
        if(mid==target){
            return 0;
        }else if(mid<target){
            return 1;
        }else{
            return -1;
        }
    }
}
