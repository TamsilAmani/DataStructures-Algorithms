package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leaders {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String st[] = br.readLine().split(" ");
            int array[] = new int[n];

            for(int i=0; i<n;i++)
                array[i] = Integer.parseInt(st[i]);

            StringBuffer sb = new StringBuffer();

            int max = Integer.MIN_VALUE;

            for(int i=n-1; i>=0; i--){
                if(array[i]>=max){
                    sb.insert(0,array[i]+" ");
                    max = array[i];
                }
            }

            System.out.println(sb);
        }
    }
}
