public class t10_patterns {
    public static void main(String[] args) {
        int n = 9;
//        rectOfStar(n);
//        hollowRectOfStar(n);
//        triOfStar(n);
//        reverseTriOfStar(n);
//        numOfStar(n);
//        pyramidTriOfStar(n);
//        pyramidTriOfStarOneLoop(n);
//        fullTriOfStar(n);
//        reverseFullTriOfStar(n);
        fullNumberTriOfStar(n);
    }

    public static void rectOfStar(int n){
        for (int row = 1; row <= n; row++) {
            for (int c = 1; c <= n; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void hollowRectOfStar(int n){
        for (int row = 1; row <= n; row++) {
            for (int c = 1; c <= n; c++) {
                if(row==1 || row ==n || c == 1 || c == n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void triOfStar(int n){
        for (int row = 1; row <= n; row++) {
            for (int c = 1; c <= row; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void reverseTriOfStar(int n){
        for (int row = n; row >= 1; row--) {
            for (int c = 1; c <=row; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void numOfStar(int n){
        for (int row = 1; row <= n; row++) {
            for (int c = 1; c <= row; c++) {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
    public static void pyramidTriOfStar(int n){
        for (int row = 1; row <= n; row++) {
            if(row == n){
                continue;
            }
            for (int c = 1; c <= row; c++) {
                System.out.print("*");
            }
            System.out.println();

        }
        for (int row = n; row >= 1; row--) {
            for (int c = 1; c <=row; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pyramidTriOfStarOneLoop(int n){
        for (int row = 1; row <= 2*n-1; row++) {
            int clnLooping = (row <=n ) ? row : 2*n - row;
            for (int c = 1; c <= clnLooping; c++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void fullTriOfStar(int n){
        for (int row = 1; row <= n; row++) {
            for (int c = 1; c <= 2*n-1; c++) {
                if(c< n-row+1 || c > n+row-1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void reverseFullTriOfStar(int n){
        for (int row = n; row >= 1; row--) {
            for (int c = 2*n-1; c >= 1; c--) {
                if(c< n-row+1 || c > n+row-1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void numberTriOfStar(int n){
        for (int row = 1; row <= n; row++) {
            int temp = row;
            for (int c = 1; c <= 2*n-1; c++) {
                if(c< n-row+1 || c > n+row-1){
                    System.out.print(" ");
                }else{
                    if(c<=n){
                        System.out.print(temp);
                        temp = temp>1 ? temp-1:1 ;
                    }else{
                        temp += 1;
                        System.out.print(temp);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void numberTriOfStar2(int n){
        for (int row = 1; row <= n; row++) {
            for (int spaces = 0; spaces < n-row; spaces++) {
                System.out.print(" ");
            }
            for (int i = row; i >= 1; i--) {
                System.out.print(i);
            }
            for (int j = 2; j <= row; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void fullNumberTriOfStar(int n){
        for (int row = 1; row <= 2*n-1; row++) {
            int cl = row>n ? 2*n-row:row;
            int temp = cl;

            for (int c = 1; c <= 2*n-1; c++) {
                if(c< n-cl+1 || c > n+cl-1){
                    System.out.print(" ");
                }else{
                    if(c<=n){
                        System.out.print(temp);
                        temp = temp>1 ? temp-1:1 ;
                    }else{
                        temp += 1;
                        System.out.print(temp);
                    }
                }
            }
            System.out.println();
        }
    }
    public static void fullNumberTriOfStar2(int n){
        for (int row = 1; row <= 2*n-1; row++) {
            int c = row > n? 2*n-row: row;
            for (int spaces = 0; spaces < n-c; spaces++) {
                System.out.print(" ");
            }
            for (int i = c; i >= 1; i--) {
                System.out.print(i);
            }
            for (int j = 2; j <= c; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
