package src.Graphs;

public class TransitiveClosure {
    static int vertex = 4;
    public static void main(String args[]){
        int matrix[][] = {
                {0,1,1,0},
                {0,0,1,0},
                {1,0,0,1},
                {0,0,0,1}
        };

        solveClosure(matrix);
    }

    static void solveClosure(int matrix[][]){

        int sol[][]={
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        for(int i=0;i<vertex;i++){
            DFSUntil(matrix,sol,i,i);
        }

        printSol(sol);

    }

    static void DFSUntil(int matrix[][],int sol[][], int u, int v){
        sol[u][v] = 1;

        for(int i = 0; i<vertex;i++){
            if(matrix[v][i]==1 && sol[u][i]==0){
                //System.out.println(matrix[u][i]+" "+sol[u][i]);
               // printSol(sol);
                DFSUntil(matrix,sol,u,i);
            }
        }

    }

    static void printSol(int sol[][]){
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++)
                System.out.print(sol[i][j]);
            System.out.println();
        }
    }
}