package HashMap;

import java.util.HashMap;

public class hashMap {
    public static void main(String args[]){

        HashMap<Integer,Double> map = new HashMap<>();

        map.put(12,45.0);
        map.put(23,60.0);

        System.out.println(map);

        System.out.println(map.get(12));

        System.out.println(map.containsKey(12));

    }
}
