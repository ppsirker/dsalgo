/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/back-to-content-increasing-array.html
*/

package com.dsalgo;
import java.util.ArrayList;

public class IncreasingArraySubsequence
{

	/**
	 * create subsequence of a given array where every element in the
	 * subsequence is greater than its previous element
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] input =
		{ 2, 5, 6, 1, 3 };
		int length = input.length;
		ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < length; ++i)
		{
			ArrayList<ArrayList<Integer>> tempTable = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> j : table)
			{
				if (j.get(j.size() - 1) <= input[i])
				{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(j);
					temp.add(input[i]);
					tempTable.add(temp);
				}
			}
			table.addAll(tempTable);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(input[i]);
			table.add(temp);
		}

		// output
		for (ArrayList<Integer> i : table)
		{
			for (Integer j : i)
			{
				System.out.print(j + ", ");
			}
			System.out.println();
		}
	}

}
