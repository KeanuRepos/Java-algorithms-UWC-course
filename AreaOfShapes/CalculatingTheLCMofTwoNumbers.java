//Keanu johnston
//3851727
//9 Oct 2019
import java.util.*;
public class CalculatingTheLCMofTwoNumbers
{
	
	public static void main(String[] args)
	{
		//Display welcome message
		System.out.println("Welcome this program finds the LCM for two values");
		//Declare variables
		int no1,no2;
		double lcm;
		
		//Ask the user for input
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Give me the first number");
		no1 = keyboard.nextInt();
		System.out.println("Give me the second number");
		no2 = keyboard.nextInt();
		
		//Declare variables
		int m1,m2;
		boolean flag;
		m1 = 1;
		m2 = 1;
		lcm = 0;
		flag = false;
		do{
		if ((m1*no1) == (m2*no2))
		{
			flag = true;
			lcm = m1*no1;
		}else if((m1*no1) < (m2*no2))
		{
			m1++;
		}else
		{
			m2++;
		}
		}while(!flag);
		//Output
		System.out.println("The LCM of no1 and no2 is " + lcm);
	}
	
}