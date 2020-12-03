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
public class SortName{
	private static String arrNames[] = new String[60];
	public static void main(String[] args){
	//open original Text file
	try{
		File myObj1 = new File("C:\\Users\\DELL\\Documents\\3.Work\\University\\2020\\CSC211\\Assignments\\EstateInterestedClient\\InterestedClientList.txt");
		Scanner myReader = new Scanner(myObj1);//Scanner class reads textfiles
		//Copy each person's name into array
		int i = 0;
		while (i<60)
		{
			String data = myReader.nextLine();
			String[] arrData = data.split(",");
			arrNames[i] = arrData[0];
			i++;
		}
		myReader.close();
	
	}catch (FileNotFoundException e){
		System.out.println("An error has occured.");
		e.printStackTrace();//Outputs the location of error.
	}
	
	//Create new TF(Names.txt)
	//Create new TF
	try 
	{
		File myObj3 = new File("C:\\Users\\DELL\\Documents\\3.Work\\University\\2020\\CSC211\\Assignments\\EstateInterestedClient\\Names.txt");
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
	
	//write sorted array of names to .txt file.
	try{
		FileWriter myWriter = new FileWriter("C:\\Users\\DELL\\Documents\\3.Work\\University\\2020\\CSC211\\Assignments\\EstateInterestedClient\\Names.txt");
		//Write array to TF
		int i = 0;
		while (i<60)
		{
			myWriter.write(arrNames[i]+"\n");
			i++;
		}
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	}catch(IOException e)
		{
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	String temp = "";
	//Sort Client Name alphabetically
	for (int i = 0;i <= 60-1;i++){
		for (int j = 0;j <= 60-1;j++){
			if ((arrNames[i].compareTo(arrNames[j]))<0)
			{
				temp = arrNames[i];
				arrNames[i] = arrNames[j];
				arrNames[j] = temp;
			}else
			{
				continue;
			}
			 
	}
	}
	
	//write sorted array to another textfile(SortedNames.txt)
	//Create new TF
	try 
	{
		File myObj3 = new File("SortedNames.txt");
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
	
	//write sorted array of names to .txt file.
	try{
		FileWriter myWriter = new FileWriter("SortedNames.txt");
		//Write array to TF
		int i = 0;
		while (i<60)
		{
			myWriter.write(arrNames[i]+"\n");
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