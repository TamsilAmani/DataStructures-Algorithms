package src.Graphs;

public class TopologicalSort {

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
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,1,0,0},
                {0,1,0,0,0,0},
                {1,1,0,0,0,0},
                {1,0,1,0,0,0},
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

        for(int i=0;i<vertex;i++)
            System.out.print(pop().data+" ");


    }

    static void fillStack(int graph[][],boolean visited[], int u){
        visited[u]=true;

        for(int i=0 ; i<vertex;i++){
            if(graph[u][i]==1 && !visited[i])
                fillStack(graph,visited,i);
        }
        push(u);
    }
}
