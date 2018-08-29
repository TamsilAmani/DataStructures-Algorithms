package HeapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HeapSorting {
    static Heap obj = new Heap();

    public static void main(String args[]) throws IOException {
        HeapSorting object = new HeapSorting();
        Random ran = new Random();

        for(int i=0; i < obj.arr.length ; i++)
            obj.arr[i] = ran.nextInt(500)+1;

        System.out.println("----- Original Array -----");
        for(int d : obj.arr)
            System.out.print(d+ " ");
        System.out.println();

        System.out.println("Enter :");
        System.out.println("1. Insert \n2. Build Heap \n3. Sort \n4. EXIT. \n");
        int c = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        while(c != 4) {
            switch(c) {
                case 1 : {
                    obj.checksize();

                    object.insert(obj.arr);
                    System.out.println("----- New Array -----");
                    for (int d : obj.arr)
                        System.out.print(d + " ");
                    System.out.println();
                }
                break;

                case 2 :
                {
                    object.buildMaxHeap(obj.arr);

                    System.out.println("----- Heapified Array -----");
                    for (int d : obj.arr)
                        System.out.print(d + " ");
                    System.out.println();
                }

                break;

                case 3 :
                {
                    object.heapSort(obj.arr);
                    obj.heapsize = obj.arr.length-1;

                    System.out.println("----- Sorted Array -----");
                    for (int d : obj.arr)
                        System.out.print(d + " ");
                    System.out.println();
                }
                break;
                default: System.out.println("Try Again ! ");
            }
            System.out.println("\nEnter :");
            System.out.println("1. Insert \n2. Build Heap \n3. Sort \n4. EXIT. \n");
            c = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        }
    }

    private void buildMaxHeap(int x[]){

        int n = x.length;
        int range = (int)Math.ceil(n/2);

        for(int i = range ; i>=0 ; i--){
            maxHeapify(x,i);
        }
    }

    private void maxHeapify(int x[], int i){

        int l = obj.getLeft(i);
        int r = obj.getRight(i);

        int largest = i;

        if(l <=obj.heapsize && x[l] > x[largest])
            largest = l;

        //System.out.println("r = "+r+" i  = "+i+" largest = "+largest+" obj.heapsize = "+obj.heapsize);

        if(r <= obj.heapsize && x[r] > x[largest])
            largest = r;

        if(largest != i){
            int t = x[largest];
            x[largest] = x[i];
            x[i] = t;

            maxHeapify(x,largest);
        }


    }

    private void heapSort(int x[]){

        for(int i = x.length-1 ; i>=1 ; i--){
            int t = x[i];
            x[i] = x[0];
            x[0] = t;

            obj.heapsize--;

            maxHeapify(x,0);
        }


    }

    private void insert(int x[]) throws IOException {
        System.out.println("Enter element : ");

        x[x.length-1] = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    }
}
