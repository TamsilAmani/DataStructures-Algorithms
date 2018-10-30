package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Closest_Number {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String st[] = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);

            int ar[] = new int[n];
            st = br.readLine().split(" ");

            for(int i=0; i<n ;i++)
                ar[i] = Integer.parseInt(st[i]);

            boolean found = false;

            //System.out.print(Arrays.binarySearch(ar,k));


            if(Arrays.binarySearch(ar,k) >=0) {
                System.out.println(ar[Arrays.binarySearch(ar,k)]);
            }


            else {
                int pos = n - 1;
                int diff = Math.abs(ar[n - 1] - k);

                for (int i = n - 1; i >= 0; i--) {
                    if (Math.abs(ar[i] - k) < diff) {
                        pos = i;
                        diff = Math.abs(ar[i] - k);
                    }
                }

                if((pos+1)<n && Math.abs(ar[pos+1]-k)==Math.abs(ar[pos]-k))
                    System.out.println(ar[pos + 1]);
                else
                    System.out.println(ar[pos]);

            }


        }
    }
}
