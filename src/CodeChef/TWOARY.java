package src.CodeChef.TWOARY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class TWOARY {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String a[] = br.readLine().split(" ");
        String b[] = br.readLine().split(" ");


        int q = Integer.parseInt(br.readLine());



        while(q>0){
            String t[] = br.readLine().split(" ");
            int o = Integer.parseInt(t[0])-1;
            int p = Integer.parseInt(t[1])-1;


            Map<String,Integer> map1 = new TreeMap<>();
            Map<String,Integer> map2 = new TreeMap<>();

            for(int i = o; i<=p;i++){
                if(map1.containsKey(a[i])){
                    map1.put(a[i],map1.get(a[i])+1);
                }
                else
                    map1.put(a[i],1);

                if(map2.containsKey(b[i])){
                    map2.put(b[i],map2.get(b[i])+1);
                }
                else
                    map2.put(b[i],1);
            }


            int count =0;

            for(Map.Entry<String,Integer> ent : map1.entrySet()){

                String g = ent.getKey();



                if(map1.containsKey(g) && map2.containsKey(g) ) {
                    if((map1.get(g).intValue()==map2.get(g).intValue()) && (map1.get(g).intValue()%2 != 0))
                        count++;
                }
            }

            System.out.println(count);
            q--;
        }

    }
}
