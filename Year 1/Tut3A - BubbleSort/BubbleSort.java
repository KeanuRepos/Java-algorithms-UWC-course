/**
 File name: BubbleSort.java

 A class to sort an array of integers. Returns the elements of
     the original array, but in ascending order.

 Precondition: Every element of the array has a value.

 Based on SelectionSort, Listing 7.10.

 Written by: Lew Rakocy
 email address: LRakocy@devrycols.edu
 Date: 10/7/2000
 Changes: 03/13/2003 Made comments look like text examples.
*/
public class BubbleSort
{
    public static void sort(int[] a)
    {
        // Sorted flag will be made true before each pass through
        // the array and changed to false if a swap occurs
        // during the pass. If it remains true then no swap
        // occurred and the array must be sorted.
        // It is initialized to false here to enter the while loop.

        boolean sorted = false;

        // Each pass through the for-loop puts the next element in
        // its proper place (it bubbles up to the highest unsorted
        // position) and reduces by 1 the number of array elements
        // to process in the next iteration.

        int iterations = a.length - 1;    // Max number of passes

        while(!sorted && iterations > 0)
        {
            // Set flag to indicate sorted and change to false
            // if a swap occurs.

            sorted = true;
            for (int i = 0; i < iterations; ++i)
            {
                if(a[i] > a[i + 1])
                {
                    // Swap: bubble largest value up
                    // to highest position

                    interchange(i, a);
                    sorted = false;
                }
            }
            --iterations;
        }
    }

    /**
     Precondition: i and i+1 are legal indexes for the array a.
     Postcondition:
     The values of a[i] and a[i+1] have been interchanged.
    */
    private static void interchange(int i, int[] array)
    {
		int temp;
		temp = 0;
        temp = array[i];
		array[i] = array[i+1];
		array[i+1] = temp;
		
    }
}