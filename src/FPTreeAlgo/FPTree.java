package src.FPTreeAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FPTree {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Support");
        int support = Integer.parseInt(br.readLine());
        System.out.println("Enter Number of Transactions");
        int n = Integer.parseInt(br.readLine());

        List<List<String>> list = new ArrayList<>();

        for(int i=0; i < n ;i++){

            ArrayList<String> temp = new ArrayList<>();
            String t[] = br.readLine().split(" ");
            int l = 0;
            while(l < t.length){
                temp.add(t[l]);
                l++;
            }
            list.add(temp);
        }

        System.out.println(list.size());

        //------------ Input Taken----------------

        Map<String,Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){

            for(int j=0; j<list.get(i).size(); j++){
                String key = list.get(i).get(j);
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+1);
                }
                else
                    map.put(key,1);
            }
        }

        //System.out.println(map);

        //-------- Map Made------------

        map = sortedMap(map);

        System.out.println("Old Map : "+map);

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()){
            if(map.get(it.next())<3)
                it.remove();
        }

        System.out.println("Renewed Map : " + map);

        //------------- First Set DONE!!!!!------------

        List<List<String>> orderList = new ArrayList<>();

        for(int i=0; i<n ; i++){

            List<String> temp = new ArrayList<>();

            it = map.keySet().iterator();



            while(it.hasNext()){
                String key = it.next();
                if(list.get(i).contains(key)) {
                    temp.add(key);
                }
            }

            orderList.add(temp);
        }

        System.out.println("Ordered List : "+ orderList);

    }

    static HashMap<String,Integer> sortedMap(Map<String,Integer> hm){
        List<Map.Entry<String,Integer>> lt = new LinkedList<>(hm.entrySet());

        Collections.sort(lt, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> stringIntegerEntry, Map.Entry<String, Integer> t1) {
                return t1.getValue().compareTo(stringIntegerEntry.getValue());
            }
        });
        HashMap<String,Integer> temp = new LinkedHashMap<>();

        for(Map.Entry<String,Integer> ent : lt){
            temp.put(ent.getKey(),ent.getValue());
        }
        return temp;
    }


}
