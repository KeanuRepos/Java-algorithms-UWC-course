/*
Keanu Johnston
3851727
7 November 2019
*/

public class removeDuplicates
{
	public static void main(String[] args)
	{
		char[] list = {'b','d','a','b','f','a','g','a','a'}; 
		System.out.println(removeDuplicates(list));
	}
	public static char[] removeDuplicates(char[] in)
	{
		//Display 'in' array
		System.out.println("Original array: ");
		int vCount = 0;
		while(vCount != in.length)
		{
			
			System.out.print(in[vCount]+",");
			vCount++;
		}
		
		//NewArrays
		char[] out = new char[in.length];
		Boolean[] keep = new Boolean[in.length];
		for (int i = 0; i < in.length-1;i++)
		{
			keep[i] = true;
		}
		
		//run through array, and check for dups
		for (int i = 0; i < in.length-1;i++)
		{
			for(int j = i; j < (in.length-1);j++)
			{
				if(in[i] == in[j+1])
				{
					keep[j+1] = false;
				}
				else
				{
					continue;
				}
				
			}
		}
		int count = 0;
		for(int i = 0;i < in.length-1;i++)
		{
			if(keep[i] == false)
			{
				continue;
			}
			else
			{
				
				out[count] = in[i];
				count++;
			}
		}
		return out;
		
	}
}
