/**
 * CSC212 Prac 1 - Algorithm and complexity
 * Student no: 3851727
 * Author: Keanu Johnston
 */
import java.util.*;
import java.io.*;
public class A_Analysis{
    static String[] arrSchl ; //global variable
    
    //********************** i) Open and read Input******************************
    static void readInput() {
        arrSchl = new String[132]; 
        BufferedReader buff = null;
        String line;

        try{
            buff = new BufferedReader(new FileReader("Soweto.csv"));
            line = buff.readLine();
            int i = 0;
            while((line = buff.readLine())!= null){ 
                final String[] fileData = line.split(";",0);
                arrSchl[i] = fileData[0]; //store name of school in arrSchl
				i++;
            }
            buff.close();
        }catch(IOException e){
            System.out.println("\n-----Unable to read file and popluate array-----\n");
			e.printStackTrace();
        }
        System.out.println("\n-----File read and array popluated.-----\n");
    }
    //*******************ii.a) Merge Sort(iterative) function**********************
    static void mergeSortArr(String a[], int b){ //where a is the parameter array and b the size of a.
        
        int sub_size; //varies from 1 to n/2
        int left_initial; // initial index of left subarray to be merged

        for (sub_size = 1; sub_size <= b-1; sub_size = 2*sub_size){
            //choose initial index of different subarrays of sub size
            for (left_initial = 0; left_initial < b-1; left_initial += 2*sub_size){
                //find final index of left sub array
                int mid = Math.min(left_initial + sub_size - 1, b-1);

                int right_end = Math.min(left_initial + 2*sub_size - 1, b-1);

                //Merge subarrays arr[left_initial...mid]
                //& arr[mid+1...right_end]
                merge(a, left_initial, mid, right_end);
            }
        }
        }
         // Function to merge the two halves a[1..m] and 
         // a[m+1..r] of array a[]
        static void merge(String a[], int l, int m, int r){
            int i, j, k;
            int n1 = m - l + 1;
            int n2 = r - m;

            String L[] = new String[n1];
            String R[] = new String[n2];

            // Copy data to temp arrays L[] and R[]
            for (i = 0; i <  n1; i++)
                L[i] = a[ l + i ];
            for(j = 0; j < n2; j++)
                R[j] = a[m + 1 + j];

            //Merge the temp arrays back into a[l..r]
            i = 0;
            j = 0;
            k = l;
            while (i < n1 && j < n2){
                if (L[i].compareTo(R[j]) <= 0){
                    a[k] = L[i];
                    i++;
                }
                else{
                    a[k] = R[j];
                    j++;
                }
                k++;
            }
            //if there are remaining elements of L[], Copy the remaining elements of L[]
            while(i < n1){
                a[k] = L[i];
                i++;
                k++;
            }
            //if there are remaining elements of R[], Copy the remaining elements of R[]
            while(j < n2){
                a[k] = R[j];
                j++;
                k++;
            }
        }
		
		//******************ii.b) Quick Sort (iterative) function*****************
		static int partition(String a[],int low, int high){
			
			String p = a[high]; //where p denotes the pivot point
			
			int i = (low -1); //position of smaller element
			for (int j = low; j <= high - 1; j++){
				if(a[j].compareTo(p)<=0){
					i++;
					//swap elements in a[]
					String temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
					
			}
			
			// swap a[i+1] and pivot
			String temp = a[i + 1];
			a[i + 1] = a[high];
			a[high] = temp;
			
			return i + 1;
		}
		//method that implements the quicksort(Iterative)
		//a[] --> array that needs to be sorted
		//sI --> starting index
		//eI --> ending index
		static void qSort(String a[], int sI, int eI){
			
			int[] stack = new int[eI - sI + 1];// aux. stack
			
			int t = -1; // init. top of stack(t)
			
			// push values of indexes to stack
			stack[++t] = sI;
			stack[++t] = eI;
				
			//Pop stack until empty
			while(t >= 0){
				//Pop eI and sI
				eI = stack[t--];
				sI = stack[t--];
				
				//set pivot into sorted array
				int p = partition(a, sI, eI); 
				
				// if elements on the left side of pivot, push left side to stack
				if (p - 1 > sI){
					stack[++t] = sI;
					stack[++t] = p - 1;
				}
				
				// if elements on the left side of pivot, push left side to stack
				if (p + 1 < eI){
					stack[++t] = p + 1;
					stack[++t] = eI;
				}
			}
		}
        //method to print an array
        static void printArr(String a[], int size){
            int i;
            for (i=0; i < size; i++)
                System.out.println(a[i]);
            System.out.println("\n");
        }
		//method that writes output to textfile
		static void wFile(Long t){
			
			//calc. number of elem in array.
			String line ="";
			int c=0; // array counter
			while ((line = arrSchl[c]) != null){//counts the number of elements in array
				c++;
			}
			
			try{
			String outpStr = "";
			outpStr = outpStr + "time in milliseconds: " + t +"\n";
			outpStr = outpStr + "Result [";
			String temp = "";
			for(int i=0; i<c; i++){
				if(i == (c-1)){
					temp = temp + arrSchl[i];
					break;
				}else{
					temp = temp + arrSchl[i] + ", ";
				}	
			}
			String fOutput = outpStr + temp + "]";
			//where w denotes writer
			BufferedWriter w = new BufferedWriter(new FileWriter("Sorted Schools.txt",true)); 
			w.write(fOutput);
			w.write("\n\n");
			System.out.println("\nFile written to textfile named, Sorted Schools.txt");
			w.close();
			
		}catch(IOException e){
			System.out.println("\n-----Unable to write output of program to textfile - please try again-----\n");
			e.printStackTrace();
		}
		}
        // Driver method
	public static void main(String[] args)
	{
		//*****MergeSort(Iterative)*****
		
		//*****store input from Soweto.csv file into an array*****
		readInput();
		
		String line ="";
		int c=0; // array counter
		
		while ((line = arrSchl[c]) != null){//counts the number of elements in array
			c++;
		}
		
		//*****MergeSort(Iterative) implementation*****
		System.out.println("\n-----MergeSort(Iterative)-----\n");
		System.out.println("\n-----Given array is-----\n");
		
		//print array to cmd
		printArr(arrSchl,c);
		
		//Timer t1 = new Timer();
		Long ti1= System.currentTimeMillis();//where ti denotes starting time
		mergeSortArr(arrSchl,c);
		Long te1 = System.currentTimeMillis(); //where te denotes time elapsed
		
		//print array to cmd
		System.out.println("-----Sorted array is-----\n");
		Long t1 = te1-ti1;
		printArr(arrSchl,c);
		System.out.print("Elapsed time for MergeSort(Iterative): " + t1);
		
		//**Write output to textfile**
		wFile(t1); // this methods writes the output of the sorted array to a textfile.
		
		
		//***** QuickSort(Iterative)*****
		
		//*****store input from Soweto.csv file into an array*****
		readInput();
		
		line ="";
		c=0; // array counter
		while ((line = arrSchl[c]) != null){//counts the number of elements in array
			c++;
		}
		
		//***** QuickSort(Iterative) implemention*****
		System.out.println("\n-----QuickSort(Iterative)-----\n");
		System.out.println("\n-----Given array is-----\n");
		
		//print array to cmd
		printArr(arrSchl,c);
		
		//Timer t2 = new Timer();
		Long ti2 = System.currentTimeMillis();//where ti denotes starting time
		qSort(arrSchl,0, c - 1);
		Long te2 = System.currentTimeMillis(); //where te denotes time elapsed
	
		//print array to cmd
		System.out.println("-----Sorted array is-----\n");
		printArr(arrSchl, c);
		Long t2 = te2-ti2;
		System.out.print("Elapsed time for QuickSort(Iterative): " + t2);
		
		//**Write output to textfile**
		wFile(t2); // this methods writes the output of the sorted array to a textfile.
	}

}