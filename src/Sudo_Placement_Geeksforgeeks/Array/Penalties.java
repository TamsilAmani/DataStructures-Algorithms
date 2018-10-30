package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Penalties {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String st[] = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);

            int pen[]  = new int[n];
            int no[] = new int[n];

            st = br.readLine().split(" ");
            for(int i=0;i<n;i++)
                no[i] = Integer.parseInt(st[i]);

            st = br.readLine().split(" ");
            for(int i=0;i<n;i++)
                pen[i] = Integer.parseInt(st[i]);

            int sum=0;

            if(k%2==0){

                for(int i=0;i<n;i++){
                    if(no[i]%2!=0)
                        sum += pen[i];
                }

                System.out.println(sum);
            }

            else{
                for(int i=0;i<n;i++){
                    if(no[i]%2==0)
                        sum += pen[i];
                }

                System.out.println(sum);
            }

        }
    }
}
