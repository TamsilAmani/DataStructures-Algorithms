package src.GreedyAlgorithms;

import java.lang.*;

class ActivitySelection
{

    public static void printMaxActivities(int s[], int f[], int n)
    {
        int i, j;

        System.out.print("Following activities are selected : \n");


        i = 0;
        System.out.print(i+" ");

        for (j = 1; j < n; j++)
        {

            if (s[j] >= f[i])
            {
                System.out.print(j+" ");
                i = j;
            }
        }
    }

    // driver program to test above function
    public static void main(String[] args)
    {
        int start[] =  {1, 3, 0, 5, 8, 5};
        int finish[] =  {2, 4, 6, 7, 9, 9};
        int n = start.length;

        printMaxActivities(start, finish, n);
    }
}