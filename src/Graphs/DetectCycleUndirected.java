package src.Graphs;

public class DetectCycleUndirected {
    static int vertex = 3;
    public static void main(String args[]){
        int mat[][] = {
                {0,1,0},
                {0,0,1},
                {0,0,0}

        };

        solveDCU(mat);
    }

    static void solveDCU(int mat[][]){
        boolean visited[] = new boolean[vertex];
        boolean result = false;

        for(int i=0; i<vertex; i++){
            if(!visited[i]){
                if(backtrack(mat,visited,i,-1)){
                    result = true;
                    break;
                }
            }
        }
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static boolean backtrack(int mat[][], boolean visited[], int u, int parent){

        visited[u]=true;

        for(int i=0; i<vertex; i++){
            if(mat[u][i]==1){
                if(!visited[i]){
                    if(backtrack(mat,visited,i,u))
                        return true;
                }
                else if(i!=parent)
                    return true;
            }
        }
        return false;
    }
}
