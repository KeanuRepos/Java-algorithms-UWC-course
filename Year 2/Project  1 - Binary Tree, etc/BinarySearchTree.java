/**
Author : Keanu Johnston
Student number : 3851727
*/
package DataStructures;
import DataStructures.Node;
import DataStructures.BinaryTree;
import java.util.Scanner;
import java.lang.System;
public class BinarySearchTree extends BinaryTree{
    Node root;
    public BinarySearchTree(){
        super(0);//this invokes the constructor for BT class.
        root = null;
    }
    public static void main(String args[]){

        System.out.println("\nName: Johnston , Keanu\nStudent Number: 3851727\nCourse Code: CSC211_Term Project 2020");
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(14);
        tree.root.leftChild = new Node(3);
        tree.root.leftChild.rightChild = new Node(4);
        tree.root.leftChild.rightChild.rightChild = new Node(12);
        tree.root.leftChild.rightChild.rightChild.rightChild = new Node(13);
        tree.root.rightChild = new Node(15);
        tree.root.leftChild.rightChild.rightChild.leftChild = new Node(10);
        
        //Printing out traversal of binary tree
        System.out.println("\n===Output of a traversal through the binary search tree===");
        System.out.println("In-order traversal of Binary Search Tree");
        tree.InOrderTraversal(tree.root);
        System.out.println("\nPre-order traversal of Binary Search Tree");
        tree.PreOrderTraversal(tree.root);
        System.out.println("\nPost-order traversal of Binary Search Tree");
        tree.PostOrderTraversal(tree.root);
        
        //inserting values into tree
        System.out.println("\n\n===Adding values to Binary search tree...===");
        tree.add(tree.root,5);
        tree.add(tree.root,1);
        tree.add(tree.root,8);
        tree.add(tree.root,2);
        tree.add(tree.root,0);
        System.out.println("\n  Adding completed!");

        //deleting values
        System.out.println("\n===Deleting values from Binary search tree...===");
        tree.delete(0);
        tree.delete(15);
        System.out.println("\n  Deletion completed!");


        //Printing out traversal of binary tree
        System.out.println("\n===Output of traversal of binary tree after operations===");
        System.out.println("In-order traversal of Binary Search Tree");
        tree.InOrderTraversal(tree.root);
        System.out.println("\nPre-order traversal of Binary Search Tree");
        tree.PreOrderTraversal(tree.root);
        System.out.println("\nPost-order traversal of Binary Search Tree");
        tree.PostOrderTraversal(tree.root);

        //Inserting value of user
        Scanner line = new Scanner(System.in);
        System.out.println("\n\nPlease give a number that you like to locate in the Binary Search tree, e.g. 5 instead of five");
        int userInput = Integer.parseInt(line.nextLine());
        if (tree.findElement(userInput) != null){
            System.out.println("FOUND!");
        }else{
            System.out.println("NOT FOUND");
        }
    }
    //@param n : used to parse root node that becomes left or righ child
    //@param item : used to parse desired value to add 
    Node add(Node n ,int item){
        if(n == null){//if the tree is empty add node to new tree
            return new Node(item);
        }
        if(item< n.value)//move to left subtree if item < tree node
        {
            n.leftChild = add(n.leftChild,item);
        }else if (item > n.value) {
            n.rightChild = add(n.rightChild, item);//move to right subtree if item > tree node
        }
        return n;
    }

    void delete(int item){//deletes node and applies BST properties
        root = deleteRec(root,item);
    }

    Node deleteRec(Node root,int item){//invoked by delete method
        if(root == null){
            return root;
        }
        if(item < root.value) {//parse through left subtree
            root.leftChild = deleteRec(root.leftChild , item);
        }
        else if (item > root.value) //parse through right subtree
            root.rightChild = deleteRec(root.rightChild,item);

        else//if root value is equal to item, delete node.
        {
            if(root.leftChild == null)//node with one left/right child
                return root.rightChild;
            else if(root.rightChild == null)
                return root.leftChild;

            root.value = minValue(root.rightChild);//node with two children, delete smallest

            root.rightChild = deleteRec(root.rightChild, root.value);
        }
        return root;
    }
    int minValue(Node root) 
    { 
        int minv = root.value; 
        while (root.leftChild != null) 
        { 
            minv = root.leftChild.value; 
            root = root.leftChild; 
        } 
        return minv; 
    } 
    Node findElement(int item){
        Node current = this.root;//[this] creates a ref. to root object
        while (current.value != item) {
            if (item < current.value) { // move to left if value is less
                current = current.leftChild;
            }else//move to right if item >=
            current = current.rightChild;
            if (current == null) {
                return null;
        }
    } return current;
}
}