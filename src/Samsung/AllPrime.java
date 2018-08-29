package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPrime {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean ar[] = new boolean[n+1];

            checkPrime(ar,n);

            int sum=0;
            for(int i=2; i<=n;i++){
                if(ar[i]==true)
                    sum+=i;

            }
            System.out.println(sum);

        }

    }

    static void checkPrime(boolean ar[],int n){

        for(int i=0; i<=n; i++)
            ar[i] = true;

        for(int p=2; p*p<=n; p++){

            if(ar[p]==true) {
                for (int i = p * 2; i <= n; i += p) {
                    ar[i] = false;
                }
            }
        }



    }
}
