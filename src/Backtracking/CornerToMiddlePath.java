package src.Backtracking;

public class CornerToMiddlePath {
    static int N = 9;
    static int res[][] = new int[2][N*N];
    static  int index=1;


    public static void main(String args[]){
        int maze[][] =
        {
            { 3, 5, 4, 4, 7, 3, 4, 6, 3 },
            { 6, 7, 5, 6, 6, 2, 6, 6, 2 },
            { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
            { 6, 5, 5, 1, 2, 3, 6, 5, 6 },
            { 3, 3, 4, 3, 0, 1, 4, 3, 4 },
            { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
            { 3, 5, 4, 3, 2, 6, 4, 4, 3 },
            { 3, 5, 1, 3, 7, 5, 3, 6, 4 },
            { 6, 2, 4, 3, 4, 5, 4, 5, 1 }
        };

        solveCToMPath(maze);
    }

    static void solveCToMPath(int maze[][]){

        int sol[][]= {{1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}};



        int x_mov[] = {-1,1,0,0};
        int y_mov[] = {0,0,-1,1};


        for(int i=0; i<2; i++)
            for(int j=0;j<N;j++)
                res[i][j]=-1;

        res[0][0]=0;
        res[1][0]=0;

        if(backtrack(0,0,maze,x_mov,y_mov,sol))
            printSol(res);
        else
            System.out.println("Not Possible");
    }

    static boolean backtrack(int x, int y, int maze[][], int x_mov[], int y_mov[],int sol[][]){

        if(x==4 && y==4){
            return true;
        }

        for(int k = 0; k<4; k++){
            int next_x = x+(maze[x][y]*x_mov[k]);
            int next_y = y+(maze[x][y]*y_mov[k]);


            if(isSafe(next_x,next_y,sol)){
                //
                sol[next_x][next_y]=1;

                //System.out.println("inndex = "+index);
                res[0][index] = next_x;
                res[1][index] = next_y;
                index++;

                if(backtrack(next_x,next_y,maze,x_mov,y_mov,sol))
                    return true;

                else {
                    //System.out.println(next_x + " " + next_y);
                    sol[next_x][next_y] = 0;
                    index--;
                    res[0][index] = -1;
                    res[1][index] = -1;
                }
            }
        }
        return false;

    }

    static boolean isSafe(int x, int y,int sol[][]){
        //System.out.println(x+" "+y+"\n"+(x>=0 && x<N && y>=0 && y<N));
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==0);
    }

    static void printSol(int res[][]) {
        for (int j = 0; j < N*N; j++) {
            if (res[0][j] != -1)
                System.out.print("(" + res[0][j] + "," + res[1][j] + ") -> ");
            else break;

        }
        System.out.println("MID");
    }
}
