package t13_Generics_Collections.clonning;

import java.util.Arrays;

//shallow copy and deep copy
//-> shallow copy means if you had taken the copy of a in b, changes made to b reflects in a also(use as reference variable for
//-> deep copy means if you had taken the copy of a in b, changes made to b does not reflects in a also
public class Main {
    static void main() throws CloneNotSupportedException{
        Human anand = new Human(20,"Anand");
//        Human Aman  = new Human(anand); //will take a high complexity and not suggested
        Human Aman  = (Human)anand.clone();
        System.out.println(Aman.age + " " + Aman.name);
        System.out.println(Arrays.toString(Aman.arr));
        Aman.arr[0] = 100;
        System.out.println(Arrays.toString(anand.arr));
    }
}
