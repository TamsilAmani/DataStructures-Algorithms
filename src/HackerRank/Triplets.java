package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Triplets {
    static int count=0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t[] = br.readLine().split(" ");

        int n = Integer.parseInt(t[0]);
        BigInteger d = new BigInteger(t[1]);

        BigInteger ar[] = new BigInteger[n];

        t = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            ar[i] = new BigInteger(t[i]);

        boolean visited[] = new boolean[n];
        backtrack(ar,visited,n,d,0);
        System.out.println(count);


    }

    static void backtrack(BigInteger ar[], boolean visited[], int n, BigInteger d, int u){
        if(u==n)
            return;

        visited[u] = true;
        checkIf(ar,visited,n,d);
        backtrack(ar, visited, n, d,u+1);
        visited[u]=false;
        backtrack(ar,visited,n,d,u+1);
    }

    static void checkIf(BigInteger ar[], boolean visited[],int n, BigInteger d){

        int sum=0;
        for(int i=0;i<n;i++){
            if(visited[i])
                sum++;
            if(sum>3)
                return;
        }

        int posl = 0; int posr = ar.length-1;

        for(int i=0;i<ar.length;i++){
            if(visited[i]){
                posl = i;
                break;
            }
        }

        for(int i=ar.length-1;i>=0;i--){
            if(visited[i]){
                posr = i;
                break;
            }
        }

        if(sum==3 && ((ar[posr].subtract(ar[posl])).compareTo(d) <=0))
            count++;
    }


}
