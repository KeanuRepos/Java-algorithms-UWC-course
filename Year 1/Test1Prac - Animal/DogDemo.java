
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