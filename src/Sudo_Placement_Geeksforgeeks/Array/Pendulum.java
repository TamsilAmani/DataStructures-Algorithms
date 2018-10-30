package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pendulum {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int ar[] = new int[n];
            int temp[] = new int[n];

            String st[] = br.readLine().split(" ");

            for(int i=0;i<n;i++)
                ar[i] = Integer.parseInt(st[i]);

            Arrays.sort(ar);

            int right, left;

            if(n%2!=0)
                right=left=n/2;
            else
                right=left = (n-1)/2;

            temp[right]=ar[0] ;
            //System.out.println(ar[0]);
            right++;
            left--;

            boolean f = true;

            for(int i=1; i<n; i++){
                if(f){
                    temp[right]=ar[i];
                    f=false;
                    right++;
                }
                else{
                    temp[left] = ar[i];
                    f=true;
                    left--;
                }
            }

            for(int x: temp)
                System.out.print(x+" ");
            System.out.println();




        }
    }
}
