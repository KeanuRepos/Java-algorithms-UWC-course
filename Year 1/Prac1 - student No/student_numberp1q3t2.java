//Keanu Johnston
//38517127
//18 September 2019
import java.util.*;
import java.lang.Math.*;

public class student_numberp1q3t2{
	
	public static void main(String[] args){
   		//Print messages to the screen
      System.out.println("Hello.");
      System.out.println("This program will output the number of gallons stored in a well casing");
      
		
		//Declare intinger variables year1 and year2 
      int radius, heightOfWell;
	  double VolOfCyl;
      
		//Read values from the keyboard
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter the radius of the well in inches:");
	  radius = keyboard.nextInt();
      System.out.println("Please enter the depth of the well in feet:");
	  heightOfWell = keyboard.nextInt();
      
		//Calculate volume of a cylinder
	  VolOfCyl = (Math.PI*radius*heightOfWell)/7.48;
      System.out.print("A " + heightOfWell + " feet well full of water with a radius of " + radius + " inches for the casing holds about " + (double) VolOfCyl + " gallons of water");
    
	}
}