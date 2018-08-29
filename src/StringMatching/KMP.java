package StringMatching;

import java.util.*;
import java.io.*;

class KMP {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Text = br.readLine();
        String Pattern = br.readLine();

        char T[] = Text.toCharArray();
        char P[] = Pattern.toCharArray();

        int n = T.length;
        int m = P.length;
        //int pi[] = new int[P.length];

        int pi[] = preProcess(P);

        for(int x: pi)
            System.out.print(x);
        System.out.println();

        int q=0;
        for(int i=0;i<n;i++){

            while(q>0 && P[q]!=T[i])
                q=pi[q-1];

            if(P[q]==T[i])
                q=q+1;

            if(q==m){
                System.out.println("Pattern found at "+((i-m)+1));
                q=pi[q-1];
            }


        }

    }

    private static int[] preProcess(char P[]) {
        int pi[] = new int[P.length];

        pi[0] = 0;
        int j = 0;

        for (int i = 1; i < pi.length;) {

            if(P[i]==P[j]){
                pi[i] = j+1;
                j++;
                i++;
            }

            else{
                if(j!=0){
                    j= pi[j-1];
                }
                else
                    pi[i]=0;

                i++;
            }

        }
        return pi;
    }
}
