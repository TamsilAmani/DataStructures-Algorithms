import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList {
    Node head, curr;

    private LinkedList(){
        head = null;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {

        LinkedList obj = new LinkedList();

        System.out.println("Enter : \n");
        System.out.println("1. Add \n2. Print \n3. Delete \n4. EXIT \n\n");

        int c = Integer.parseInt(br.readLine());

        while(c!=4){
            switch (c){
                case 1 : obj.addElement();
                break;
                case 2 : obj.printList();
                break;
                case 3: obj.deleteElement();
                break;
                default: System.out.println("Try again!");
            }

            System.out.println("\n\nEnter : \n");
            System.out.println("1. Add \n2. Print \n3. Delete \n4. EXIT \n\n");
            c = Integer.parseInt(br.readLine());
        }
    }

    private void addElement() throws IOException {
        System.out.println("Enter element to add : ");
        int e = Integer.parseInt(br.readLine());

        Node temp = new Node(e);
        temp.setNext(null);

        if(head == null){
            head = temp;
            curr = temp;
        }

        else{
            curr.setNext(temp);
            curr = temp;
        }
    }

    private void printList(){
        if(head == null) System.out.println("List Empty");
        else{
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.val+" -> ");
                temp= temp.getNext();
            }
        }
    }

    private void deleteElement() throws IOException {
        if(head == null) System.out.println("List empty. Can't delete.");
        else{
            System.out.println("Enter element to delete : ");
            int e = Integer.parseInt(br.readLine());

            Node temp1 = head, temp2 = head;

            while(temp1!=null){
                if(temp1.val == e){
                    if(temp1 == head)
                        head = head.getNext();

                    else{
                        temp2.setNext(temp1.getNext());
                    }

                    printList();
                    return;
                }
                else{
                    temp2 = temp1;
                    temp1 = temp1.getNext();
                }

            }
            System.out.println("No Element found.");
        }
    }
}
