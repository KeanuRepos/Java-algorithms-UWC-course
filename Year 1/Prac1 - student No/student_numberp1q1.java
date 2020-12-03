//Keanu Johnston
//3851727
//18 September 2019

//Import classes
import java.util.*;

public class student_numberp1q1 //ClassifyTriangles
{	static boolean isIsosceles(int s1,int s2,int s3){
		if ((s1 == s2) || (s2 == s3) || (s1 == s3)){
			return true;
		}else{
			return false;
		}
	}
	static boolean isEquilateral(int s1,int s2,int s3){
		if ((s1 == s2) && (s2 == s3)){
			return true;
		}else{
			return false;
		}
	}
	static boolean isRightAngled(int s1,int s2,int s3){
		if ((Math.pow(s1,2) == Math.pow(s2,2) + Math.pow(s3,2))||(Math.pow(s2,2) == Math.pow(s1,2)+ Math.pow(s3,2))||(Math.pow(s3,2) == Math.pow(s1,2)+ Math.pow(s2,2))){
				return true;
		}else{
				return false;
		}
	}
	static boolean isTriangle(int s1,int s2,int s3){
		if ((s1 + s2 > s3)&&(s1 + s3 > s2)&&(s2 + s3 > s1)){
			return true;
		}
		else{ 
			return false;
		}
	}
	public static void main(String[] args){
		
		//Declare variables
		int s1,s2,s3;
		boolean flag;
		
		//assign variables
		Scanner keyboard = new Scanner(System.in);
		s1 = keyboard.nextInt();
		s2 = keyboard.nextInt();
		s3 = keyboard.nextInt();
		//Test type of triangle
		if (isTriangle(s1,s2,s3)){
			flag = false;
			if (isIsosceles(s1,s2,s3)){
				System.out.println("Isosceles");
				flag = true;
				}
			if (isEquilateral(s1,s2,s3)){
				System.out.println("Equilateral");
				flag = true;
			}
			if (isRightAngled(s1,s2,s3)){
			System.out.println("Right-angled");
			flag = true;	
			}
			if (flag = false){
			System.out.println("Scalene"); 
			}
		}
		else{ 
			System.out.println("Figure is not a triangle");
		}
	
			
	}
}
