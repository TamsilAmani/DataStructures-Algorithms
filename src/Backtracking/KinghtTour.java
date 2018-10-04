package src.Backtracking;

public class KinghtTour {
    static int N = 8;

    public static void main(String args[]){
        solveKTP();
    }

    static void solveKTP(){
        int sol[][] = new int[N][N];

        for(int i=0;i<N;i++)
            for(int j=0; j<N;j ++)
                sol[i][j] = -1;

        sol[0][0] = 0;

        //int x_mov[] = {2, 2, -2, -2, 1, -1, 1, -1};
        //int y_mov[] = {1, -1, 1, -1, 2, 2, -2, -2};

        int x_mov[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int y_mov[] = {1, 2, 2, 1, -1, -2, -2, -1};

        if(backtrack(0,0,sol,x_mov,y_mov,1))
            printSol(sol);
        else
            System.out.println("Not Possible");

    }


    static boolean backtrack(int x ,int y, int sol[][], int x_mov[], int y_mov[], int movi){

        if(movi == N*N) {
            //System.out.println("Here");
            return true;
        }

        for( int k = 0; k<8; k++){
             int next_x = x + x_mov[k];
             int next_y = y + y_mov[k];

            if(isSafe(next_x,next_y, sol)){
                sol[next_x][next_y] = movi;

                if(backtrack(next_x,next_y, sol, x_mov, y_mov,movi+1))
                    return true;
                else
                    sol[next_x][next_y] = -1;
            }
        }
        return false;
    }

    static boolean isSafe(int x, int y, int sol[][]){

        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
    }

    static void printSol(int sol[][]){
        for(int i = 0; i < N; i++){
            for(int j = 0; j< N ; j++)
                System.out.print(sol[i][j]+ " ");
            System.out.println();
        }

    }
}
