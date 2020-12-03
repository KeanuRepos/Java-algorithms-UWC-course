//Keanu Johnston
//3851727
//25 September 2019
import java.util.*;
public class cos101term4prac2q3{
	public static void main (String[] array){
		//Welcome message
		System.out.println("Welcome this program reads a list of nonnegative integers and displays the largest,smallest and average value of the list");
		//Declare variables
		int no1,total,i,isLargest,isSmallest;
		double average;
		total = 0;
		no1 = 0;
		i = 0;
		isLargest = 0;
		isSmallest = 10000;
		//Read in from keyboard
		Scanner keyboard = new Scanner(System.in);
		do {
			
			i++;
			System.out.println("Please add a int value to the list or enter a negative number exit number ");
			no1 = keyboard.nextInt();
			//calcAverage
			total = total + no1;
			
			//isLargest
			if (no1 > isLargest){
				isLargest = no1;
				
			}
			//isSmallest
			if ((no1 < isSmallest)&&(no1 > 0)){
				isSmallest = no1;
			}
			
		}
		while (no1 > 0);
		average = total/i;
		System.out.println("Thank you for using the program,goodbye");
		System.out.println("The average of the list " + (double)average);
		System.out.println("The largest number is " + isLargest);
		System.out.println("The smallest number is " + isSmallest);
		
	}
}