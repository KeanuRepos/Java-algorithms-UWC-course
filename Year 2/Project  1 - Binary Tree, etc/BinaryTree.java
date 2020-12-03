/**
Author : Keanu Johnston
Student number : 3851727
*/
package DataStructures;
import DataStructures.Node;
import DataStructures.BinaryTree;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {
    Node root;
    public BinaryTree(int ivalue){ 
        root = new Node(ivalue); //denotes roots value
    }
    public static void main(String[] args){
        System.out.println("Name: Johnston , Keanu\nStudent Number: 3851727\nCourse Code: CSC211_Term Project 2020");
  
        BinaryTree tree = new BinaryTree(10);
        //level 0
        tree.root = new Node(10);
        //level 1
        tree.root.leftChild = new Node(20);
        tree.root.rightChild = new Node(30);
        //level 2
        tree.root.leftChild.leftChild = new Node(40);
        tree.root.leftChild.rightChild = new Node(50);
        tree.root.rightChild.leftChild = new Node(60);
        tree.root.rightChild.rightChild = new Node(70);
        //level 3
        tree.root.leftChild.leftChild.leftChild = new Node(80);
        tree.root.leftChild.leftChild.rightChild = new Node(90);
        tree.root.leftChild.rightChild.leftChild = new Node(100);

        //Tree traversal methods
        System.out.println("\nPreOrderTraversal of list");
        tree.PreOrderTraversal(tree.root);//put binary tree in method
        System.out.println("\nInOrderTraversal of list");
        tree.InOrderTraversal(tree.root);
        System.out.println("\nPostOrderTraversal of list");
        tree.PostOrderTraversal(tree.root);

        System.out.println("\n\nOutput of Preorder traversal: " + tree.outputPreOrder);
        System.out.println("Output of Inorder traversal: " + tree.outputInOrder);
        System.out.println("Output of Postorder traversal: " + tree.outputPostOrder);
    }
    public  ArrayList<String> outputPreOrder = new ArrayList<String>();
    public  ArrayList<String> outputInOrder = new ArrayList<String>();
    public  ArrayList<String> outputPostOrder = new ArrayList<String>(); 
    //prints preorder traversal output
    public  void storePreOrder(int item){
        outputPreOrder.add(Integer.toString(item));
    }
    //prints inorder traversal output
    public  void storeInOrder(int item){
        outputInOrder.add(Integer.toString(item));
    }
    //prints postorder traversal output
    public void storePostOrder(int item){
        outputPostOrder.add(Integer.toString(item));
    }
    //Preorder(NLR)
    public void PreOrderTraversal(Node item){
       if(item == null){
            return;
       }
            System.out.print(item.value+",");//N (print out item value to screen)
            storePreOrder(item.value);
            PreOrderTraversal(item.leftChild);//L
            PreOrderTraversal(item.rightChild);//R
       
    }
    //InOrder(LNR)
    public void InOrderTraversal(Node item){
        if(item == null){
             return;
        }
            InOrderTraversal(item.leftChild);//L
            System.out.print(item.value+",");//N
            storeInOrder(item.value);
            InOrderTraversal(item.rightChild);//R  
     }
     //PostOrder(LRN)
     public void PostOrderTraversal(Node item){
        if(item == null){
             return;
        }
            PostOrderTraversal(item.leftChild);//L
            PostOrderTraversal(item.rightChild);//R
            System.out.print(item.value+",");//N
            storePostOrder(item.value);
    }
}