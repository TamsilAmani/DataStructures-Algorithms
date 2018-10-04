package src.Backtracking;

public class NQueens {
    static final int N = 5;

    public static void main(String args[]){

        solve4Queens();
    }

    static void solve4Queens(){
        int sol[][] = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};


        if(backtrack(sol,0))
            printSol(sol);
        else
            System.out.println("Not Possible");
    }

    static boolean backtrack(int sol[][], int col){
        if(col>=N)
            return true;

        for(int i=0 ; i<N; i++){

            if(isSafe(sol,i,col)){
                sol[i][col] = 1;

                if(backtrack(sol,col+1))
                    return true;
                else
                    sol[i][col] = 0;
            }

        }
        return false;
    }

    static boolean isSafe(int sol[][], int row, int col){

        for(int i=0; i<=col; i++) {
            if (sol[row][i] == 1)
                return false;
        }

        for(int i=row, j=col; i>=0 && j>=0; i--,j--){
            if(sol[i][j]==1)
                return false;
        }

        for(int i = row, j=col; i<N && j>=0 ; i++,j--){
            if(sol[i][j]==1)
                return false;
        }

        return true;

    }

    static void printSol(int sol[][]){
        for(int i=0;i<N;i++){
            for(int j=0; j<N; j++)
                System.out.print(sol[i][j]+" ");
            System.out.println();
        }
    }

}
