package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntToDoubleFunction;

public class NextLarger {
    static boolean f =false;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            f=false;
            int n = Integer.parseInt(br.readLine());

            char ar[] = Integer.toString(n).toCharArray();
            Arrays.sort(ar);

            int m = findNextLarge(ar, n);

            if (m == n)
                System.out.println("not possible");
            else
                System.out.println(m);
        }
    }

    static int findNextLarge(char ar[], int n) {

        Map<Character, Integer> map = new TreeMap<>();

        for (char x : ar) {
            map.compute(x, (key, value) -> {
                if (value == null)
                    return 1;
                else
                    return value + 1;
            });
        }

        char keyar[] = new char[ar.length];
        int count[] = new int[ar.length];
        char result[] = new char[ar.length];

        int index = 0;
        for (Map.Entry<Character, Integer> me : map.entrySet()) {

            keyar[index] = me.getKey();
            count[index] = me.getValue();
            index++;

        }
        int y = computeNum(keyar, count, result, 0, n);
        //System.out.println("y="+y);
        return y;
    }

    static int computeNum(char keyar[], int count[], char result[], int l, int n){

            if(l==result.length){
                if(Integer.parseInt(new String(result)) > n)
                    f=true;

            }


            for (int i = 0; i < keyar.length; i++) {


                if (count[i] == 0)
                    continue;

                result[l] = keyar[i];
                count[i]--;
                computeNum(keyar, count, result, l + 1, n);
                if(f)
                    return Integer.parseInt(new String(result));



                count[i]++;

            }

            return n;

    }

}
