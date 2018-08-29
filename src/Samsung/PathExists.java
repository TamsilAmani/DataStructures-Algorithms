package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PathExists {

    static int n;

    static class Node{
        Point pt;
        int dist;

        Node(Point pt, int dist){
            this.pt = pt;
            this.dist = dist;
        }

    }

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String st[] =  br.readLine().split(" ");
            int ar[][] = new int[n][n];

            int index = 0;
            int r=0,c=0;

            for(int i=0; i<n;i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = Integer.parseInt(st[index++]);
                    if(ar[i][j]==1){
                        r=i;
                        c=j;
                    }


                }
            }

            Point p = new Point(r,c);
            int distance = findDist(ar,p);

            System.out.println(distance);

        }
    }

    private static int findDist(int matrix[][], Point p){

        boolean far[][] = new boolean[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n ;j++)
                far[i][j] = false;

        Node nd = new Node(p,0);

        Queue<Node> q = new LinkedList<>();
        q.add(nd);
        far[p.x][p.y] = true;

        int rowNum[] = {-1,0,0,1};
        int colNum[] = {0,-1,1,0};

        while(!q.isEmpty()){

            Node curr = q.element();
            Point temp = curr.pt;

            if(matrix[temp.x][temp.y]==2)
                return 1;

            q.remove();

            for(int i=0; i<4; i++){

                int row = temp.x+rowNum[i];
                int col = temp.y+colNum[i];


                //System.out.println(row+" "+col);
                if(isValid(row,col) && (matrix[row][col]==3 ||matrix[row][col]==2) && !far[row][col]){
                    Point t = new Point(row,col);
                    Node nt = new Node(t,curr.dist+1);
                    far[row][col]=true;
                    q.add(nt);


                }

            }
        }

        return 0;
    }

    private static boolean isValid(int row, int col){
        if(row>=0 && row<n && col>=0 && col<n)
            return true;
        else
            return false;
    }
}
