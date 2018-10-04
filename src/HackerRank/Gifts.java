package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Gifts {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //String t[] = br.readLine().split(" ");

        long n = sc.nextInt();
        int m = sc.nextInt();

        Map<Long, Integer> map = new TreeMap<>();
        //-----------------------------------

        for (int i = 0; i < m; i++) {
                long d = sc.nextLong();

                if(map.containsKey(d))
                    map.put(d, map.get(d) + 1);
                else
                    map.put(d,1);
        }

        System.out.println(map);

        int diff = 0;
        int min = Integer.MAX_VALUE;


        for(Map.Entry<Long,Integer> ent : map.entrySet()){
            

        }






        if (cnt != 0)
            System.out.println(cnt);

        else {
            for(Map.Entry<Long,Integer> ent : map.entrySet()){
                if(ent.getValue() == min){
                    cnt++;
                }
            }

            System.out.println(cnt);

        }
    }

}
