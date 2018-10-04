package src.Backtracking;

public class mColouring {

    static int V = 4;
    public static void main(String args[]){

        int graph[][]= {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
        };

        int m = 2;

        solvemColoring(graph, m);
    }

    static void solvemColoring(int graph[][], int m){

        int color[] = new int[V];

        if(backtrack(graph,m,color,0))
            printGraph(color);
        else
            System.out.println("Not Possible");

    }

    static boolean backtrack(int graph[][], int m, int color[], int v){

        if(v==V)
            return true;

        for(int c = 1; c<=m; c++){
            if(isSafe(graph,v,color,c)){
                color[v] = c;

                if(backtrack(graph,m,color,v+1))
                    return true;
                else
                    color[v] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int graph[][], int v, int color[], int c){
        for(int i=0; i<V; i++){
            if(graph[v][i]==1 && color[i]==c)
                return false;
        }
        return true;
    }

    static void printGraph(int color[]){
        for(int x: color)
            System.out.print(x+" ");
    }
}
