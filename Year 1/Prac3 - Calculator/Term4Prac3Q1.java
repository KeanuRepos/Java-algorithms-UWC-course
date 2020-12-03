//Keanu Johnston
//3851727
//2 Oct 2019

import java.util.*;

class Term4Prac3Q1{
	static void run(){
		//System.out.println("Task is to move " + 6 + " disks from rod A to rod C using B as a spare storage space");
		moveTowers(6,'A','B','C');
	}
	//Use recursion to loop through the procedure.
	static void moveTowers(int n, char A,char B,char C){
		if(n==1){
			System.out.println("Move a disk from rod "+ A + " to rod " + C);
		}else{
			//Explain what is happening
			//System.out.println("Subtask is to move " + n + " disks from rod A to B using rod C as a spare storage space");
			
			moveTowers(n-1, A, C, B);
			
			System.out.println("Move a disk from rod "+ A + " to rod " + B);
			
			//Explain what is happening
			//System.out.println("The subtask is to move " + n + " disks from rod B to C using A as a spare storage space" );
			
			moveTowers(n-1,B, A, C);
			}
	}		
	public static void main(String[] args){
		Term4Prac3Q1 obj = new Term4Prac3Q1();
		obj.run();
	}
			
		
			
	
	
}