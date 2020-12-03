/**
Author : Keanu Johnston
Student number : 3851727
*/
package DataStructures;
import DataStructures.Node;
import DataStructures.BinaryTree;
import DataStructures.BinarySearchTree;
import java.lang

public class BinaryHeap extends BinaryTree{
    static int[] heap;
    static int size;
    BinaryTree Bt;
    BinaryHeap(int elementCount){
        heap = new int[elementCount];//gets new value
    }
    public static void main (String[] args) {
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
            System.out.println("test:" + Bh.heap.length);
        
        System.out.println("\n===Inserting node into Binary Heap Tree===");

        Bh.insertNode(7);
            System.out.println("test1.1:" + Bh.heap.length);
        System.out.println("\n          ===Done!===");
        System.out.println("\n===Deleting node into Binary Heap Tree===");
        System.out.println("\n===Tree traversal ouput BEFORE deletion operation===");
        Bh.print();//list before operation

        Bh.deleteNode(0);//Takes the index of parameter to delete then deletes it.

        System.out.println("\n===Tree traversal ouput AFTER deletion operation===");
        Bh.print();//list after operation
        System.out.println("\n          ===Done!===");
    }
    private boolean TreeMaker(){//creates binary tree and an implicit representation of it.
        boolean TreeMade = false;
        this.Bt = new BinaryTree(10);//instantiate binary tree object

        //level 0
        heap[0] = Bt.root.value;//implicit representation of heap

        //level 1
        Bt.root.leftChild = new Node(20);
        Bt.root.rightChild = new Node(30);
        heap[1] = Bt.root.leftChild.value;
        heap[2] = Bt.root.rightChild.value;
        //level 2
        Bt.root.leftChild.leftChild = new Node(40);
        Bt.root.leftChild.rightChild = new Node(50);
        Bt.root.rightChild.leftChild = new Node(60);
        Bt.root.rightChild.rightChild = new Node(70);
        heap[3] = Bt.root.leftChild.leftChild.value;
        heap[4] = Bt.root.leftChild.rightChild.value;
        heap[5] = Bt.root.rightChild.leftChild.value;
        heap[6] = Bt.root.rightChild.rightChild.value;
        //level 3
        Bt.root.leftChild.leftChild.leftChild = new Node(80);
        Bt.root.leftChild.leftChild.rightChild = new Node(90);
        Bt.root.leftChild.rightChild.leftChild = new Node(100);
        heap[7] = Bt.root.leftChild.leftChild.leftChild.value;
        heap[8] = Bt.root.leftChild.leftChild.rightChild.value;
        heap[9] = Bt.root.leftChild.rightChild.leftChild.value;

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
    public void storeNewHeap(int sSize)//Stores array elements in Tree nodes.
    {

        System.out.println("test sSize: " + sSize);
        Bt.root = new Node((sSize-1)/2);
        System.out.println("test: " + Bt.root.value);
        if(!isLeaf(sSize)){
            Bt.root.leftChild = new Node(heap[(2*sSize)+1]);
            sSize++;
            Bt.root = Bt.root.leftChild;
            storeNewHeap(sSize);
        }else{

            Bt.root.rightChild = new Node(heap[(2*sSize)+2]);
            sSize++;
            Bt.root = Bt.root.rightChild;
            storeNewHeap(sSize);

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
        storeNewHeap(0);
        for (int k = 0;k<heap.length;k++)
            System.out.println(heap[k]);
        return dNode;
    }

}