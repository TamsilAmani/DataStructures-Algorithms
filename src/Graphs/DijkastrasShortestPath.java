package src.Graphs;

public class DijkastrasShortestPath {
    static int vertex;
    public static void main(String args[]){

        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        vertex = graph.length;

        int start = 0;

        solveDSPath(graph,start);
    }

    static void solveDSPath(int graph[][], int start){

        int dist[] = new int[vertex];
        for(int i=0;i<vertex; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[start] = 0;

        boolean spSet[] = new boolean[vertex];

        for(int i=1;i<vertex;i++){

            int u = findMin(dist,spSet);
            spSet[u] = true;

            for(int v=0; v<vertex;v++){
                if(graph[u][v]!=0 && spSet[v]==false && dist[u]!=Integer.MAX_VALUE && (dist[v] > dist[u]+graph[u][v]))
                    dist[v] = dist[u]+graph[u][v];
            }

        }

        for(int x : dist)
            System.out.println(x);
    }

    static int findMin(int dist[], boolean spSet[]){
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i=0; i<vertex;i++){
            if(dist[i]<min && spSet[i]==false){
                min = dist[i];
                pos = i;
            }
        }
        return pos;
    }
}
