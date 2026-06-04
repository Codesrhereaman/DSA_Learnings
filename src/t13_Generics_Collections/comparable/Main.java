package t13_Generics_Collections.comparable;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static void main() {
        Student Aman = new Student(39,444447);
        Student Amber = new Student(40,240447);
        Student Aditya = new Student(41,640447);
        Student Anjali = new Student(42,840447);
        Student Uday = new Student(43,40447);


        Student[] list = {Aman,Amber,Anjali,Aditya,Uday};

        System.out.println(Arrays.toString(list));
        Arrays.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.rollNo - o2.rollNo;
            }
        });
        System.out.println(Arrays.toString(list));




        if(Aman.compareTo(Amber)>0){
            System.out.println("Aman is crazy");
        }else{
            System.out.println("Aman is little crazy");
        }
    }
}
