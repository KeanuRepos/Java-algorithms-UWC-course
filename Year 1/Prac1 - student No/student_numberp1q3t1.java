//Keanu Johnston
//38517127
//18 September 2019

//Import classes
import java.util.*;

public class student_numberp1q3t1
{
   public static void main(String[] args)
   {
   		//Print messages to the screen
      System.out.println("Hello.");
      System.out.println("This program gives the year in which the nth birthday of the user will occur");
      
		
		//Declare intinger variables year1 and year2 
      int BirthYear, OtherYear;
      
		//Read values from the keyboard
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter your year of birth:");
	  BirthYear = keyboard.nextInt();
      System.out.println("Please enter birthday number");
	  OtherYear = keyboard.nextInt();
      
		//Calculate when birthday will occur
      System.out.print("The next birthday will occur in : ");
      System.out.println(BirthYear + OtherYear);
   }
}