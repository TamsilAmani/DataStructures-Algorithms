package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Count_distinct {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String st[] = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1])-1;

            int ar[] = new int[n];
            st = br.readLine().split(" ");

            for(int i=0;i<n;i++)
                ar[i] = Integer.parseInt(st[i]);

            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0; i<=k ;i++){
                if(map.containsKey(ar[i])){
                    map.put(ar[i],map.get(ar[i])+1);
                }
                else
                    map.put(ar[i],1);
            }

            System.out.print(map.size()+" ");

            for(int i= 1; (n-1)-i >=k; i++){
                if(map.get(ar[i-1])==1)
                    map.remove(ar[i-1]);
                else
                    map.put(ar[i-1],map.get(ar[i-1])-1);

                int key = ar[i+k];

                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }
                else
                    map.put(key,1);

                System.out.print(map.size()+" ");
            }

        }
    }
}
