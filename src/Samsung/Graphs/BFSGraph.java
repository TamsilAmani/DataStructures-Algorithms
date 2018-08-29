package Samsung.Graphs;
import java.util.LinkedList;

public class BFSGraph {

    int V;
    LinkedList<Integer> list[] ;


    BFSGraph(int v){
        V=v;
        list = new LinkedList[V];
        for(int i=0;i<v;i++) {
            list[i] = new LinkedList<>();
        }

    }

    void addEdge(int u, int v){
        list[u].add(v);
        //list[v].add(u);
    }

    void printGraph(){

        for(int i=0; i<V;i++){

            for(Integer x : list[i] ){
                System.out.print(" - > "+x);
            }

            System.out.println();
        }
    }

    public static void main(String args[]){
        BFSGraph ob = new BFSGraph(4);

        int ar[][] = {{0,1,1,0},{1,0,0,1},{1,0,0,0},{0,1,1,0}};

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(ar[i][j]==1)
                    ob.addEdge(i,j);
            }
        }

        ob.printGraph();

    }


}
