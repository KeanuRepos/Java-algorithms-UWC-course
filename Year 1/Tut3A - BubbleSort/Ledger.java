
/*
 * Ledger.java
 *
 * Created on February 15, 2007, 4:09 PM
 *
 * Solution to Exercises 6 and 7
 */

/**
 *
 * @author charleshoot
 */

import java.util.Scanner;




public class Ledger {
    
    private double saleAmounts[];
    private int salesMade;
    private int maxSales;
    
    
    
    /**
     * Creates a new instance of Ledger
     */
    
    public Ledger(int max){
        saleAmounts = new double[max];
        salesMade = 0;
        maxSales = max;
    }
    
    public void addSale(double amount){
        if(salesMade < maxSales){
            saleAmounts[salesMade] = amount;
            salesMade++;
        }
    }
    
    public int getNumberOfSales(){
        return salesMade;
    }
	
	public double getTotalSales(){
		return salesMade;
	}
    
    public double getAverageSale(){
        if(salesMade > 1)
            return getTotalSales()/getNumberOfSales();
        else
            return 0.0;
    }
	
    
    public int getCountAbove(double threshold){
        int count = 0;
        for(int i=0; i<salesMade; i++){
            if(saleAmounts[i] > threshold)
                count++;
        }
        
        return count;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println("Testing Ledger: ");
        System.out.println("Adding sales 3.52, 2.43, 9.00, 3.5, 5.0");
        
        Ledger sales = new Ledger(10);
        sales.addSale(3.52);
        sales.addSale(2.43);
        sales.addSale(9.0);
        sales.addSale(3.5);
        sales.addSale(5.0);
        
        System.out.println("The total number of sales are: " + sales.getNumberOfSales());
        System.out.println("The total amount of sales is: " + sales.getTotalSales());
        System.out.println("The average sale amount is: " + sales.getAverageSale());
        System.out.println("The number of sales greater than 3.5 is: " + sales.getCountAbove(3.5));
        System.out.println("The number of sales greater than 3.0 is: " + sales.getCountAbove(3.0));
        
        
    }
    
}



