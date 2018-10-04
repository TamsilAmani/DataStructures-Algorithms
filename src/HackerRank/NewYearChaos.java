package src.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NewYearChaos {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            String st[] = br.readLine().split(" ");
            int ar[] = new int[n];

            for(int i=0;i<n;i++)
                ar[i] = Integer.parseInt(st[i]);


            int cnt=0;
            boolean flag = true;

            for(int i= ar.length-1; i>=0; i--){

                if((ar[i] - (i+1)) > 2) {
                    flag = false;
                    break;
                }
                for(int j = Math.max(0,ar[i]-2); j<i;j++)
                    if(ar[j]>ar[i])
                        cnt++;

            }
            if(flag)
            System.out.println(cnt);
            else
                System.out.println("Too chaotic");

        }
    }
}
