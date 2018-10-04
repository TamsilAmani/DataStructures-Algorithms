package src.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LCS {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        char one[] = a.toCharArray();
        char two[] = b.toCharArray();

        System.out.println("Length of LCS = "+computeLCS(one,two,one.length, two.length));
    }

    static int computeLCS(char one[], char two[], int m, int n){

        int array[][] = new int[m+1][n+1];

        for(int i=0; i<=m;i++){
            for(int j=0; j<=n; j++){

                if(i==0 || j==0)
                    array[i][j] = 0;

                else{
                    if(one[i-1]==two[j-1])
                        array[i][j] = 1+array[i-1][j-1];
                    else
                        array[i][j] = Math.max(array[i-1][j], array[i][j-1]);

                }

            }
        }

        //printLCS(array,m,n);

        return array[m][n];

    }

    /*static void printLCS(int array[], int m, int n){

        Stack<Integer> st = new Stack<>();

        for(int i=m; i>0; i--){
            for(int j=n; j>0; j--){
                if()
            }
        }

    }*/
}
