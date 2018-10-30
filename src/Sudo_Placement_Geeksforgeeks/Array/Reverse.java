package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String st[] = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);

            st = br.readLine().split(" ");

            String temp[] = new String[n];

            int ll = 0;
            int ul = ll+k-1;
            int c =0;
            while(ul<n){
                for(int i = ul; i>=ll ; i--){
                    temp[c] = st[i];
                    c++;
                }

                ll=ul+1;
                ul=ll+k-1;
            }

            if(ul != (n-1)){
                ul = n-1;

                for(int i = ul; i>=ll ; i--){
                    temp[c] = st[i];
                    c++;
                }

            }

            for(String x : temp)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}
