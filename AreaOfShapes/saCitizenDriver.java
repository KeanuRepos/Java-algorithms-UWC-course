
import java.util.*;

public class saCitizenDriver
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println();
      	System.out.println("Initialising Citizen Database");
      	System.out.println("Creating Citizen 1");
      	System.out.println();
      	
      	saCitizen citizen1 = new saCitizen();
      	
      	System.out.println("Enter your name: ");
      	String name = keyboard.nextLine();
      	
      	System.out.println("Enter your surname: ");
      	String surname = keyboard.nextLine();
      	
      	citizen1.setFullName(name,surname);
      	
      	System.out.println("Enter your SA ID Number: ");
      	String idNumber = keyboard.nextLine();
      	
      	citizen1.setIDnumber(idNumber);
      	   	
      	System.out.println("Enter your current address: ");
      	String address = keyboard.nextLine();
		
      	citizen1.setAddress(address);
		
		System.out.println("Enter your age: ");
      	int age = keyboard.nextInt();
      	citizen1.setAge(age);
      	
      	System.out.println("Citizen 1 "+citizen1.getFullName()+" lives at "+citizen1.getAddress()+"\n"+"is "+citizen1.getAge()+" and has the following ID Number :"+citizen1.getIDnumber());
      	
      	System.out.println("====================================");
   	}
}