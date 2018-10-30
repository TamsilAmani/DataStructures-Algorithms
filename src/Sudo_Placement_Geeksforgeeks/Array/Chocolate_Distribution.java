package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Chocolate_Distribution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String tt[] = br.readLine().split(" ");
            int n = Integer.parseInt(tt[0]);

            int ar[] = new int[n];
            tt = br.readLine().split(" ");

            for(int i=0;i<n;i++)
                ar[i]= Integer.parseInt(tt[i]);

            int m = Integer.parseInt(br.readLine()) - 1;

            Arrays.sort(ar);

            int min = Integer.MAX_VALUE;

            for(int i=0; ((n-1)-i) >= m ; i++){
                if(ar[i+m]-ar[i] < min)
                    min = ar[i+m]-ar[i];
            }

            System.out.println(min);

        }

    }
}
