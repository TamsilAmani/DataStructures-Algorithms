package src.Graphs;

public class AllPossiblePaths {
    static int vertex = 4;
    static int result=0;
    public static void main(String args[]){
        int matrix[][] = {
                {0,1,1,1},
                {0,0,0,1},
                {1,1,0,1},
                {0,0,0,0}
        };

        int start = 0;
        int end = 3;

        solveALPaths(matrix,start,end);
    }

    static void solveALPaths(int matrix[][], int start, int end){

        boolean visited[] = {false,false,false,false};

        backtrack(matrix,start,end,visited);
        System.out.println(result);
    }

    static void backtrack(int matrix[][], int s, int e,boolean visited[]){
        visited[s] = true;
        if(s==e){
            result++;
        }

        for(int i = 0 ; i < vertex ; i++){
            if(matrix[s][i]==1 && visited[i]==false)
                backtrack(matrix,i,e,visited);
        }
        visited[s]=false;
    }
}
