/*
CSC212 - Prac 2 BFS and DFS implementation
Student no. : 3851727
Student(Author) name : Keanu Johnston 
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Graph{
	//global arrays
	private int numVert; //no. of arrays
	private ArrayList<String> adj[];
	//Created all arrays of type String to save time from parsing variables from csv file.
	static String[] arrName;
	static String[] arrGeo;
	static String[] arrRat;
	
	//****ii.a) Breadth-First and Depth-First search algorithms*****
	// Constructor
	Graph(int v){
		numVert = v;
		adj = new ArrayList[v];
		for (int i; i < v; i++){
			adj[i] = new ArrayList(); //Initializing adj[]
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
				arrGeo[i] = fData[1];
				arrRat[i] = fData[2];
				i++;
				
			}
			br.close();
		}catch(IOException e){
			System.out.println("Cannot read file - please try again");
			e.printStackTrace();
			
		}
	}
	//Method to add an edge into the graph
	void addEdge(int v, String w){
		adj[v].add(w); // Add w to v's list
	}
	
	// Utility function used by DFS
	void DFSUtil (int v, boolean vis[]){ // where v denotes the vertice position and vis denotes visited
		// place a flag at node visited and print it
		vis[v] = true;
		System.out.print(v+"");
		
		//repeat all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()){//hasNext() checks whether following pointer exists
			int nxt = i.next();
			if(!vis[nxt])
				DFSUtil(nxt,vis);
		}
	}
	void DFS(){
		//flag all vertices that are not visited yet.
		boolean vis[] = new boolean[numVert];
		
		//call method DFSUtil recursively to print DFS traversal
		for(int  i=0; i < numVert; ++i)
			if(vis[i] == false)
				DFSUtil(i, vis);
	}
	
	void BFS(int x){
		//flag all vertices as not visited(set visited to false by default)
		boolean vis[] = new boolean[numVert];
		
		//Build a queue for BFS
		//q: queue
		ArrayList<String> q = new ArrayList<String>();
		
		//flag the active node as visited and enqueue it
		vis[x] = true;
		q.add(x);
		
		while(q.size() != 0){
			//Dequeue a vertex from queue and print it
			x = q.poll();
			System.out.print(x+"");
			
			//fetch all adjacent vertices of the dequeued vertex x
			// If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
			Iterator<String> i = adj[x].listIterator();
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
	
	public static void main(String args[]){
		Graph g = new Graph(4);
		
		g.addEdge(0, arrName[1]); 
        g.addEdge(0, arrName[2]); 
        g.addEdge(1, arrName[2]); 
        g.addEdge(2, arrName[0]); 
        g.addEdge(2, arrName[3]); 
        g.addEdge(3, arrName[3]); 
		
		System.out.println("Following is depth first traversal");
		g.DFS();
		System.out.println("\nFollowing is Breadth First Traversal "+ 
                           "(starting from vertex 2)");
		g.BFS(2);
	}
	}