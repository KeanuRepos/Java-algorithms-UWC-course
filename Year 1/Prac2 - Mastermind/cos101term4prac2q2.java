//Keanu Johnston
//3851727
//25 September 2019

import java.util.*;
public class cos101term4prac2q2{
	public static void main(String[] array){
		//display welcome message
		System.out.println("Welcome!, this program is a digital rock,paper and scissors game,lets play!");
		//Declare variables
		String inputP1,inputP2;
		boolean flag;
		flag = false;
		//Read input from keyboard
		Scanner keyboard = new Scanner(System.in);
		while (flag==false){
			System.out.println("Player 1, choose P,R, or S");
			inputP1 = keyboard.next().toUpperCase();
			System.out.println("Player 2, choose P,R, or S");
			inputP2 = keyboard.next().toUpperCase();
			//Test to see who wins
			if ((inputP1.equals("P"))&&(inputP2.equals("R"))){
				System.out.println("Paper covers rock,Player 1 wins");
				flag = true;
			}else if((inputP1.equals("P"))&&(inputP2.equals("S"))){
				System.out.println("Scissors cuts paper,Player 2 wins");
				flag = true;
			}else if((inputP1.equals("R"))&&(inputP2.equals("P"))){
				System.out.println("Paper covers rock,Player 2 wins");
				flag = true;
			}else if ((inputP1.equals("R"))&&(inputP2.equals("S"))){
				System.out.println("Rock smashes scissors,Player 1 wins");
				flag = true;
			}else if ((inputP1.equals("S"))&&(inputP2.equals("R"))){
				System.out.println("Paper covers rock,Player 1 wins");	
				flag = true;
			}else if((inputP1.equals("S"))&&(inputP2.equals("P"))){
				System.out.println("Scissors cuts paper,Player 1 wins");
				flag = true;
			}else if((inputP1.equals(inputP2))){
				System.out.println("It is a tie! We go again.");
			}
		}

	}
}
