package t20_Heaps;

import java.util.ArrayList;

public class minheap {
    ArrayList<Integer> heap;

    static void main() {
        minheap m1 = new minheap();
        int[] arr = {23,5,1,6,10, 3, 28};
        for (int i = 0; i < arr.length; i++) {
            m1.insert(arr[i]);
        }
        System.out.println(m1.heap.toString());
        m1.delete(0);
        System.out.println(m1.heap.toString());
        System.out.println(m1.heapSort(m1).toString());

    }

    public minheap() {
        this.heap = new ArrayList<>(10);
    }


    void insert(int n) {
        heap.add(n);
        int index = heap.size() - 1;
        heapify(index);
    }
    int delete(int index){
        if(index==heap.size()-1) {
            return heap.removeLast();
        }
        swap(index,heap.size()-1);
        int element = heap.removeLast();
        int parent = (index-1)/2;
        if(index>0 && heap.get(index)<heap.get(parent)){
            heapify(index);
        }else{
            heapifyUpDown(index);
        }
        return element;
    }

    private void heapifyUpDown(int index) {
        if(index>=heap.size())
            return;

        int leftIndex = index*2+1;
        if(leftIndex>=heap.size()) return;
        int newIndex = leftIndex;
        int rightIndex = index*2+2;
        if(rightIndex<heap.size() && heap.get(rightIndex)<heap.get(leftIndex)) {
            newIndex = rightIndex;
        }
        if(heap.get(newIndex)>=heap.get(index)){
            return;
        }
        swap(index,newIndex);
        heapifyUpDown(newIndex);
    }


    private void heapify(int index) {
        if(index==0){
            return;
        }
        int newIndex = (index - 1) / 2;
        if (heap.get(newIndex) <= heap.get(index)) {
            return;
        }
        swap(index, newIndex);
        heapify(newIndex);
    }

    private void swap(int index, int newIndex) {
        int temp = heap.get(index);
        heap.set(index, heap.get(newIndex));
        heap.set(newIndex, temp);
    }

    public ArrayList<Integer> heapSort(minheap m){
        ArrayList<Integer> data = new ArrayList<>();
        while (!m.heap.isEmpty()){
            data.add(m.delete(0));
        }
        return data;
    }



}

