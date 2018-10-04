package src.Graphs;

public class KLengthCycles {
    static int vertex = 5;
    static int count = 0;

    public static void main(String agrs[]){
        int mat[][]={{0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}};

        int n = 4;
        solveKLCycles(mat,n);
    }

    static void solveKLCycles(int mat[][], int n){

        boolean visited[] = new boolean[vertex];

        for(int i = 0 ; i < vertex - (n -1) ; i++){
            detectCycle(mat,visited,n-1,i,i);

            visited[i]=true;
        }
        System.out.println(count/2);
    }

    static void detectCycle(int mat[][], boolean visited[], int len, int start, int end){

        visited[start] = true;

        if(len==0){
            visited[start] = false;

            if(mat[start][end]==1) {
                count++;
                return;
            }
            else
                return;
        }

        for(int i= 0 ; i< vertex; i++){
            if(mat[start][i]==1 && visited[i]==false)
                detectCycle(mat,visited,len-1,i,end);
        }

        visited[start]=false;
    }
}
