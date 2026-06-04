package t13_Generics_Collections;

public class CustomArrayList {
    static void main() {
        CustomArrayList list  = new CustomArrayList();
        list.add(1);
        list.add(5);
        list.add(12);
        System.out.println(list.remove());
        System.out.println(list.get(0));
        System.out.println(list.size());
        System.out.println(list.isFull());
    }

    int [] data ;
    final private static int default_size = 10;
    private int size = 0;


    public CustomArrayList() {
        data = new int[default_size];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }
    public int remove(){
        int temp = data[--size];
        return temp;
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }

    private void resize() {
        int [] temp = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        temp = data;
    }

    private boolean isFull() {
        return size==data.length;
    }
}

