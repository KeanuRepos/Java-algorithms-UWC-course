/*
CSC212-Prac 2
Student no.: 3851727
Student name: Keanu Johnston 
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Graph{
	//global arrays
	private int numVert; //no. of arrays
	//bare in mind that this holds the indexes of schools in textfile
	private LinkedList<Integer> adj[];
	//print search results to the screen;
	private String outpFinal = "";
	private String outpFinal2= "";
	//Created all arrays of type String to save time from parsing variables from csv file.
	//These arrays run parallel with adj array.
	static String[] arrName = new String[132];
	static String[] arrGeoLat= new String[132];;
	static String[] arrGeoLon= new String[132];;
	static String[] arrRat= new String[132];;
	
	//****ii.a) Breadth-First and Depth-First search algorithms*****
	// Constructor
	Graph(int v){
		numVert = v;
		adj = new LinkedList[v];
		for (int i=0; i < v; i++){
			adj[i] = new LinkedList(); //Initializing adj[]
		}
	}
	
	//**************** i) Open and read Input*********************
	static void ReadInput(){
		BufferedReader br = null;
		String line;
		int i = 0;
		
		try{
			
			br = new BufferedReader(new FileReader("Soweto.csv"));
			line = br.readLine();
			
			while((line = br.readLine())!= null){
				String[] fData = line.split(";",0);
				//store values from file into correct array
				arrName[i] = fData[0];
				arrGeoLat[i] = fData[1];
				arrGeoLon[i] = fData[2];
				arrRat[i] = fData[3];
				i++;
				
			}
			br.close();
			System.out.println("Data captured.");
		}catch(IOException e){
			System.out.println("\nCannot read file - please try again");
			e.printStackTrace();
			
		}
	}
	
	//Method to add an edge into the graph
	void addEdge(int v, int w){//the w will pass through index of parallel arrays.
		adj[v].add(w); // Add w to v's list
	}
	
	// Utility function used by DFS
	void DFSUtil (int v, boolean vis[]){ // where v denotes the vertice position and vis denotes visited
		vis = new boolean[200];//create size in array
		// place a flag at node visited and print it
		vis[v] = true;// sets the value(true/false) to index v, e.g. vis[8] = true; vis[20] = true,...etc
		if(v == numVert-1){
				outpFinal =outpFinal + v;
				return;
			}
		outpFinal = outpFinal+v+",";
		
		if (v == numVert - 1)//exits method to avoid NoSuchElementException
			return;
		
		//repeat for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		i.next();//Used to avoid OutOfBounds Error
		while (i.hasNext()){//hasNext() checks whether following pointer in datastructions exists
			int nxt = i.next();//nxt contains value of i address
			if(!vis[nxt]){
				System.out.println(" u1:" + nxt);
				DFSUtil(nxt,vis);
			}
		}
	}
	void DFS(){
		//flag all vertices that are not visited yet.
		boolean vis[] = new boolean[numVert];
		//call method DFSUtil recursively to print DFS traversal
		for(int i = 0; i < numVert; ++i)
			if(vis[i] == false)
				DFSUtil(i, vis); 
	}
	
	void BFS(int x){
		//flag all vertices as not visited(set visited to false by default)
		boolean vis[] = new boolean[numVert];
		
		//Build a queue for BFS
		//q: queue
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		//flag the active node as visited and enqueue it
		vis[x] = true;
		q.add(x);
		
		while(q.size() != 0){
			//Dequeue a vertex from queue and print it
			x = q.poll();
			outpFinal2 =outpFinal2 +x+",";
			//fetch all adjacent vertices of the dequeued vertex x
			// If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
			Iterator<Integer> i = adj[x].listIterator();
			i.next();//used to avoid OutOfBoundError
			while (i.hasNext())
			{
				int nxt = i.next();
				if (!vis[nxt]){
					vis[nxt] = true;
					q.add(nxt);
				}
			}
		}
		
	}
	static void mergeSortArr(String a[], int b){ //where a is the parameter array and b the size of a.
        
        int sub_size; //varies from 1 to n/2
        int left_initial; // initial index of left subarray to be merged

        for (sub_size = 1; sub_size <= b-1; sub_size = 2*sub_size){
            //choose initial index of different subarrays of sub size
            for (left_initial = 0; left_initial < b-1; left_initial += 2*sub_size){
                //find final index of left sub array
                int mid = Math.min(left_initial + sub_size - 1, b-1);

                int right_end = Math.min(left_initial + 2*sub_size - 1, b-1);

                //Merge subarrays arr[left_initial...mid]
                //& arr[mid+1...right_end]
                merge(a, left_initial, mid, right_end);
            }
        }
        }
         // Function to merge the two halves a[1..m] and 
         // a[m+1..r] of array a[]
        static void merge(String a[], int l, int m, int r){
            int i, j, k;
            int n1 = m - l + 1;
            int n2 = r - m;

            String L[] = new String[n1];
            String R[] = new String[n2];

            // Copy data to temp arrays L[] and R[]
            for (i = 0; i <  n1; i++)
                L[i] = a[ l + i ];
            for(j = 0; j < n2; j++)
                R[j] = a[m + 1 + j];

            //Merge the temp arrays back into a[l..r]
            i = 0;
            j = 0;
            k = l;
            while (i < n1 && j < n2){
                if (L[i].compareTo(R[j]) <= 0){
                    a[k] = L[i];
                    i++;
                }
                else{
                    a[k] = R[j];
                    j++;
                }
                k++;
            }
            //if there are remaining elements of L[], Copy the remaining elements of L[]
            while(i < n1){
                a[k] = L[i];
                i++;
                k++;
            }
            //if there are remaining elements of R[], Copy the remaining elements of R[]
            while(j < n2){
                a[k] = R[j];
                j++;
                k++;
            }
        }
	public static void main(String args[]){
		ReadInput();
			
		//fetch arrays with ratings
		//j: no. of schools with 5 star ratings
		int j = 0;
		for(int i = 0;i < arrRat.length-1; i++){
			
			if (arrRat[i].compareTo("5") == 0){
				j++;
			}
		}
		
		Graph g = new Graph(j);
		
		//array with indexes
		int[] a = new int[j];
		
		int l = 0;
		for(int k=0; k<arrRat.length-1; k++){
			if ((arrRat[k].compareTo("5")) == 0){
				a[l] = k;//store index of 5 star school ratings in array
				l++;
			}
		}
		//if length of a[] even, then add edges a certain way
		if (((a.length)%2) == 0 ){
			for(int i = 0; i<a.length-1;i++ ){
				g.addEdge(i,a[i+1]);
				
			}
		}else{
			for(int i = 0; i<a.length;i++ ){
				if (i==a.length-1){
					g.addEdge(a[1],a[i]);
				}else{
					g.addEdge(a[i],a[i+1]);
				}
			}
		}
		//calc. number of elem in array.
			String line ="";
			int c = g.numVert; // array size
			
			try{
			String outpStr = "";
			outpStr = outpStr + "Values [";
			String temp = "";
			String n1 = "";
			String[] arrSorted = new String[c];
			for(int i=0; i<c-1; i++){
				if(i == (c-2)){
					temp = temp + g.arrName[g.adj[i].get(0)];
					arrSorted[i] = g.arrName[g.adj[i].get(0)];
					break;
				}else{
					temp = temp + g.arrName[g.adj[i].get(0)] + ", ";
					arrSorted[i] = g.arrName[g.adj[i].get(0)];
				}	
			}
			mergeSortArr(arrSorted,c-1);
			temp = temp + "]\n\nSorted [";
			for(int i=0; i<c-1; i++){
				if(i == (c-2)){
					temp = temp + arrSorted[i];
					break;
				}else{
					temp = temp + arrSorted[i] + ", ";
				}	
			}
			String outpStr2 = "\nFollowing is depth first traversal" ;
			g.DFS();
			String outpStr3 = "\nFollowing is Breadth First Traversal";
			g.BFS(0);
			String fOutput = outpStr + temp + "]";
			String fOutput2 = outpStr2 + "\n" + g.outpFinal;
			String fOutput3 = outpStr3 + "\n" + g.outpFinal2;
			//where w denotes writer
			BufferedWriter w = new BufferedWriter(new FileWriter("Graph of 5 star schools.txt",true)); 
			w.write(fOutput + "\n" + fOutput2 + "\n" + fOutput3);
			w.write("\n\n");
			System.out.println("\nFile written to textfile named, Graph of 5 star schools.txt");
			w.close();
			
		}catch(IOException e){
			System.out.println("\n-----Unable to write output of program to textfile - please try again-----\n");
			e.printStackTrace();
		}
		
	}
	}