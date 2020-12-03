//Keanu johnston
//3851727
//9 Oct 2019
import java.util.*;
public class AreaOfRectangle
{
	public double length,width;
	public void getValues()
	{
		boolean flag;
		flag = false;
		//Ask for user input
		while(!flag){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the length of rectangle");
		length = keyboard.nextDouble();
		System.out.println("Enter the width of rectangle");
		width = keyboard.nextDouble();
		if((length > 0) && (width > 0))
		{
			flag = true;
		}
		}
	}
	public double calcAreaOfRectangle()
	{
		double Area;
		Area = 0;
		
		Area = length*width;
		return Area;
	}
	public static void main(String[] args)
	{
		//Display welcome message
		System.out.println("Welcome this program calculates the area of a rectangle");
		//execute objects
		AreaOfRectangle obj = new AreaOfRectangle();
		obj.getValues();
		System.out.println("The area of this rectangle is " +obj.calcAreaOfRectangle());
		
		
	}
}
