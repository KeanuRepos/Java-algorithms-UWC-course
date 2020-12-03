/**
 File name: Patient.java

 Class that extends Person class (Listing 8.4) by adding a Social
 Security Number and appropriate construtors, accessors, and mutators.

 Based on Employee.java from Programming Project 1.

 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/4/2000
 Changes: 03/15/2003 Made comments like text examples.
*/
public class Patient extends Person
{
    private String name;
    private String ssn; // Social security number (3-2-4 format preferred)

    // Constructors

    public Patient()
    {
        super();
        ssn = "000-00-0000";
    }

    public Patient (String aName)
    {
        super(aName);
        ssn = "000-00-0000";
    }

    public Patient (String aName, String aSsn)
    {
        super(aName);
        ssn = aSsn;
    }

    // Methods to display values of parameters.

    // Write all values

    public void writeOutput()
    {
        super.writeOutput();
        writeSsn();
    }

    // Write name: use writeOutput() from parent class

    public void writeName()
    {
        super.writeOutput();
    }

    // Write social security number

    public void writeSsn()
    {
        System.out.println("Social Security #: " + ssn);
    }

    //Methods to change parmeter values.

    // Change all values

    public void set(String newName, String newSsn)
    {
        setName(newName);
        ssn = newSsn;
    }

    // Change name: use setName from parent class, Person
	public void setName(String sName)
	{
		super.setName(sName);
	}
    // Change social security number

    public void setSsn(String newSsn)
    {
        ssn = newSsn;
    }

    //Methods to return values of parameters

    // Return name: use getName from parent class, Person
	public String getName()
	{
		return name;
	}

    // Return social security number

    public String getSsn()
    {
        return ssn;
    }

    // Equals method

    public boolean equals(Patient otherPatient)
    {
        return(this.hasSameName(otherPatient)
                && this.ssn.equalsIgnoreCase(otherPatient.getSsn()));
    }
}