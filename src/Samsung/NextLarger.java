package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

public class NextLarger {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String st[] = br.readLine().split(" ");
            int ar[] = new int[n];
            int i=0;
            for(String x : st)
                ar[i++] = Integer.parseInt(x);

            Arrays.sort(ar);

            for(i=1;i<ar.length;i++)
                ar[i-1] = ar[i];

            ar[i-1]=-1;

            for(int x:ar)
                System.out.print(x+" ");



        }

    }
}
