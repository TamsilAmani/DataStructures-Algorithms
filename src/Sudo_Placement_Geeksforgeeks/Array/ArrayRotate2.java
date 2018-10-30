package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayRotate2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            int d = Integer.parseInt(br.readLine());

            String st[] = br.readLine().split(" ");

            int array[] = new int[n];
            for(int i=0; i< n; i++)
                array[i] = Integer.parseInt(st[i]);

            int temp[] = new int[n];
            int arLen = array.length;
            for(int i = 0; i < arLen; i++){
                int newLocation = (i + arLen - (d%arLen)) % arLen;
                temp[newLocation] = array[i];
            }

            for(int x : temp)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}
