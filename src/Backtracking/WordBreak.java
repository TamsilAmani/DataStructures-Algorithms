package src.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordBreak {

    static String dictionary[] = {"mobile","samsung","sam","sung",
            "man","mango", "icecream","and",
            "go","i","love","ice","cream"};


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        solveWordBreak(str);
    }

    static void solveWordBreak(String str){
        backtrack(str,str.length(),"");
    }

    static void backtrack(String str, int n, String result){

        //System.out.println(str);

        for(int i=1;i<=n;i++){

            String prefix = str.substring(0,i);

            if(isSafe(prefix)) {
                //System.out.println("prefix = "+prefix);
                if (i == n) {
                    result += prefix;
                    System.out.println(result);
                }

                backtrack(str.substring(i), n-i, result + prefix + " ");
            }

        }

    }

    static boolean isSafe(String prefix){

        for(int i =0; i < dictionary.length; i++){
            if(dictionary[i].equals(prefix))
                return true;
        }

        return false;

    }
}
