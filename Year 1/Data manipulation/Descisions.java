import java.util.Scanner;
class Descisions{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        in.close();
        System.out.println("Enter your age: ");
        int age = in.nextInt();
        //relational operations
        if (age<2)
        {
            System.out.println("Infant");
        }  
        else if(age<12)
        {
            System.out.println("Child");
        }
        else if(age<20)
        {
            System.out.println("Teen");
        }
        else if(age<65)
        {
            System.out.println("Adult");
        }
        else{
            System.out.println("Senior"); 
        }
    }
}