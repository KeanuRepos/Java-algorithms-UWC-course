//Keanu johnston
//3851727
//9 Oct 2019
import java.util.*;
import javax.swing.JOptionPane;
public class saCitizen
{
	public String fullName,Address,sAge;
	public int age,idNumber;
	public static void main(String[] args)
	{
		
	}
	public void setFullName(String name,String surname)
	{
		fullName = name + surname;
	}
	public void setAddress(String s1)
	{
		Address = s1;
	}
	public void setIDnumber(String s2)
	{
		
		idNumber = Integer.parseInt(s2);
	}
	public void setAge(int n1)
	{
		age = n1;
	}
	public String getFullName()
	{
		return fullName;
	}
	public int getIDnumber()
	{
		return idNumber;
	}
	public String getAge()
	{
		return Integer.toString(age);
	}
	public String getAddress()
	{
		return Address;
	}
	
}