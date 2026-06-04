package Pratice.patterns;

public class numbersPrint {
    static void main() {
        printPattern(5);
    }

    private static void printPattern(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }for (int j = 1; j <= 2*i-1; j++) {
                if(!iIsEven(j))  System.out.print(num++);
                else  System.out.print("  ");
            }
            System.out.println();
        }
    }
    private static boolean iIsEven(int i) {
        return i%2==0;
    }
}
