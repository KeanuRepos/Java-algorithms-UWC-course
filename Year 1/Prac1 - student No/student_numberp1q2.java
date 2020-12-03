//Keanu Johnston
//38517127
//18 September 2019

//Import classes
import java.util.*;

public class student_numberp1q2
{
   public static void main(String[] args)
   {
   		//Print messages to the screen
      System.out.println("Hello out there.");
      System.out.println("I will add two numbers for you.");
      System.out.println("Enter two whole numbers on a line:");
		
		//Declare intinger variables n1 and n2 
      int n1, n2;
      
		//Read values from the keyboard
      Scanner keyboard = new Scanner(System.in);
      n1 = keyboard.nextInt();
      n2 = keyboard.nextInt();
      
		//Print out the sum of n1+n2
      System.out.println("The sum of those two numbers is");
      System.out.println(n1 + n2);
   }
}