import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class t1_Arrays{
    public static void main(String[] args) {
//        optimised way to print the arrays in java
        Scanner sc = new Scanner(System.in);
        int[] arr = new int [5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        //Multi Dimensional Arraylist in JAVA
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }
        System.out.println("enter the elements: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(sc.nextInt());
            }
        }
        System.out.println(list);
    }
}