package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Replace {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String st = br.readLine();
            char ar[] = st.toCharArray();

            String ans="";
            int i,j;
            for(i=0,j=1; j<st.length();){

                if(ar[i]!=ar[j]) {
                    ans=ans+ar[i]+ar[j];
                    i=j+1;
                    j=j+2;

                }

                else{
                    j++;
                    //ans = ans + ar[i];
                }

            }
            if(ar[i]!= ans.charAt(ans.length()-1))
                ans=ans+ar[i];

            System.out.print(ans);

        }
    }
}
