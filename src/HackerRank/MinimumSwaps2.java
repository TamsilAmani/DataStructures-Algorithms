package src.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumSwaps2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String st[] = br.readLine().split(" ");
        int ar[] = new int[n];
        int cnt=0;
        for (int i = 0; i < n; i++)
            ar[i] = Integer.parseInt(st[i]);

        for(int i =0 ; i<n-1;i++){
            int pos = i;
            int min = ar[i];

            for(int j=i+1; j<n;j++){
                if(ar[j]<min){
                    min = ar[j];
                    pos= j;
                }
            }

            if(pos!=i){
                cnt++;
                int temp = ar[i];
                ar[i] = ar[pos];
                ar[pos] = temp;
            }
        }
        System.out.println(cnt);
    }
}
