package HeapSort;

import java.util.Arrays;

public class Heap {
    int heapsize;

    int arr[];
    Heap(){
        arr = new int[5];
        heapsize = 4;
    }

    int getLeft(int index){
        return (2*index)+1;
    }

    int getRight(int index){
        return (2*index)+2;
    }

    void checksize(){

        if(heapsize+1 == arr.length) {
            System.out.println("This is true");
            arr = Arrays.copyOf(arr, arr.length + 1);

        }
        heapsize = arr.length-1;
    }
}
