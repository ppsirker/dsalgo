/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/back-to-content-find-subset-with-given.html
*/

package com.dsalgo;
import java.util.ArrayList;
import java.util.List;

public class IsAveragePossible
{
	public static void main(String[] args)
	{
		int[] arr =
		{ 1, 4, 5, 3, 8 };
		double average = 3.5;
		for (int i = 1; i <= arr.length; ++i)
		{
			double sum = i * average;
			if (sum == (int) sum)
			{
				List<Integer> result = isSumPossible(arr, (int) sum, i);
				if (result != null)
				{
					for (int num : result)
						System.out.print(num + ", ");
					System.out.println();
					return;
				}
			}
		}

		System.out.println("Not possible");
	}

	private static List<Integer> isSumPossible(int[] arr, int sum, int count)
	{
		boolean[][][] memo = new boolean[arr.length + 1][sum + 1][count + 1];
		memo[0][0][0] = true;

		for (int i = 1; i <= arr.length; ++i)
			for (int j = 1; j <= sum; ++j)
				for (int k = 1; k <= count; ++k)
				{
					if (k == 1 && j == arr[i - 1])
						memo[i][j][k] = true;
					else if (arr[i - 1] > j)
						memo[i][j][k] = memo[i - 1][j][k];
					else
						memo[i][j][k] = memo[i - 1][j][k]
								|| memo[i - 1][j - arr[i - 1]][k - 1];
				}
		if (memo[arr.length][sum][count] == false)
			return null;
		int i = arr.length;
		int j = sum;
		int k = count;
		List<Integer> list = new ArrayList<Integer>();
		while (i > 0 && j > 0 && k > 0)
		{
			if (memo[i][j][k] == memo[i - 1][j][k])
			{

			} else if (k == 1 && j == arr[i - 1])
			{
				list.add(arr[i - 1]);
				break;
			} else if (arr[i - 1] <= j
					&& memo[i][j][k] == memo[i - 1][j - arr[i - 1]][k - 1])
			{
				j = j - arr[i - 1];
				k = k - 1;
				list.add(arr[i - 1]);
			}
			i--;
		}
		return list;
	}
}
