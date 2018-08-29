package Searching_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Searching {
    int arr[];
    static int n;
    static BufferedReader br;

    private Searching() {
        n = 0;
    }

    public static void main(String args[]) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of test cases :");
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Searching obj = new Searching();

            //Calling Binary Search
            obj.generateArray();
            obj.binarySearch(obj.arr);

            // Calling Jump Search
            obj.generateArray();
            obj.jumpSearch(obj.arr);
        }

    }

    // Generate Array
    private void generateArray()throws IOException{
        Random rand = new Random();

        System.out.println("Enter array length: ");
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = rand.nextInt(1000)+1;
    }

    // Binary Search
    private void binarySearch(int x[])throws IOException {
        System.out.println("\n-----Searching_Sorting.Searching via Binary Search : ------");
        System.out.println("\nOriginal Array : ");

        Arrays.sort(x);
        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("Enter element to search : ");
        int d = Integer.parseInt(br.readLine());

        int pos = binarySearchAlgo(x,0,n-1,d);

        System.out.println("Position is :  "+pos);

    }

    private int binarySearchAlgo(int x[], int start, int end,int val){

        if(start<=end){
            int mid = (start+end)/2;

            if(x[mid] == val) {
                return (mid + 1);
            }

            else if(val < x[mid])
                return binarySearchAlgo(x,start,mid-1,val);

            else if(val > x[mid])
                return binarySearchAlgo(x,mid+1,end,val);

        }
        return -100;
    }

    // Jump Search

    private void jumpSearch(int x[])throws IOException{

        System.out.println("\n-----Searching_Sorting.Searching via Jump Search : ------");
        System.out.println("\nOriginal Array : ");

        Arrays.sort(x);
        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("Enter element to search : ");
        int d = Integer.parseInt(br.readLine());

        int pos = jumpSearchAlgo(x,d);

        System.out.println("Position is :  "+pos);
    }

    private int jumpSearchAlgo(int x[], int val){

        int n = x.length;
        int m = (int)Math.floor(Math.sqrt(n));

        int preBlock = 0;

        while(x[Math.min(m,n)-1] < val){
            preBlock = m;
            m = m*2;
        }

        while(x[preBlock] < val){

            preBlock++;
            if(preBlock == Math.min(m,n))
                return -1;
        }

        if(val == x[preBlock])
            return preBlock + 1;

        return -1;
    }

}