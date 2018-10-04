package src.CodeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PRISTG {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int  count=0;
        for(int i=0; i<A.length(); i++){
            for(int j=i+1; j<=A.length(); j++){
                if(BcontainsA(A.substring(i,j),B))
                    count++;
            }
        }
        System.out.println(count);
    }

    static boolean BcontainsA(String A, String B){
        if(B.contains(A))
            return true;
        else
            return false;
    }
}
