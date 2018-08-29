import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class Sorting {

    int arr[];
    static int n;

    private Sorting() {
        arr = new int[n];
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of test cases :");
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0 ){
            System.out.println("Enter array length: ");
            n = Integer.parseInt(br.readLine());

            Sorting obj = new Sorting();

            //Calling Selection Sort
            obj.generateArray();
            obj.selectionSort(obj.arr);

            //Calling Bubble Sort
            obj.generateArray();
            obj.bubbleSort(obj.arr);

            //Calling Insertion Sort
            obj.generateArray();
            obj.insertionSort(obj.arr);

            //Calling Quick Sort
            obj.generateArray();
            obj.quickSort(obj.arr);

            //Calling Merge Sort
            obj.generateArray();
            obj.mergeSort(obj.arr);

            //Calling Counting Sort
            //obj.generateArray();
            //obj.countingSOrt(obj.arr);
        }
    }

    // Generate Array
    private void generateArray(){
        Random rand = new Random();

        for(int i=0; i<n; i++)
            arr[i] = rand.nextInt(1000)+1;
    }

    // Selection Sort
    private void selectionSort(int x[]){

        System.out.println("\n-----Sorting via Selection Sort : ------");
        System.out.println("\nOriginal Array : ");

        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("\nSorted Array : ");
        int l = x.length;

        for(int i=0; i<l-1 ; i++){
            int pos = i;
            int smallest = x[i];

            for(int j=i+1; j<l ;j++){
                if(smallest>x[j]){
                    smallest = x[j];
                    pos = j;
                }
            }

            if(pos != i){
                int temp = x[i];
                x[i] = x[pos];
                x[pos] = temp;
            }
        }

        for(int y : x)
            System.out.print(y+" ");
        System.out.println();

    }

    // Bubble Sort
    private void bubbleSort(int x[]){
        System.out.println("\n\n-----Sorting via Bubble Sort : ------");
        System.out.println("\nOriginal Array : ");

        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("\nSorted Array : ");
        int l = x.length;

        for(int i=0; i<l-1 ; i++){

            for(int j=0; j<l-1 ;j++){
                if(x[j] > x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }

        for(int y : x)
            System.out.print(y+" ");
        System.out.println();
    }

    // Insertion Sort
    private void insertionSort(int x[]){

        System.out.println("\n\n-----Sorting via Insertion Sort : ------");
        System.out.println("\nOriginal Array : ");

        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("\nSorted Array : ");
        int l = x.length;

        for(int i=1; i<l ; i++) {

            int temp = x[i];
            int j = i - 1;

            while (j>=0 && temp < x[j]) {
                x[j + 1] = x[j];
                j--;
            }

            x[j + 1] = temp;
        }

        for(int y : x)
            System.out.print(y+" ");
        System.out.println();
    }

    // Quick Sort
    private void quickSort(int x[]){
        System.out.println("\n\n-----Sorting via Quick Sort : ------");
        System.out.println("\nOriginal Array : ");

        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("\nSorted Array : ");
        int l = x.length;

        QuickSortAlgo(x,0,l-1);

        for(int y : x)
            System.out.print(y+" ");
        System.out.println();

    }

    private void QuickSortAlgo(int x[], int start, int end){
        if(start < end){
            int pivot = findPivot(x,start,end);
            QuickSortAlgo(x,start, pivot-1);
            QuickSortAlgo(x,pivot+1, end);
        }

    }

    private int findPivot(int x[], int start, int end){

        int piv = start;
        int left = start;
        int right = end;

        while(left<=right){

            if(piv == left && left!=right){

                if(x[piv] > x[right]){
                    int temp = x[piv];
                    x[piv] = x[right];
                    x[right] = temp;
                    piv = right;
                }
                else
                    right--;

            }

            else if(piv == right && left!=right) {

                if (x[piv] < x[left]) {
                    int temp = x[piv];
                    x[piv] = x[left];
                    x[left] = temp;
                    piv = left;

                }

                else
                    left++;
            }

            else
                break;
        }

        return piv;
    }


    // Merge Sort
    private void mergeSort(int x[]){
        System.out.println("\n\n-----Sorting via Merge Sort : ------");
        System.out.println("\nOriginal Array : ");

        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("\nSorted Array : ");

        MergeSortAlgo(x);

        for(int y : x)
            System.out.print(y+" ");
        System.out.println();


    }

    private void MergeSortAlgo(int x[]){

        int l = x.length;
        if(l<2)
            return;

        int mid = l/2;
        int left[] = new int[mid];
        int right[] = new int[l-mid];


        for(int i=0; i<mid; i++)
            left[i] = x[i];

        for(int i= mid; i<l; i++)
            right[i-mid] = x[i];

        MergeSortAlgo(left);
        MergeSortAlgo(right);

        Merging(left,right,x);

    }

    private void Merging(int left[], int right[], int x[]){
        int lenL = left.length;
        int lenR = right.length;

        int i=0,j=0,k=0;

        while(i<lenL && j<lenR){
            if(left[i] < right[j]){
                x[k] = left[i];
                i++;
                k++;
            }
            else{
                x[k] = right[j];
                j++;
                k++;
            }
        }

        while(i<lenL){
            x[k] = left[i];
            i++;
            k++;
        }

        while(j<lenR){
            x[k] = right[j];
            j++;
            k++;
        }

    }

    /* Counting Sort
    private void countingSOrt(int x[]){
        System.out.println("\n\n-----Sorting via Counting Sort : ------");
        System.out.println("\nOriginal Array : ");

        for(int y:x)
            System.out.print(y+" ");
        System.out.println();

        System.out.println("\nSorted Array : ");

        int max = x[0], min = x[0];
        int l = x.length;

        for(int i=1; i<l; i++){
            if(x[i]<min)
                min = x[i];
            else if( x[i] > max)
                max = x[i];
        }



        int index[] = new int[lengthOfTempArrays];
        int count[] = new int[lengthOfTempArrays];

        for




    }
    */
}
