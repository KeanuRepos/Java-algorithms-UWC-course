//Keanu Johnston
//3851727
//9 October 2019

import java.util.*;

public class Test1Term4{
	double arg1,arg2,arg3;//declare global variable
	boolean flag;
	static boolean isTriangle(double s1,double s2,double s3){
		if((s1 + s2 > s3) && (s1 + s3 > s2 ) && (s2 + s3 > s1 )){
			return true;
		}else{
			return false;
		}
		
	}
	static boolean isIsosceles(double s1,double s2,double s3){
		if ((s1 == s2)||(s2==(s3))||(s1==(s3))){
			return true;
		}else{
			return false;
		}
	}
	static boolean isEquilateral(double s1,double s2,double s3){
		if ((s1==(s2))&&(s2==(s3))){
			return true;
		}else{
			return false;
		}
	}
	static boolean isRightAngled(double s1,double s2,double s3){
		if((s1*s1 == s2*s2 + s3*s3)||(s2*s2 == s1*s1 + s3*s3)||(s3*s3 == s1*s1 + s2*s2)){
			return true;
		}else{
			return false;
		}
	}
	public void run(){
		//Get input from keyboard
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please provide sides");
		arg1 = keyboard.nextDouble();
		arg2 = keyboard.nextDouble();
		arg3 = keyboard.nextDouble();
		
		//Test whether sides entered matches a triangle
		if (isTriangle(arg1,arg2,arg3)){
			flag = false;
			if (isIsosceles(arg1,arg2,arg3)){
				System.out.println("Isosceles");
				flag = true;
			}
			if (isEquilateral(arg1,arg2,arg3)){
				System.out.println("Equilateral");
				flag = true;
			}
			if (isRightAngled(arg1,arg2,arg3)){
				System.out.println("Right-angled");
				flag = true;
			}
			if (!flag){
				System.out.println("Scalene");
			}
		}else{
			System.out.println("Figure is not a triangle");
		}
	}
	public static void main(String[] args){//runs the actual program
		Test1Term4 obj = new Test1Term4();
		obj.run();
	}

}
