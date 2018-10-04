package src.Graphs;

public class FloydMarshall {
    static int vertex;
    final static int INF = 99999;
    public static void main(String args[]){
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        vertex = graph.length;
        solveFMarshall(graph);
    }

    static void solveFMarshall(int grah[][]){

        int dist[][] = new int[vertex][vertex];
        for(int i=0; i< vertex;i++){
            for(int j=0; j<vertex;j++)
                dist[i][j] = grah[i][j];
        }

        for(int k=0;k<vertex;k++){
            for(int i=0; i<vertex;i++){
                for(int j=0;j<vertex;j++){
                    if(dist[i][k]+dist[k][j]<dist[i][j])
                        dist[i][j] = dist[i][k]+dist[k][j];
                }
            }
        }

        printSol(dist);
    }

    static void printSol(int dist[][]){
        for(int i=0; i< vertex;i++) {
            for (int j = 0; j < vertex; j++)
                System.out.print(dist[i][j]+" ");
            System.out.println();
        }
    }
}
