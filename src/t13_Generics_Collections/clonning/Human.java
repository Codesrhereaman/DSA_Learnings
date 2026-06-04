package t13_Generics_Collections.clonning;

//clonning is used to create the class instance copies when needed , avoid using new
public class Human implements Cloneable{
    int age;
    String name;
    int[ ] arr;


    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        arr= new int[]{1,2,4,5,7};
    }


//    public Human(Human other) {
//        other.age = this.age;
//        other.name = this.name;
//    }


    public Object clone() throws CloneNotSupportedException{
//        shallow copy this is
        Human newObj = (Human) super.clone();

        //deep copy of required object
        newObj.arr = new int[this.arr.length];
        for (int i = 0; i < arr.length; i++) {
            newObj.arr[i] =  this.arr[i];
        }
        return (Human)newObj;
    }
}
