/*
Keanu Johnston
3851727
7 November 2019
*/

import java.util.*;
public class CharacterFrequency
{
	public static void main(String[] args)
	{
		//Declare count array for each digit
		int[] count = new int[10];
		
		//Input
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please provide a cellphone number");
		String tNum = keyboard.nextLine();
		
		//increment every number in telephone number
		int k = 0;
		while(k != tNum.length())
		{	
			char c = tNum.charAt(k);
			
			switch(c)
			{
				case '0':
					{
						count[0]++;
						break;
					}
				case '1':
					{
						count[1]++;
						break;
					}
				case '2':
					{
						count[2]++;
						break;
					}
				case '3':
					{
						count[3]++;
						break;
					}
				case '4':
					{
						count[4]++;
						break;
					}
				case '5':
					{
						count[5]++;
						break;
					}
				case '6':
					{
						count[6]++;
						break;
					}
				case '7':
					{
						count[7]++;
						break;
					}
				case '8':
					{
						count[8]++;
						break;
					}
				case '9':
					{
						count[9]++;
						break;
					}
				
				
			}k++;
		}
		System.out.println("Number\tCount");
		for(int i = 0 ;i < 10 ; i++)
		{
			System.out.println(i+"\t"+count[i]);
		}

		
		
		
		
		
		
		
		
		
		
		
	}
}