//Keanu johnston
//3851727

import java.util.*;
class Mastermind{
	static boolean mastered(int no,int low,int high){
		System.out.println("Welcome!,This program tests a learner on multiplication problems");
		Random rnd = new Random();
		//Declare variables
		int correct,no1,no2,userAns,answer;
		no1 = 0;
		no2 = 0;
		correct = 0;
		for(int i = 0;i < no;i++){
			//Assign variables
			no1 = (int)(rnd.nextInt(high) + low);
			no2 = (int)(rnd.nextInt(high) + low);
			answer = no1*no2;
			//Read answer from keyboard
			Scanner keyboard = new Scanner(System.in);
			System.out.println("What is the answer to "+no1+"x"+no2+"?");
			userAns = keyboard.nextInt();
			//test if userAns = to answer
			if (userAns == answer){
				correct = correct + 1;
				System.out.println("Your answer is correct!");
			}else{
				System.out.println("Your answer is wrong!");
			}
				
		}
		if ((correct / (no1*1.0) * 100) > 80){
			return true;
		}else{
			return false;
		}
		
	}
	//Start of main routine
	public static void main(String[] args){
		Mastermind obj = new Mastermind();
		obj.mastered(1,2,5);
		int left,right,noOfSums,level;
		level = 1;
		while (true){
			if (level == 1){
				left = 2;
				right = 5;
				noOfSums = 10;
			}else if(level == 2){
				left = 6;
				right = 9;
				noOfSums = 13;
			}else{
				left = 10;
				right = 13;
				noOfSums = 18;
			}
			if (mastered(noOfSums,left,right)){
				System.out.println("Now stepping up to the next level");
				level = level + 1;
			}else if (level > 1){
				System.out.println("Now stepping down the level");
				level = level - 1;
				
			}
			if (level > 3 ){//then exit the while loop
				break;
			}
		}
		System.out.println("That's the end of the multiplication session. You have mastered all three levels!");
	}
}