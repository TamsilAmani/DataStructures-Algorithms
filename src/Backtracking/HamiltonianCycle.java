package src.Backtracking;

public class HamiltonianCycle {
    static int V = 5;

    public static void main(String args[]){

        int graph[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        solveHamiltonian(graph);
    }

    static void solveHamiltonian(int graph[][]){
        int path[] = new int[V];

        for(int i=0; i<V; i++)
            path[i] = -1;


        path[0] = 0;

        if(backtrack(graph,path,1))
            printPath(path);
        else
            System.out.println("Not Possible");
    }

    static boolean backtrack(int graph[][], int path[], int pos){
        if(pos==V){
            if(graph[path[pos-1]][0]==1)
                return true;
            else
                return false;
        }

        for(int v = 1; v<V; v++){

            if(isSafe(v,graph,path,pos)){
                path[pos] = v;
                if(backtrack(graph,path,pos+1))
                    return true;
                else
                    path[pos]=-1;
            }
        }
        return false;
    }

    static boolean isSafe(int v , int graph[][], int path[], int pos){

        if(graph[path[pos-1]][v]==0)
            return false;

        for(int i = 0 ;i<pos;i++){
            if(path[i]==v)
                return false;
        }

        return true;
    }

    static void printPath(int path[]){
        for(int x : path)
            System.out.print(x+" ");
        System.out.print(path[0]);
    }
}
