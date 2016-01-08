/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/same-average-subset.html
*/

package com.dsalgo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SameAverageSubset
{
	public static void main(String[] args)
	{
		int[] input =
		{ 4, 1, 7, 8, 3, 5 };
		ArrayList<SumCountPair> table = new ArrayList<SumCountPair>();
		HashMap<Double, List<SumCountPair>> hashMap = new HashMap<Double, List<SumCountPair>>();
		for (int i = 0; i < input.length; ++i)
		{
			int num = input[i];
			ArrayList<SumCountPair> tempTable = new ArrayList<SumCountPair>();
			for (SumCountPair j : table)
			{
				SumCountPair temp = j.clone();
				temp.add(num);
				tempTable.add(temp);
			}
			table.addAll(tempTable);
			SumCountPair sumCountPair = new SumCountPair();
			sumCountPair.add(num);
			table.add(sumCountPair);
		}
		for (SumCountPair j : table)
		{
			List<SumCountPair> temp = hashMap.get(j.average());
			if (temp != null)
			{
				temp.add(j);
			} else
			{
				temp = new ArrayList<SumCountPair>();
				temp.add(j);
			}
			hashMap.put(j.average(), temp);
		}
		for (Double average : hashMap.keySet())
		{
			List<SumCountPair> list = hashMap.get(average);
			if (list.size() == 1)
				continue;
			System.out.print(average + " ");
			for (SumCountPair sumCountPair : list)
				System.out.print(sumCountPair + ", ");
			System.out.println();
		}

	}

}

class SumCountPair
{
	int sum;
	int count;
	ArrayList<Integer> array;

	public SumCountPair()
	{
		this(0, 0);
	}

	public SumCountPair(int sum, int count)
	{
		this(sum, count, new ArrayList<Integer>());
	}

	@SuppressWarnings("unchecked")
	public SumCountPair(int sum, int count, ArrayList<Integer> array)
	{
		this.sum = sum;
		this.count = count;
		this.array = (ArrayList<Integer>) array.clone();
	}

	@Override
	public SumCountPair clone()
	{
		return new SumCountPair(sum, count, array);
	}

	public void add(int num)
	{
		sum += num;
		count++;
		array.add(num);
	}

	public double average()
	{
		return (double) sum / count;
	}

	public String toString()
	{
		return array.toString();
	}
}
