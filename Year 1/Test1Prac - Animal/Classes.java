public class Dog
{
	public String name;
	public String breed;
	public int age;

	public void writeOutput()
	{
		System.out.println("Name: " + name);
		System.out.println("Breed: " + breed);
		System.out.println("Age in calendar years: " + age);
		System.out.println("Age in human years: " + getAgeInHumanYears());
		System.out.println();
	}

	public int getAgeInHumanYears()
	{
		int humanYears = 0;
		if (age <= 2)
		{
			humanYears = age * 11;
		}
		else
		{
			humanYears = 22 + ((age-2) * 5);
		}
		return humanYears;
	}
}

public class DogDemo
{
	public static void main(String[] args)
	{
		Dog balto = new Dog();
		balto.name = "Balto";
		balto.age = 8;
		balto.breed = "Siberian Husky";
		balto.writeOutput();

		Dog scooby = new Dog();
		scooby.name = "Scooby";
		scooby.age = 42;
		scooby.breed = "Great Dane";
		System.out.println(scooby.name + " is a " + scooby.breed + ".");
		System.out.print("He is " + scooby.age + " years old, or ");
		int humanYears = scooby.getAgeInHumanYears();
		System.out.println(humanYears + " in human years.");
	}
}