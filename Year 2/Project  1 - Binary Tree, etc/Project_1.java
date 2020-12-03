/**
Author : Keanu Johnston
Student number : 3851727
*/
package DataStructures;
import DataStructures.Node;//used for BinaryTree
import DataStructures.BinaryTree;//used for BinarySearchTree
import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int value;
    Node leftChild;
    Node rightChild;   
    Node(int iValue){
        this.value = iValue;
        this.leftChild = null;  
        this.rightChild = null;
    }
}

class BinaryTree {
    Node root;
    BinaryTree(int ivalue){
        root = new Node(ivalue); //denotes roots value
    }
    public void runBinaryTree(){
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
    public ArrayList<String> outputPreOrder = new ArrayList<String>();
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

class BinarySearchTree extends BinaryTree{
    Node root;
    BinarySearchTree(){
        super(0);//this invokes the constructor for BT class.
        root = null;
    }
    public void runBinarySearchTree(){

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

class BinaryHeap extends BinaryTree{
    static int[] heap;
    static int size;
    BinaryTree Bt;
    BinaryHeap(int elementCount){
        super(0);
        heap = new int[elementCount];//gets new value
    }
    public void runBinaryHeap(){
        System.out.println("\nName: Johnston , Keanu\nStudent Number: 3851727\nCourse Code: CSC211_Term Project 2020");
        //heap array gets a size of zero
        BinaryHeap Bh = new BinaryHeap(10);
        System.out.println("\n===Building Binary Heap Tree===");
        //Makes Binary Tree
        if (Bh.TreeMaker()) {
            System.out.println("\n          ===Done!===");
        }else{
            System.out.println("\n          ===Error creating tree!===");
        }
        System.out.println("Heap length test " + Bh.heap.length);

        System.out.println("\n===Inserting node into Binary Heap Tree===");

        Bh.insertNode(7);
        System.out.println("heap length " + Bh.heap.length);
        System.out.println("\n          ===Done!===");
        System.out.println("\n===Deleting node into Binary Heap Tree===");
        System.out.println("\n===Tree traversal ouput BEFORE deletion operation===");
        Bh.print();//list before operation

        Bh.deleteNode(0);//Takes the index of parameter to delete then deletes it.

        System.out.println("\n===Tree traversal ouput AFTER deletion operation===");
        Bh.print();//list after operation
        System.out.println("\n          ===Done!===");
        return;
    }
    private boolean TreeMaker(){//creates binary tree and an implicit representation of it.
        boolean TreeMade = false;
        BinaryHeap Bh = new BinaryHeap(10);//instantiate binary tree object with a root of 10

        //level 0
        heap[0] = Bh.root.value;//implicit representation of heap
        System.out.println("Root in tree maker: " + Bh.root.value);
        //level 1
        Bh.root.leftChild = new Node(20);
        Bh.root.rightChild = new Node(30);
        heap[1] = Bh.root.leftChild.value;
        heap[2] = Bh.root.rightChild.value;
        //level 2
        Bh.root.leftChild.leftChild = new Node(40);
        Bh.root.leftChild.rightChild = new Node(50);
        Bh.root.rightChild.leftChild = new Node(60);
        Bh.root.rightChild.rightChild = new Node(70);
        heap[3] = Bh.root.leftChild.leftChild.value;
        heap[4] = Bh.root.leftChild.rightChild.value;
        heap[5] = Bh.root.rightChild.leftChild.value;
        heap[6] = Bh.root.rightChild.rightChild.value;
        //level 3
        Bh.root.leftChild.leftChild.leftChild = new Node(80);
        Bh.root.leftChild.leftChild.rightChild = new Node(90);
        Bh.root.leftChild.rightChild.leftChild = new Node(100);
        heap[7] = Bh.root.leftChild.leftChild.leftChild.value;
        heap[8] = Bh.root.leftChild.leftChild.rightChild.value;
        heap[9] = Bh.root.leftChild.rightChild.leftChild.value;

        TreeMade = true;
        return TreeMade;
    }

    private int getParentPosition(int index){//returns position of parent in array
        //index ~ position of node on heap
        return (index-1)/2;//where the root node position = 0
    }
    private int getLeftChildPosition(int index){//returns position of leftChild in array
        //index ~ position of node on heap
        return (2*index) + 1;//where the root node position = 0
    }
    private int getRightChildPosition(int index){//returns position of rightChild in array
        //index ~ position of node on heap
        return (2*index) + 2;//where the root node position = 0
    }
    private boolean isLeaf(int index){//test to see if previous node is a leaf node and returns boolean
        if (index >= (size / 2) && index <= size ){
            return true;
        }else{
            return false;
        }
    }

    private void swap (int pos1 , int pos2){//swaps two nodes of the heap in array
        int tmp;
        tmp = heap[pos1];
        heap[pos2] = tmp;
    }
    private void minHeapify(int index){//applies heap properties to current node(percolate up)
        if(!isLeaf(index)){//test to see if leafnode is greater than any of its children
            if (heap[index] > heap[getLeftChildPosition(index)]
                    ||heap[index] > heap[getRightChildPosition(index)]){
                if(heap[getLeftChildPosition(index)] < heap[getRightChildPosition(index)]){
                    swap(index,getLeftChildPosition(index));
                    minHeapify(getLeftChildPosition(index));
                }
                else{//swap with the right child and heapify the right child
                    swap(index,getRightChildPosition(index));
                    minHeapify(getRightChildPosition(index));
                }
            }
        }
    }
    private void minHeap(){//builds min heap using minHeapify method
        for (int index = ( size / 2);index >= 1;index--) {
            this.minHeapify(index);
        }
    }
    private int findMinChild(Node n1 , Node n2){//finds the minimum child that will bubble up
        return (n1.value < n2.value) ? n1.value : n2.value;
    }
    //@param sSize tells us position of nodes
    public void storeNewHeap(Node Bh, int sSize)//Stores array elements in Tree nodes.
    {
        System.out.println("sSize on recursion call: " + sSize);
        Bh.root = new Node(heap[getParentPosition(sSize)]);
        System.out.println("root value: " + Bh.root.value);
        if(!isLeaf(sSize)){
            Bh.root.leftChild = new Node(heap[getLeftChildPosition(sSize)]);
            sSize++;
            System.out.println("sSize !isLeaf TRUE: " + sSize);
            Bh.root = Bh.root.leftChild;
            System.out.println("sSize !isLeaf TRUE: root " + Bt.root.value);
            storeNewHeap(Bh.root, sSize);
        }else{
            Bh.root.rightChild = new Node(heap[getRightChildPosition(sSize)]);
            sSize++;
            System.out.println("sSize !isLeaf FALSE: " + sSize);
            Bh.root = Bt.root.rightChild;
            System.out.println("sSize !isLeaf FALSE: root " + Bt.root.value);
            storeNewHeap(Bh.root, sSize);

        }
    }

    private boolean insertNode(int item){//Inserts node and the next availible position in Heap
        print();//print list before insert

        if (size >= heap.length) return false;

        heap[size++] = item;//enter heap element @ position 0,1,2,etc.
        int current = size;

        while (heap[current] < heap[getParentPosition(current)]){//gets values in array
            swap(current,getParentPosition(current));
            current = getParentPosition(current);//current changes after every loop
        }

        print();//print list after insert
        //storeNewHeap(0);
        return true;
    }
    private void print(){//prints out the content of the heap
        System.out.println("\n===Pre-order tree traversal===");
        this.Bt.PreOrderTraversal(this.Bt.root);
        System.out.println("\n\n===In-order tree traversal===");
        this.Bt.InOrderTraversal(this.Bt.root);
        System.out.println("\n\n===Post-order tree traversal===");
        this.Bt.PostOrderTraversal(this.Bt.root);
        System.out.println("");
    }
    int delPositon = 0;//used in deleteNode method
    //@param index : index of element to be deleted
    private int deleteNode(int index)//delete by implementing PQueue removal process
    {
        int parent;
        int dNode;

        dNode = heap[index];
        heap[index] = heap[size];//size = "size of heap"
        size--;
        parent = index/2;

        if (index == 1 || heap[parent]<heap[index]){
            minHeapify(index);
        }
        storeNewHeap();
        for (int k = 0;k<heap.length-1;k++)
            System.out.println("Working" + heap[k]);
        return dNode;
    }

}

class TreeDriver{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to implement, press enter after inserting selection key. \n a: Binary Tree \n b: BinarySearchTree \n c: BinaryHeap");
        String selection = sc.nextLine();
        switch (selection){
            case "a":
                BinaryTree Bt = new BinaryTree(0);
                Bt.runBinaryTree();//Run binary tree
                break;
            case "b":
                BinarySearchTree Bst = new BinarySearchTree();
                Bst.runBinarySearchTree();//Run binarySearchtree
                break;
            case "c":
                BinaryHeap Bh = new BinaryHeap(0);
                Bh.runBinaryHeap(); //Run Heap
                break;
            default:
                System.out.println("Error - cannot find selection,please try again");
                break;
        }

    }
}