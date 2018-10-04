package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        double X=0,Y=0;

        while(t-->0){
            int count = 0;
            char str[] = br.readLine().toCharArray();
            for(int i=0;i<str.length;i++){
                if(str[i]=='a' || str[i]=='e' || str[i]=='i' || str[i]=='o' || str[i]=='u')
                    count++;
            }

            if(count%2==0)
                Y++;
            else
                X++;
        }

        DecimalFormat df = new DecimalFormat("0.000000");
        //df.setRoundingMode(RoundingMode.CEILING);

        Double ratio = (X/Y);
        ratio = 1.1111;
        if(ratio<1)
            System.out.print("0");
        System.out.println(df.format(ratio));


    }
}
