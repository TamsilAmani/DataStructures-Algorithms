package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class SSTD{

    static int m,n;
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
        while(t-->0){
            String st[] = br.readLine().split(" ");
            m = Integer.parseInt(st[0]);
            n = Integer.parseInt(st[1]);

            int ar[][] = new int[m][n];
            st = br.readLine().split(" ");

            int index=0;

            for(int i=0; i<m;i++){
                for(int j=0; j<n; j++){
                    ar[i][j] = Integer.parseInt(st[index++]);
                }
            }

            st = br.readLine().split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);

            Point pnt = new Point(x,y);
            int distance = findDist(ar, pnt);

            System.out.println(distance);

        }
    }

    private static int findDist(int matrix[][], Point np){
        if(matrix[np.x][np.y]==0 || matrix[0][0]==0)
            return -1;

        boolean far[][] = new boolean[m][n];

        for(int i=0; i<m; i++)
            for(int j=0; j<n ;j++)
                far[i][j] = false;

        Point start = new Point(0,0);
        Node nd = new Node(start,0);

        Queue<Node> q = new LinkedList<>();
        q.add(nd);
        far[0][0] = true;

        int rowNum[] = {-1,0,0,1};
        int colNum[] = {0,-1,1,0};

        while(!q.isEmpty()){

            Node curr = q.element();
            Point temp = curr.pt;

            if(temp.x == np.x && temp.y==np.y)
                return curr.dist;

            q.remove();

            for(int i=0; i<4; i++){

                int row = temp.x+rowNum[i];
                int col = temp.y+colNum[i];


                //System.out.println(row+" "+col);
                if(isValid(row,col) && matrix[row][col]==1 && !far[row][col]){
                    Point t = new Point(row,col);
                    Node nt = new Node(t,curr.dist+1);
                    far[row][col]=true;
                    q.add(nt);


                }

            }
        }

        return -1;
    }

    private static boolean isValid(int row, int col){
        if(row>=0 && row<m && col>=0 && col<n)
            return true;
        else
            return false;
    }
}
