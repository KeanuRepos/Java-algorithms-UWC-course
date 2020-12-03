/*
CSC212-A&C Prac 3
student no. : 3851727
Author: Keanu Johnston
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class School{
	int id;
	String name;
	float lat;
	float lng;
	float rating;
	int[] edges;
	
	public int getID(){
		return id; 
	}
	public String getName(){
		return name;
	}
	public float getLat(){
		return lat;
	}
	public float getLng(){
		return lng;
	}
	public float getRating(){
		return rating;
	}
}

public class ShortestPath
{
	/*
	i.Function to Read file details into ArrayList
	*/
	//ArrayList storing values from textfile
    ArrayList<School> skwls = new ArrayList<School>();
	
	private ArrayList<School> getSchools(String pathOfFile)
	{
		try
		{
			String rw;
			int indx = 0;
			BufferedReader csvRdr = new BufferedReader(new FileReader(pathOfFile));
			String[] dta = new String[4];
			csvRdr.readLine();//Skips first line that contains incorrect data.
			while((rw = csvRdr.readLine())!= null){
				dta = rw.split(";");
				School s = new School();
				s.id = indx++;
				s.name = dta[0];
				s.lat = Float.parseFloat(dta[1]);
				s.lng = Float.parseFloat(dta[2]);
				s.rating = Float.parseFloat(dta[3]);
				//index automatically added to array element
				skwls.add(s);
			}
			System.out.println("Successful - Details from datafile stored in datastructure");
			csvRdr.close();
			
		}
		catch(Exception e){
			System.out.println("Unsuccessful - Failed to store Details from datafile to datastructure");
			e.printStackTrace();
		}
		return skwls;
	}
	
	// A utility function that finds the arc with the smallest distance value,
	// it starts at the set of arcs not yet incl. in shortest path tree.
	
	static int Vrts;//no. of arcs.
	int minDist(int dist[], Boolean sptList[])
	{
		//Init. min value
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for (int v = 0; v < Vrts; v++)
			if (sptList[v] == false && dist[v] <= min){
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}
	// A utility function to output the construct the dist datastructure
	void printSolutn(int du[]){
		System.out.println("Vertex \t\t Distance from Source");
		for(int i = 0; i < Vrts; i++)
			System.out.println(i + "\t\t" + du[i]);
	}
		
	/*
	ii.Function that implements Dijkstra's single source shortest path
	   algorithm for a graph denoted using adj matrix			
	*/
	void dijkstra(int grph[][], int src){
		
		int du[] = new int[Vrts];//du[] holds min path of edge src to i.
		
		//sptList[i] equals true if arc i is incl. in min path tree/ min distance from src to i is finalized.
		Boolean sptList[] = new Boolean[Vrts];
		
		// Init all distances as Infintite and stpList[] as false
		for(int i = 0; i<Vrts; i++){
			du[i] = Integer.MAX_VALUE;
			sptList[i] = false;
		}
		
		//Distance of source vertex from itself is always 0
		du[src] = 0;
		
		//Find shortest path for all vertices
		for(int cnt = 0; cnt < Vrts - 1; cnt++){
			//Pick the smallest distance vertex from the list of vertices
			//not yet processed. During the first iteration src is always equal to using
			int u = minDist(du,sptList);
			
			// Mark the picked vertex as processed
			sptList[u] = true;
			
			//Update distance value of the adj vertices of the picked vertex.
			for (int v = 0; v < Vrts; v++){
				//Update distance only if it is not in sptList,
				//there is an edge from u to v, and total weight of path from src to 
				//v through u is smaller than current value of dist[v]
				if(!sptList[v] && grph[u][v] != 0 && du[u] != Integer.MAX_VALUE && du[u]+grph[u][v] < du[v])
					du[v] = du[u] + grph[u][v];
			}
			//output the constructed distance array
			printSolutn(du);
			}
	}
	//////////////////////////////////////////////////////////////////
	void printAdjList(int adj[][]){
		for(int i = 0; i < adj.length; i++){
			System.out.println("Adjacency list of " + i);
			for(int j = 0; j < adj.length; j++){
				System.out.print(adj[i][j] + " ");
			}System.out.println();
		}
	}
	// Function to calculate distance between nodes
	double harvesine(double lat1,double lng1,double lat2,double lng2){
		//distance between lat and lng
		double dlat = Math.toRadians(lat2 - lat1);
		double dlng = Math.toRadians(lng2 - lng1);
		System.out.println("u6:" +(lat2 - lat1));
		//convert to radians
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);
		System.out.println("u7:" +(lat1));
		
		//apply formulae
		double a = Math.pow(Math.sin(dlat / 2), 2) + 
					Math.pow(Math.sin(dlng / 2), 2) *
					Math.cos(lat1) *
					Math.cos(lat2);
		double rad = 6371;
		double c = 2 * Math.asin(Math.sqrt(a));
		return rad * c;
	}
		
	//Driver method
	public static void main(String[] args){
		//create references to objects
		ShortestPath s = new ShortestPath();
		
		//create adj list from textfile
		s.getSchools("Soweto.csv");
		
		//Create a graph with nodes holding the condition.
		double adj[][] = new double[s.skwls.size()][s.skwls.size()];
		for(int col = 0; col < 30-1; col++){
			for(int row = 0; row < 30-1;row++){
				//ShortestPath s = new ShortestPath();
		
				//Prepare variables for the condition that test if link is valid
				
				//String obj of SOURCE lat and lng
				String s_c1 = String.valueOf(s.skwls.get(col).getLat());
				String s_c2 = String.valueOf(s.skwls.get(col).getLng());	
				
				//convert SOURCE lat and lng String values to double
				double c1 = Double.parseDouble(s_c1);//lat
				double c2 = Double.parseDouble(s_c2);//lng
				
				//String obj of DESTINATION lat and lng
				String s_c3 = String.valueOf(s.skwls.get(row).getLat());
				String s_c4 = String.valueOf(s.skwls.get(row).getLng());	
				
				//convert DESTINATION lat and lng String values to double
				double c3 = Double.parseDouble(s_c1);//lat
				double c4 = Double.parseDouble(s_c2);//lng
				
				//current DESTINATION length of name of edge
				String s_d = Integer.toString(s.skwls.get(row).getName().length());
				double dn = Double.parseDouble(s_d);
				
				//current DESTINATION rating
				String s_dr = String.valueOf(s.skwls.get(row).getRating());	
				double dr = Double.parseDouble(s_dr);//dest. node rating

				//condition to TEST whether edge is valid
				if((Double.compare(Math.floor(Math.sqrt((Math.pow(c1,2))*(Math.pow(c2,2)))%6),Math.floor(dn % 6))) == 0 && (Double.compare(Math.floor(dr),Math.floor(dn % 6))) == 0){
					adj[col][row] = s.harvesine(c1,c2,c3,c4);
					Vrts++;
				}else{
					adj[col][row] = 0.0;
					Vrts++;
				}
			}
		}
		//s.dijkstra(s.adj, 0); //Only used when we want to find shortest path between schools
	}
}



















