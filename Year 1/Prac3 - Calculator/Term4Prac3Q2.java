//Keanu Johnston
//3851727
//2 Oct 2019
import java.util.*;
class Term4Prac3Q2{
	public static void main(String [] args){
		String a,b = "";
		
		Scanner word = new Scanner(System.in);
		System.out.println("Please provide a word");
		a = word.nextLine();
		
		int n = a.length();
		
	for(int i = n-1; i >= 0; i--){
		b = b + a.charAt(i);
	}
	if(a.equals(b)){
		System.out.println(a + " is a palindrome");
	}else{
		System.out.println(a + " is a NOT a palindrome");
	}
		
	}
}