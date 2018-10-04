package src.Backtracking;

public class RatInAMaze {

    public static void main(String args[]){

        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };


        solveRIAM(maze);

    }

    static void solveRIAM(int maze[][]){

        int sol[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        sol[0][0] = 1;


        int x_move[] = {1,0};
        int y_move[] = {0,1};

        if(backtrack(0,0,sol,maze,x_move,y_move))
            printMaze(sol);
        else
            System.out.println("Not Possible");

    }

    static boolean backtrack(int x, int y, int sol[][], int maze[][], int x_move[], int y_move[]){
        if(x==3 && y==3)
            return true;

        for(int k=0; k<2; k++){
            int next_x = x + x_move[k];
            int next_y = y + y_move[k];

            //System.out.println("next x = "+next_x+"    next_y="+next_y);

            if(isSafe(next_x,next_y,maze)){
                sol[next_x][next_y] = 1;

                if(backtrack(next_x,next_y, sol, maze, x_move, y_move))
                    return true;
                else
                    sol[next_x][next_y] = 0;
            }
        }
        return false;
    }

    static  boolean isSafe(int x ,int y, int maze[][]){
        return (x>=0 && x<4 && y>=0 && y<4 && maze[x][y]==1);
    }

    static void printMaze(int maze[][]){
        for(int i=0; i<4 ;i++){
            for(int j=0; j<4; j++)
                System.out.print(maze[i][j]+ " ");
            System.out.println();
        }
    }
}