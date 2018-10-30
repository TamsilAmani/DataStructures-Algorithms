package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpecificOrderSort {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String tt[] = br.readLine().split(" ");
            int n = Integer.parseInt(tt[0]);

            int ar[] = new int[n];

            String st[] = br.readLine().split(" ");

            for(int i=0;i<n;i++){
                ar[i] = Integer.parseInt(st[i]);
            }

            Arrays.sort(ar);


            for(int i=n-1;i>=0;i--) {
                if (ar[i]%2!=0)
                    System.out.print(ar[i] + " ");
            }

            for(int i=0;i<n; i++){
                if (ar[i]%2==0)
                    System.out.print(ar[i] + " ");
            }

            System.out.println();
        }
    }
}
