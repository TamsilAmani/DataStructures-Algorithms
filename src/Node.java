public class Node {
    int val;
    Node next;

    Node(int v){
        this.val = v;
        this.next = null;
    }

    void setNext(Node n){
        next = n;
    }

    Node getNext(){
        return this.next;
    }

}
