/**
 File name: BubbleSortDemo.java

 A class to demonstrate BubbleSort method.
 
 It uses the BubbleSort class method to sort an array of
     integers in ascending order.

 Precondition: Every element of the array has a value.

 Based on: SelectionSortDemo.java, Listing 7.11.

 Written by: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 7/3/99
 Changes: 09/01/2000 Prologue: email address & Display info.
          03/13/2003 Made comments like text examples.
*/
public class BubbleSortDemo
{
    public static void main(String[] args)
    {
        int[] b = {7, 5, 11, 2, 16, 4, 18, 14, 12, 30};

        System.out.println("Array values before sorting:");
        int i;
        
        for (i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        
        System.out.println();

        BubbleSort.sort(b);

        System.out.println("Array values after sorting:");
        for (i = 0; i < b.length; i++)
            System.out.print(b[i] + " ");
        
        System.out.println();
    }
}