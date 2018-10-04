package src.Backtracking;

public class Sudoku {
    static int N = 9;


    public static void main(String args[]){
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        solveSudoku(grid);
    }

    static void solveSudoku(int grid[][]){

        if(backtrack(grid))
            printGrid(grid);
        else {
            System.out.println("Not Possible");
            //System.out.println("row = " + row + "  col=" + col);
        }
    }

    static boolean backtrack(int grid[][]) {

        //printGrid(grid);
        //System.out.println("\n");

        int l[] = {0,0};

        if (!findUnassigned(grid,l))
            return true;

        int row= l[0];
        int col = l[1];

        for (int i = 1; i <= 9; i++) {
                if (isSafe(grid, row, col, i)) {
                    grid[row][col] = i;

                    if (backtrack(grid))
                        return true;
                    else
                        grid[row][col]=0;
                }
        }

        return false;
    }

    static boolean findUnassigned(int grid[][],int l[]){

        for(int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {

                if (grid[row][col] == 0) {
                    l[0] = row;
                    l[1] = col;
                    //System.out.println("row = " + row + "  col=" + col);
                    return true;
                }
            }
        }

        //System.out.println("Here");
        return false;

    }



    static boolean isSafe(int grid[][], int rowt, int colt, int x){

        for(int i = 0; i<N; i++){
            if(grid[rowt][i]==x)
                return false;
        }

        for(int i=0; i<N; i++){
            if(grid[i][colt]==x)
                return false;
        }

        for(int i=0; i<3; i++){
            for(int j=0 ;j<3; j++){
                if(grid[i+(rowt-(rowt%3))][j+(colt-(colt%3))] == x)
                    return false;
            }
        }

        return true;

    }

    static void printGrid(int grid[][]){
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++)
                System.out.print(grid[i][j]+" ");
            System.out.println();
        }
    }
}
