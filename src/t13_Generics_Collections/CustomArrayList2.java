package t13_Generics_Collections;

import java.util.Arrays;
import java.util.List;

//for wildcard(fixing the type of type parameter) can use T extends dataTypeOfClass
public class CustomArrayList2<T extends Number> {
    static void main() {
        CustomArrayList2<Integer> list  = new CustomArrayList2<>();
        list.add(1);
        list.add(5);
        list.add(12);
        for (int i = 0; i < 10; i++) {
            list.add(i*3);
        }
        System.out.println(list.toString());
        System.out.println(list.remove());
        System.out.println(list.get(0));
        System.out.println(list.size());
        System.out.println(list.isFull());
    }

    Object []data ;
    final private static int default_size = 10;
    private int size = 0;


    public CustomArrayList2() {
        data = new Object[default_size];
    }

    //WildCard also fix the subclass type taking as a parameter
    public void getNumber(List<? extends Number> list){
        //doing something
        //see here you can take only Number type if not use extends
    }




    @Override
    public String toString(){
        return "data=" + Arrays.toString(data) + " size=" + size();
    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }
    public T remove(){
        T datum = (T) data[--size];
        return datum;
    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }

    private void resize() {
        Object [] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size==data.length;
    }
}

