package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SikSets {
    static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t[] = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int l = Integer.parseInt(t[1]);
        int r = Integer.parseInt(t[2]);
        int x = Integer.parseInt(t[3]);

        int ar[] = new int[n];

        t = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            ar[i] = Integer.parseInt(t[i]);
        Arrays.sort(ar);

        boolean visited[] = new boolean[n];
        backtrack(ar,visited,n,l,r,x,0);
        System.out.println(count);

    }

    static void backtrack(int ar[], boolean visited[], int n, int l, int r, int x, int u){
        if(u==n)
            return;

        visited[u] = true;
        checkIf(ar,visited,l,r,x);
        backtrack(ar, visited, n, l, r, x, u+1);
        visited[u]=false;
        backtrack(ar,visited,n,l,r,x,u+1);
    }

    static void checkIf(int ar[], boolean visited[],int l, int r, int x){
        int sum=0;
        for(int i=0;i<ar.length;i++){
            if(visited[i])
                sum+=ar[i];
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

        if((sum >= l) && (sum<=r) && (ar[posr]-ar[posl]) >=x)
            count++;

    }
}
