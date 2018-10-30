package Sudo_Placement_Geeksforgeeks.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maximum_Of_All_Subarray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String st[] = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]) - 1;

            int ar[] = new int[n];
            st = br.readLine().split(" ");

            for (int i = 0; i < n; i++)
                ar[i] = Integer.parseInt(st[i]);


            TreeMap<Integer,Integer> map = new TreeMap<>();

            for(int i=0; i<=k ;i++){
                if(map.containsKey(ar[i])){
                    map.put(ar[i],map.get(ar[i])+1);
                }
                else
                    map.put(ar[i],1);
            }

            System.out.print(map.lastKey()+" ");

            for(int i= 1; (n-1)-i >=k; i++){
                map.remove(ar[i-1]);

                int key = ar[i+k];

                if(map.containsKey(key)){
                    continue;
                }
                else
                    map.put(key,1);

                System.out.print(map.lastKey()+" ");
            }

            System.out.println();

        }
    }

}
