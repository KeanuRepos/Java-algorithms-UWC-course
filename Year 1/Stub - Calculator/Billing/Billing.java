/**
 File name: Billing.java

 Class for a billing record for an office visit by a patient
 to see a doctor.  Contains the name of the doctor, the
 name of the patient, and the doctor's fee for the office vist.

 Author: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 9/4/2000
 Changes: 03/15/2003 Made comments like text examples.
*/
import java.util.*;
public class Billing
{
	private int i = 0;
	private int j = 0;
	public String[] arrPatients = new String[2];;
	public String[] arrDoctors = new String[2];;
    private static String aDoctor;
    private static String aPatient;
    private static double billingAmount;

    // Constructors: must have both a doctor and a patient.

    public Billing(Doctor theDoctor, Patient thePatient)
    {
        aDoctor = theDoctor.getName();
        aPatient = thePatient.getName();
        billingAmount = theDoctor.getOfficeFee();
    }
	//Main method : used so that the program can be invoked by the system
	public static void main(String[] args)
	{
		//add input
		setpatientPayment("Keanu","Melanie",3000);
		//print output
		
		System.out.println("Dr: "+ getDoctor() + "\n"+ "Patient: " + getPatient()+"\n"+"This is the Billing balance "+patientBalance());
		
	}

    // Methods to display instance variable values.

    // Write all values

    public void writeOutput()
    {
        writeDoctorName();
        writePatientName();
        writeBillingAmount();
    }

    public void writeDoctorName()
    {
        System.out.println("Doctor: " + aDoctor);
    }

    public void writePatientName()
    {
        System.out.println("Patient: " + aPatient);
    }

    public void writeBillingAmount()
    {
        System.out.println("Billing Amount: $" + billingAmount);
    }

    // Methods to change values of instance variables

    // Change all values

    public void set (String newDoctorName,
                     String newPatientName, double newBillingAmount)
    {
        setDoctor(newDoctorName);
        setPatient(newPatientName);
        setBillingAmount(newBillingAmount);
    }

    public void setDoctor(String newDoctor)
    {
        aDoctor = newDoctor;
		arrDoctors[i] = aDoctor; 
		i++;
    }

    public void setPatient(String newPatient)
    {
        aPatient = newPatient;
		arrPatients[j] = aPatient;
		j++;
    }

    public void setBillingAmount(double newBillingAmount)
    {
        billingAmount = newBillingAmount;
    }
	public static void setpatientPayment(String Dr,String Patient,double Amount)
	{
		aDoctor = Dr;
		aPatient = Patient;
		billingAmount = Amount;
	}

    // Methods to return values of instance variables.

    public static String getDoctor()
    {
        return aDoctor;
    }

    public static String getPatient()
    {
        return aPatient;
    }

    public static double getBillingAmount()
    {
        return billingAmount;
    }
	public static double patientBalance()
	{
		return getBillingAmount();
	}

    // Equals method

    public boolean equals(Billing otherBilling)
    {
        return this.aDoctor.equalsIgnoreCase(otherBilling.getDoctor())
            && this.aPatient.equalsIgnoreCase(otherBilling.getPatient())
            && this.billingAmount == otherBilling.billingAmount;
    }
}