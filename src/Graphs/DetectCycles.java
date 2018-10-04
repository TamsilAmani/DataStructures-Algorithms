package src.Graphs;

import java.util.PrimitiveIterator;

public class DetectCycles {

    static int vertex = 4;
    public static void main(String args[]){
        int mat[][] = {
                {0,1,1,0},
                {0,0,1,0},
                {1,0,0,1},
                {0,0,0,1}
        };

        solveDCycles(mat);
    }

    static void solveDCycles(int mat[][]){
        boolean visited[] = new boolean[vertex];
        boolean recStack[] = new boolean[vertex];

        boolean result = false;

        for(int i=0;i<vertex;++i){

                if (backtrack(mat, visited, recStack, i)) {
                    result = true;
                    //printStack(recStack);
                }

        }
        if(result)
            System.out.println("YES");
        else
            System.out.println("No Cycle");
    }

    static boolean backtrack(int mat[][],boolean visited[],boolean recStack[], int u){



        if(recStack[u]) {
            //printStack(recStack);
            return true;
        }

        if(visited[u])
            return false;

        recStack[u]=true;
        visited[u] = true;

        for(int i=0; i<vertex; i++){
            if(mat[u][i]==1){
                if(backtrack(mat,visited,recStack,i))
                    return true;
            }
        }

        recStack[u]=false;
        return false;

    }

    static void printStack(boolean recStack[]){
        for(int i=0;i<vertex;i++)
            if(recStack[i]==true)
                System.out.print(i+" ");

        System.out.println();
    }
}
