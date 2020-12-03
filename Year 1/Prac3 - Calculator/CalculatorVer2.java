//Keanu Johnston
//3851727
//2 Oct 2019

import java.util.*;
import javax.swing.JOptionPane;

public class CalculatorVer2{
	
	public static void Addition()
	{
		//Declare variables
		String sN1,sN2;
		int confirm,n1,n2;
		
		JOptionPane.showMessageDialog (null,"Addition");
		sN1 = JOptionPane.showInputDialog ("Give the first number");
		n1 = Integer.parseInt(sN1);
		sN2 = JOptionPane.showInputDialog ("Give the second number");
		n2 = Integer.parseInt(sN2);
		confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?");
		if (confirm == 0){
			JOptionPane.showMessageDialog (null,n1 + n2);
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	public static void Subtraction()
	{
		//Declare variables
		String sN1,sN2;
		int confirm,n1,n2;
		
		JOptionPane.showMessageDialog (null,"Subtraction");
		sN1 = JOptionPane.showInputDialog ("Give the first number");
		n1 = Integer.parseInt(sN1);
		sN2 = JOptionPane.showInputDialog ("Give the second number");
		n2 = Integer.parseInt(sN2);
		confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?");
		if (confirm == 0){
			JOptionPane.showMessageDialog (null,n1 - n2);
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	public static void Multiplication()
	{
		//Declare variables
		String sN1,sN2;
		int confirm,n1,n2;
		
		JOptionPane.showMessageDialog (null,"Multiplication");
		sN1 = JOptionPane.showInputDialog ("Give the first number");
		n1 = Integer.parseInt(sN1);
		sN2 = JOptionPane.showInputDialog ("Give the second number");
		n2 = Integer.parseInt(sN2);
		confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?");
		if (confirm == 0){
			JOptionPane.showMessageDialog (null,n1 * n2);
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	public static void Division()
	{
		//Declare variables
		String sN1,sN2;
		int confirm,n1,n2;
		
		JOptionPane.showMessageDialog (null,"Division");
		sN1 = JOptionPane.showInputDialog ("Give the first number");
		n1 = Integer.parseInt(sN1);
		sN2 = JOptionPane.showInputDialog ("Give the second number");
		n2 = Integer.parseInt(sN2);
		confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?");
		if (confirm == 0){
			JOptionPane.showMessageDialog (null,n1 / n2);
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	public static void SqaureRoot()
	{
		//Declare variables
		String sN1,sN2;
		int confirm,n1,n2;
		
		JOptionPane.showMessageDialog (null,"Square-root");
		sN1 = JOptionPane.showInputDialog ("Give number to square root");
		n1 = Integer.parseInt(sN1);
		confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?"); 
		if (confirm == 0){
			JOptionPane.showMessageDialog (null,Math.sqrt(n1));
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	public static void Exponential()
	{
		//Declare variables
		String sN1,sN2;
		int confirm,n1,n2;
		
		JOptionPane.showMessageDialog (null,"Exponential");
		sN1 = JOptionPane.showInputDialog ("Give the base number");
		n1 = Integer.parseInt(sN1);
		sN2 = JOptionPane.showInputDialog ("Give the power number");
		n2 = Integer.parseInt(sN2);
		confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?");
		if (confirm == 0){
			JOptionPane.showMessageDialog (null,Math.pow(n1,n2));
			System.exit(0);
		}else{
			System.exit(0);
		}
	}
	
	public static void main(String [] args)
	{
		//Create list
		String Func[] = {"ADD","SUB","MUL","DIV","SQRT","EXP"};
		
		//Display choice message to user
		int opt = JOptionPane.showOptionDialog (null,"Welcome to the calculator, what would you like to do?","Click a button",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Func , Func[0]);
		
		//Declare variables
		String sConfirm,sN1,sN2;
		int confirm,n1,n2;
		
		//Instantiate class
		CalculatorVer2 obj = new  CalculatorVer2();
		
		//check case
		switch(opt){
			case 0: 
				obj.Addition();
				break;
				
			case 1: 
				obj.Subtraction();
				break;
				
			case 2:
				obj.Multiplication();
				break;
			case 3:
				obj.Division();
				break;
			case 4:
				obj.SqaureRoot();
				break;
			case 5:
				obj.Exponential();
				break;
				
			default:
				JOptionPane.showMessageDialog (null,"default");
					
		}
	}
}