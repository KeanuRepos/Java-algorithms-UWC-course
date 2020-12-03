/*
Extract list from textfile and sort alphabetically accornding to First Name
Solving method: D.A.C
Keanu Johnston
3851727
10 Feb 2020
*/
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;//Import class to handle errors
import java.io.FileWriter;
import java.io.IOException;
public class ExtractOccupation
{
	static String arrNames[] = new String[60]; 
	static String arrOccupation[] = new String[60];
	static int arrTOccIndex[] = new int[60];
	
	public static void main(String[] args)
	{
		//open original Text file
	try{
		File myObj1 = new File("C:\\Users\\DELL\\Documents\\3.Work\\University\\2020\\CSC211\\Assignments\\EstateInterestedClient\\InterestedClientList.txt");
		Scanner myReader = new Scanner(myObj1);//Scanner class reads textfiles
		//Copy each person's name and age into respective array
		int i = 0;
		while (i<60)
		{
			String data = myReader.nextLine();
			String[] arrData = data.split(",");
			arrNames[i] = arrData[0];
			arrOccupation[i] = arrData[4];
			i++;
		}
		myReader.close();
	
	}catch (FileNotFoundException e){
		System.out.println("An error has occured.");
		e.printStackTrace();//Outputs the location of error.
	}
	
	//Test to validate that person is between age 35 and 45
	int personCount = 0;
	int TOccCounter = 0;
	while(personCount<60)
	{
		String data = arrOccupation[personCount];
		//Test
		if (data == "Professor" || data == "Associate Professor"){
			arrTOccIndex[TOccCounter] = personCount;
			TOccCounter++;
		}
		personCount++;
	}
	
	//Create new TF to store name and age
	try 
	{
		File myObj3 = new File("C:\\Users\\DELL\\Documents\\3.Work\\University\\2020\\CSC211\\Assignments\\EstateInterestedClient\\age.txt");
		if(myObj3.createNewFile())//creates file
		{
			System.out.println("File created: " + myObj3.getName());
		}else
		{
			System.out.println("File already exists.");
		}
	}catch (IOException e)
	{
		System.out.println("An error has occured.");
		e.printStackTrace();
	}
	
	//write Names and Age to .txt file.
	try{
		FileWriter myWriter = new FileWriter("C:\\Users\\DELL\\Documents\\3.Work\\University\\2020\\CSC211\\Assignments\\EstateInterestedClient\\professors.txt");
		//Write array to TF
		int i = 0;
		while (i<arrTOccIndex.length || arrTOccIndex[i]!=0)
		{
			myWriter.write(arrNames[arrTOccIndex[i]]+","+arrOccupation[arrTOccIndex[i]]+"\n");
			i++;
		}
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	}catch(IOException e)
		{
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	}
	}	