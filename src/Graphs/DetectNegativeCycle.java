package src.Graphs;

public class DetectNegativeCycle {
    static int vertex = 4;
    public static void main(String args[]){
        int mat[][]={
                {0,-2,0,0},
                {0,0,2,0},
                {0,0,0,2},
                {1,0,0,0}
        };

        solveDNCycle(mat);
    }

    static void solveDNCycle(int mat[][]){
        boolean visited[] = new boolean[vertex];
        int dist[] = new int[vertex];
        boolean result=false;

        for(int i=0;i<vertex;i++){
            if(visited[i]==false){
                if(detectCycle(mat,i,dist)) {
                    result = true;
                }
            }

            for(int j=0;j<vertex;j++){
                if(dist[j]!=Integer.MAX_VALUE) {
                    visited[j] = true;
                }
            }
        }

        System.out.println(result);
    }

    static boolean detectCycle(int mat[][], int u, int dist[]){

        for(int i=0;i<vertex;i++)
            dist[i]= Integer.MAX_VALUE;
        dist[u] = 0;

        for(int i = 1; i < vertex ; i++){

            for(int j=0; j < vertex ; j++){
                for(int k = 0; k < vertex ; k++){
                    if(mat[j][k]!=0){

                            if(dist[j]!=Integer.MAX_VALUE && dist[k] > (dist[j]+mat[j][k]))
                                dist[k]= dist[j]+mat[j][k];


                    }
                }
            }

        }


        for(int i=0; i< vertex; i++){
            for(int j=0; j< vertex;j++){
                if(mat[i][j]!=0){
                    if(dist[i]!=Integer.MAX_VALUE && dist[j]>dist[i]+mat[i][j])
                        return true;
                }
            }
        }
        return false;
    }
}
