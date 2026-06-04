package t20_Heaps;

import java.util.ArrayList;

public class maxheap {
    ArrayList<Integer> heap;

    static void main() {
        maxheap m1 = new maxheap();
        int[] arr = {2, 4, 6, 7, 3, 28};
        for (int i = 0; i < arr.length; i++) {
            m1.insert(arr[i]);
        }
        System.out.println(m1.heap.toString());
        m1.delete(0);
        System.out.println(m1.heap.toString());



    }

    public maxheap() {
        this.heap = new ArrayList<>(10);
    }


    void insert(int n) {
        heap.add(n);
        int index = heap.size() - 1;
        heapify(index);
    }
    void delete(int index){
        if(index==heap.size()-1) {
            heap.removeLast();
            return;
        }
        swap(index,heap.size()-1);
        heap.removeLast();
        int parent = (index-1)/2;
        if(index>0 && heap.get(index)>heap.get(parent)){
            heapify(index);
        }else{
            heapifyUpDown(index);
        }

    }

    private void heapifyUpDown(int index) {
        if(index>=heap.size())
            return;

        int leftIndex = index*2+1;
        if(leftIndex>=heap.size()) return;
        int newIndex = leftIndex;
        int rightIndex = index*2+2;
        if(rightIndex<heap.size() && heap.get(rightIndex)>heap.get(leftIndex)) {
            newIndex = rightIndex;
        }
        if(heap.get(newIndex)<heap.get(index)){
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
        if (heap.get(newIndex) >= heap.get(index)) {
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



}

