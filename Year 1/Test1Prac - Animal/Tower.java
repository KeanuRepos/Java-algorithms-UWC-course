//Keanu Johnston
//3851727
//8 October 2019

import java.util.*;

public class Tower{
	
	//run method
	static void  run(){
		
		System.out.println("This program moves disks from pole A  to pole C, while using pole B as a memory space");
		
		moveTowers(3,'A','B','C');
	}
	//method containing recursion
	static void moveTowers(int n, char A, char B, char C){
		if(n==1){
			System.out.println("Move a disk from rod " + A + " to rod " + C);
		}else{
			moveTowers(n-1,A,C,B);//middle char is always the spare space rod
			System.out.println("Move a disk from rod " + A + " to rod " + B);
			moveTowers(n-1,B,A,C);//middle char is always the spare space rod
		}
	}
	//main method
	public static void main(String[] args){
		Tower.run();
	}
}