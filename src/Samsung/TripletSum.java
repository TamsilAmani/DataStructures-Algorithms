package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TripletSum {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String st[] = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int x = Integer.parseInt(st[1]);

            st = br.readLine().split(" ");
            int ar[] = new int[n];
            int index=0;
            for(String y: st)
                ar[index++] = Integer.parseInt(y);


            Arrays.sort(ar);
            boolean f=false;
            for(int i=0; i<n-2;i++){

                int l = i+1;
                int r = n-1;
                f = false;

                while(l<r){

                    if((ar[i]+ar[l]+ar[r])==x){
                        f=true;
                        break;
                    }

                    else if((ar[i]+ar[l]+ar[r])>x){
                        r--;
                    }
                    else
                        l++;

                }

                if(f)
                    break;


            }
            if(f)
                System.out.println("1");
            else
                System.out.println("0");



        }
    }
}
