package t13_Generics_Collections.comparable;
//to compare class , use comparable interface
public class Student implements Comparable<Student> {
    int rollNo;
    int marks;

    public Student(int rollNo, int marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo ;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks - o.marks);
        return diff;
    }
}
