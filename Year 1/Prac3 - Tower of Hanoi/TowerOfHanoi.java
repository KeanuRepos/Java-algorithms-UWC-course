/*
Keanu Johnston
3851727
7 November 2019
*/

/*
This Program implements the Tower of Hanoi of
3 disks
*/

import java.util.*;
public class TowerOfHanoi
{
	public static void main(String[] args)
	{
		moveTowers(3,'A','B','C');
	}
	
	public static void moveTowers(int n,char A,char B,char C)
	{
		if (n == 1)//base case
		{
			System.out.println("Move a disk from rod " + A + " to rod " + C);
		}else
		{
			moveTowers(n-1,A,C,B);
			System.out.println("Move a disk from rod " + A + " to rod " + B);
			moveTowers(n-1,B,A,C);
		}
	}
}