package src.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Cryptarithmetic {
    static boolean use[] = new boolean[10];
    static int count;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char first[] = br.readLine().toCharArray();
        char second[] = br.readLine().toCharArray();
        char sum[] = br.readLine().toCharArray();

        solveCrpytarithmetic(first,second,sum);
    }

    static void solveCrpytarithmetic(char first[], char second[], char sum[]){
        Map<Character,Integer> map = new TreeMap<>();

        for(int i=0; i<first.length;i++){
            if(map.containsKey(first[i]))
                map.put(first[i], map.get(first[i])+1);
            else
                map.put(first[i],1);
        }

        for(int i=0; i<second.length;i++){
            if(map.containsKey(second[i]))
                map.put(second[i], map.get(second[i])+1);
            else
                map.put(second[i],1);
        }

        for(int i=0; i<sum.length;i++){
            if(map.containsKey(sum[i]))
                map.put(sum[i], map.get(sum[i])+1);
            else
                map.put(sum[i],1);
        }

        count = map.size();

        if(count>10)
            System.out.println("Not Possible");
        else{
            char chars[] = new char[count];

            int answer[] = new int[count];

            for(int i = 0; i<10; i++)
                use[i] = true;

            int index = 0;

            for(Map.Entry<Character,Integer> entry : map.entrySet()) {
                chars[index++] = entry.getKey();
            }

            if(backtrack(chars, first, second, sum, answer, 0))
                printAnswer(answer,chars);
            else
                System.out.println("Not Possible");
        }
    }

    static boolean backtrack(char chars[], char first[], char second[], char sum[], int answer[], int n){

        //printAnswer(answer,chars);

        if(n==count-1){

            for(int i = 0 ; i< 10 ; i++){
                if(use[i] == true){
                    answer[n]=i;

                    if(check(first,second,sum,answer,chars))
                        return true;
                }
            }
            return false;
        }

        for(int i = 0; i<10; i++){

            if(use[i]==true){
                answer[n] = i;
                use[i] = false;

                if(backtrack(chars, first, second, sum, answer, n+1))
                    return true;
                else
                    use[i]= true;
            }
        }
        return false;
    }

    static void printAnswer(int answer[], char chars[]){

        for(int i = 0 ; i<count; i++)
            System.out.println(chars[i]+" = "+answer[i]);

    }

    static boolean check(char first[], char second[], char sum[], int answer[], char chars[]){

        int x=0,y=0,z=0;
        int tens=1;

        for(int i = first.length-1; i>=0; i--){
            int j;
            for(j=0; j<count; j++){
                if(chars[j]==first[i])
                    break;
            }

            x = x+ (tens*answer[j]);
            tens*=10;
        }

        tens=1;

        for(int i = second.length-1; i>=0; i--){
            int j;
            for(j=0; j<count; j++){
                if(chars[j]==second[i])
                    break;
            }

             y = y + (tens*answer[j]);
            tens*=10;
        }
        tens=1;

        for(int i = sum.length-1; i>=0; i--){
            int j;
            for(j=0; j<count; j++){
                if(chars[j]==sum[i])
                    break;
            }

            z = z+ (tens*answer[j]);
            tens*=10;
        }

        if((x+y)==z)
            return true;
        else
            return false;
    }
}
