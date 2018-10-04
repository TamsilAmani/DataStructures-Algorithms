package src.Graphs;

public class StronglyConnectedComponents {

    static class Node{
        int data;
        Node next;

        Node(int key){
            data = key;
            next = null;
        }
    }

    static Node top = null;

    static void push(int key){
        Node temp = new Node(key);

        if(top==null){
            top = temp;
        }
        else{
            temp.next = top;
            top = temp;
        }
    }

    static Node pop(){
        Node temp = top;
        top = top.next;
        return temp;
    }

    static boolean isEmpty(){
        return (top==null)?true:false;
    }




    static int vertex;
    public static void main(String args[]){
        int graph[][] = {
                {0,0,1,1,0},
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,0,0,1},
                {0,0,0,0,0}
        };

        vertex = graph.length;
        solveSCC(graph);
    }

    static void solveSCC(int graph[][]){
        boolean visited[] = new boolean[vertex];

        for(int i=0; i < vertex ; i++){
            if(!visited[i])
                fillStack(graph,visited,i);
        }

        int tgraph[][] = getTranspose(graph);

        for(int i=0; i<vertex; i++)
            visited[i] = false;

        for(int i=0; i< vertex; i++){
            if(!visited[i]) {
                DFS(tgraph, visited, i);
                System.out.println();
            }

        }


    }

    static void fillStack(int graph[][],boolean visited[], int u){
        visited[u]=true;

        for(int i=0 ; i<vertex;i++){
            if(graph[u][i]==1 && !visited[i])
                fillStack(graph,visited,i);
        }
        push(u);
    }

    static void DFS(int tgraph[][], boolean visited[], int u){
        visited[u]=true;
        System.out.print(u+" ");

        for(int i=0;i<vertex;i++){
            if(tgraph[u][i]==1 && !visited[i])
                DFS(tgraph,visited,i);
        }
    }

    static int[][] getTranspose(int graph[][]){
        int temp[][]= new int [vertex][vertex];

        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                temp[i][j]=graph[j][i];
            }
        }
        return temp;
    }
}
