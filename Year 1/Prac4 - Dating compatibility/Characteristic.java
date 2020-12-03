/*
Keanu Johnston
385127
6 November 2019

This Program compares two people on an online dating site and chooses
the best fitting couple based on their characteristics
*/

import java.util.*;
public class Characteristic
{
	//Global var
	private String sDescription;
	private int iRating;
	
	public Characteristic(String NewDescr)//Constructor
	{
		sDescription = NewDescr;
		iRating = 0;	
	}
	public boolean isValid(int aRating)//Validation of rating(1-10)
	{
		if ((aRating >= 1)&&((aRating <= 10)))
		{
			return true;
		}else
		{
			return false;
		}
	}
	public void setRating(int aRating)//sets global variable to paramater
	{
		if (isValid(aRating))
		{
			iRating = aRating;
		}
		
	}
	//Mutatator Methods
	public void setRating()//gets rating from user and sets global var
	{
		int iRate = -1;
		System.out.println("Please provide a rating from 1 to 10 based \n on yout desire for this Characteristic:" + sDescription);
		
		boolean validRate = true;//error controler
		do
		{
			//Input
			Scanner capture = new Scanner(System.in);
			iRate = capture.nextInt();
			//Process
			if(isValid(iRate))
			{
				break;
			}
			else
			{
				System.out.println("Invalid Rate given please enter an integer in the range from 1-10");
				validRate = false;
			}
		}while(!validRate);
		setRating(iRate);
		
	}
	public String toString()//Outputs global var values
	{
		return sDescription + " is rated as " + iRating;
	}
	//Accessor methods
	public String getDescription()
	{
		return sDescription;
	}
	public String getRating()
	{
		return Integer.toString(iRating);
	}
	
	public double getCompatibility(Characteristic otherRating)
	{
		int r1 = iRating;
		int r2 = Integer.parseInt(otherRating.getRating());
		
		if(r1==0 | r2==0)
		{
			return 0.0;
		}else
		{
			return(1.0 - (r1 - r2)*(r1 -r2)/81.0);
		}
	}
	
	public static void main(String[] args)
	{
		//Two new objects with description
		Characteristic likesSports = new Characteristic("like sports");
		Characteristic likesBeaches = new Characteristic("like Beaches");
		
		//INPUT + OUTPUT`
		//Asking User 1 for ratings
		likesSports.setRating();
		System.out.println("Displaying the rating(Sports) we got: " + likesSports);
		System.out.println();
		
		likesBeaches.setRating();
		System.out.println("Displaying the rating(Beaches) we got: " + likesBeaches);
		System.out.println();
		
		//Registered people description + ratings
		Characteristic sueLikesFishing = new Characteristic("likes fishing");
		sueLikesFishing.setRating(6);
		Characteristic bobLikesFishing = new Characteristic("likes fishing");
		bobLikesFishing.setRating(6);
		
		//OUTPUT
		//Compare Bob and Sue ratings(Fishing)
		System.out.println("Compatibility measure should be 1");//PerfectMatch
		System.out.println("\t" + sueLikesFishing.getCompatibility(bobLikesFishing));
		
		//Compare Sue and User ratings(Fishing)
		System.out.println("Compatibility measure should be 0");
		System.out.println("\t" + sueLikesFishing.getCompatibility(likesSports));
		
		//Compare Bob and Sue new Ratings(Fishing)
		sueLikesFishing.setRating(1);
		bobLikesFishing.setRating(9);
		System.out.println("Compatibility measure should be 0.209");
		System.out.println("\t" + sueLikesFishing.getCompatibility(bobLikesFishing));
		
		//Compare Bob and Sue new Ratings(Fishing)
		sueLikesFishing.setRating(2);
		bobLikesFishing.setRating(9);
		System.out.println("Compatibility measure should be about 0.395");
		System.out.println("\t" + sueLikesFishing.getCompatibility(bobLikesFishing));
		
	}
	
}
