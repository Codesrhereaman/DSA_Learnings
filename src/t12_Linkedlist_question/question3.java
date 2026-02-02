package t12_Linkedlist_question;

public class question3 {
    public static void main(String[] args) {
        question3 q = new question3();
        System.out.println(q.isHappy(12));
    }
    public boolean isHappy(int n){
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    private int findSquare(int x){
        int sq=0;
        while(x!=0){
            sq += Math.pow(x % 10,2);
            x=x/10;
        }
        return sq;
    }
}
