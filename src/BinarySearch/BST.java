package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BST {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    Node root;

    BST() {
        root = null;
    }

    public static void main(String args[]) throws IOException{

        BST obj = new BST();

        System.out.println("Enter : ");
        System.out.println("1. Add \n2. Search \n3. Print \n4. Delete \n5. EXIT. \n\n");

        int c = Integer.parseInt(br.readLine());
        while(c!=5){
            switch(c){
                case 1 : {
                    System.out.println("Enter element : ");
                    int x = Integer.parseInt((br.readLine()));
                    obj.root = obj.addElement(obj.root, x);
                    System.out.println("Root value is = "+obj.root.val);

                    /*int ar[] = {36,20,19,21,40,39,60,50};
                    for(int x: ar)
                        obj.root = obj.addElement(obj.root, x); */
                }
                break;
                case 2 : {
                    System.out.println("Enter element to search : ");
                    int x = Integer.parseInt((br.readLine()));
                    obj.search(obj.root, x);
                }
                break;
                case 3 : {
                    System.out.println("\nInorder Traversal : ");
                    obj.printTreeInorder(obj.root);
                    System.out.println("\nPreorder Traversal : ");
                    obj.printTreePreorder(obj.root);
                }
                break;
                case 4:{
                    System.out.println("Enter element to delete : ");
                    int x = Integer.parseInt((br.readLine()));
                    obj.delete(obj.root, x);
                }
                break;
                default: System.out.println("Try again");
            }

            System.out.println("\nEnter : ");
            System.out.println("1. Add \n2. Search \n3. Print \n4. Delete \n5. EXIT. \n\n");

            c = Integer.parseInt(br.readLine());
        }
    }

    private Node addElement(Node root, int x){

        if(root == null){
            root = new Node(x);
            return root;
        }
        else if (x < root.val){
            root.left = addElement(root.left, x);
        }
        else if (x> root.val){
            root.right = addElement(root.right, x);
        }

        else if (x == root.val)
            System.out.println("Duplicate.");

        return root;
    }


    private void search(Node root, int x){

        if(root == null) System.out.println("Element not found.");

        else if(x < root.val){
            search(root.left, x);
        }
        else if(x > root.val){
            search(root.right, x);
        }

        else if ( x == root.val)
            System.out.println("Element found!");

    }

    private void printTreeInorder(Node root){

        if(root == null)
            return;
        printTreeInorder(root.left);
        System.out.println(root.val);
        printTreeInorder(root.right);
    }

    private void printTreePreorder(Node root){

        if(root == null)
            return;
        System.out.println(root.val);
        printTreePreorder(root.left);
        printTreePreorder(root.right);
    }

    private Node delete(Node root, int x){
        if(root == null){
            return root;
        }
        else if(x < root.val){
            root.left = delete(root.left, x);
        }
        else if (x > root.val){
            root.right = delete(root.right, x);
        }
        else{
            //Case 1
            if(root.left == null && root. right == null){
                root = null;
            }

            //Case 2
            else if(root.left == null){
                root = root.right;
            }

            else if(root.right == null){
                root = root.left;
            }
            //Case 3

            else {
                int temp = findMin(root.right);
                root.val = temp;
                root.right = delete(root.right, temp);
            }
        }
        return root;
    }

    private int findMin(Node root){

        int min = root.val;
        while(root.left!=null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

}

