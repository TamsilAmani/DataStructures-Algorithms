package src.Graphs;

public class MinimumEdges {

    static class Node{
        int val;
        Node next;

        Node(int v){
            val=v;
            this.next = null;
        }
    }

    static Node front = null, rear = null;

    static void enQue(int x){
        Node temp = new Node(x);

        if(rear==null)
            front=rear=temp;
        else{
            rear.next = temp;
            rear = temp;
        }
    }

    static Node deQue(){
        if(front==null)
            return null;
        else{
            Node temp = front;
            front = front.next;
            if(front==null)
                rear = null;

            return temp;
        }
    }

    static boolean emptyQue(){
        if(front==null)
            return true;

        return false;
    }

    static int vertex = 9;
    public static void main(String args[]){

        int mat[][] = {
                {0,1,0,0,0,0,0,1,0},
                {1,0,1,0,0,0,0,1,0},
                {0,1,0,1,0,1,0,0,1},
                {0,0,1,1,1,1,0,0,0},
                {0,0,1,0,0,1,0,0,0},
                {0,0,1,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0},
                {1,1,0,0,0,0,0,0,1},
                {0,0,1,0,0,0,0,0,0}
        };

        int start=0;
        int end = 5;

        solveMinEdges(mat,start,end);

    }

    static void solveMinEdges(int mat[][], int start, int end){

        boolean visited[] = new boolean[vertex];

        int distance[] = new int[vertex];
        for(int i=0; i<vertex; i++)
            distance[i]=0;

        enQue(start);
        visited[start] = true;

        while(!emptyQue()){

            int x = deQue().val;

            for(int i=0; i<vertex; i++) {
                if (mat[x][i] == 1) {
                    if (visited[i])
                        continue;
                    distance[i] = distance[x] + 1;
                    enQue(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(distance[end]);

    }
}
