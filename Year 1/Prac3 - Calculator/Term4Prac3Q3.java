//Keanu Johnston
//3851727
//2 Oct 2019

import java.util.*;
import javax.swing.JOptionPane;

public class Term4Prac3Q3{
	
	public static void main(String [] args)
	{
		//Create list
		String Func[] = {"ADD","SUB","MUL","DIV","SQRT","EXP"};
		
		//Display choice message to user
		int opt = JOptionPane.showOptionDialog (null,"Welcome to the calculator, what would you like to do?","Click a button",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Func , Func[0]);
		
		//Declare variables
		String sConfirm;
		int iConfirm,confirm,n1,n2;
		
		//check case
		switch(opt){
			case 0: 
				JOptionPane.showMessageDialog (null,"addition");
				String sN1 = JOptionPane.showInputDialog ("Give the first number");
				n1 = Integer.parseInt(sN1);
				String sN2 = JOptionPane.showInputDialog ("Give the second number");
				n2 = Integer.parseInt(sN2);
				confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?");
				if (confirm == 0){
					JOptionPane.showMessageDialog (null,n1 + n2);
					System.exit(0);
				}else{
					System.exit(0);
				}
				break;
				
			case 1: 
				JOptionPane.showMessageDialog (null,"subtraction");
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
				break;
				
			case 2:
				JOptionPane.showMessageDialog (null,"multiplication");
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
				break;
			case 3:
				JOptionPane.showMessageDialog (null,"division");
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
				break;
			case 4:
				JOptionPane.showMessageDialog (null,"square-root");
				sN1 = JOptionPane.showInputDialog ("Give number to square root");
				n1 = Integer.parseInt(sN1);
				confirm = JOptionPane.showConfirmDialog (null,"Would you like to see result?"); 
				if (confirm == 0){
					JOptionPane.showMessageDialog (null,Math.sqrt(n1));
					System.exit(0);
				}else{
					System.exit(0);
				}
				break;
			case 5:
				JOptionPane.showMessageDialog (null,"exponential");
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
				break;
				
			default:
				JOptionPane.showMessageDialog (null,"default");
					
		}
	}
}