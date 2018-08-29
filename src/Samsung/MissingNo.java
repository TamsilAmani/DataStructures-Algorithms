package Samsung ;//do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MissingNo {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){

            int n = Integer.parseInt(br.readLine())-1;
            String st[] = br.readLine().split(" ");

            int ar[] = new int[n];
            int index=0;

            for(String x:st)
                ar[index++] = Integer.parseInt(x);

            Arrays.sort(ar);

            //for(int x :ar)
                //System.out.print(x+ " ");


            if(ar[0]!=1)
                System.out.println("1");
            else{
                boolean f =false;
                for(int i=1;i<n;i++){
                    if(ar[i] != (ar[i-1]+1)){
                        System.out.println((ar[i]-1));
                        f=true;
                        break;
                    }

                }
                if(!f)
                    System.out.println(n+1);
            }

        }

    }
}