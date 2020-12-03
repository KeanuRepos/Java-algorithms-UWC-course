/**
 File name: Doctor.java

 Class that extends Person to include a specialty and office fee,
 plus various constructors, set methods to change all parameters
 at once or each individually, write methods to display all
 parameters or each individually, and an equals method to test if
 all parameters for two doctors are equal.

 Derived from Person class, Listing 8.1

 Based on Employee.java.

 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/4/2000
 Changes: 3/15/2003 Made comments like text examples.
*/
public class Doctor extends Person
{
    private double officeFee;
    private String specialty;

    // Six constructors
    // Note that there is no constructor that specifies
    // just a specialty.

    public Doctor()
    {
        super();
        officeFee = 150.00;// AMA specified minimum wage
        specialty = ("None given.");
    }

    public Doctor (String aName)
    {
        super(aName);
        officeFee = 150.00;// AMA specified minimum wage
        specialty = ("None given.");
    }

    public Doctor (String aName, int theOfficeFee)
    {
        super(aName);
        officeFee = theOfficeFee;
        specialty = ("None given.");
    }

    public Doctor (String aName, String theSpecialty)
    {
        super(aName);
        officeFee = 150.00;// AMA specified minimum wage
        specialty = theSpecialty;
    }

    public Doctor (double theOfficeFee, String theSpecialty)
    {
        super();
        officeFee = theOfficeFee;
        specialty = theSpecialty;
    }

    public Doctor (String aName, double theOfficeFee, String theSpecialty)
    {
        super(aName);
        officeFee = theOfficeFee;
        specialty = theSpecialty;
    }

    // Methods to display (write) values of data items

    // Write all values

    public void writeOutput()
    {
        writeName();
        writeOfficeFee();
        writeSpecialty();
    }

    // Write name: calls writeOutput() from parent class

    public void writeName()
    {
        super.writeOutput();
    }

    public void writeOfficeFee()
    {
        System.out.println("Office Fee: $" + officeFee);
    }

    public void writeSpecialty()
    {
        System.out.println("Specialty: " + specialty);
    }

    // Methods to set parameter values

    // Change name: use setName from parent class, Person

    // Set all three parameters

    public void set(
        String newName, double newOfficeFee, String newSpecialty)
    {
        super.setName(newName);
        officeFee = newOfficeFee;
        specialty = newSpecialty;
    }

    public void setOfficeFee(double newOfficeFee)
    {
        officeFee = newOfficeFee;
    }

    public void setSpecialty(String newSpecialty)
    {
        specialty = newSpecialty;
    }


    // Return name: use getName from parent class, Person
	
	public String getName()
	{
		return super.getNames();
	}
	
    public double getOfficeFee()
    {
        return officeFee;
    }

    public String getSpecialty()
    {
        return specialty;
    }

    // Equals method

    public boolean equals(Doctor otherDoctor)
    {
        return(this.hasSameName(otherDoctor)
          && this.getOfficeFee() == otherDoctor.getOfficeFee()
          && this.specialty.equalsIgnoreCase(otherDoctor.getSpecialty()));
    }
}