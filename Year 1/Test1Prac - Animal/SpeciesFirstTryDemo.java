//Keanu Johnston
//3851727
//8 October 2019
import java.util.*;
public class SpeciesFirstTryDemo
{
	public static void main(String[] args)
	{
		SpeciesFirstTry speciesOfTheMonth = new SpeciesFirstTry();
		System.out.println("Enter data on the species Of The Month:");
		speciesOfTheMonth.readInput();//ask the user to enter values
		speciesOfTheMonth.WriteOutput();//Outputs user values
		int futurePopulation = speciesOfTheMonth.getPopulationIn10();
		System.out.println("In ten years the population will be " + futurePopulation);
		
		//Now we change the variables
		speciesOfTheMonth.name = "Manu";
		speciesOfTheMonth.population = 10;
		speciesOfTheMonth.growthRate = 15;
		System.out.println("The new species of the Month:");
		speciesOfTheMonth.WriteOutput();
		System.out.println("In ten years the population will be " + speciesOfTheMonth.getPopulationIn10());
		
	}
}