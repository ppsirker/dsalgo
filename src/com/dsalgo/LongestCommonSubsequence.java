/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/longest-common-subsequence.html
*/

package com.dsalgo;

public class LongestCommonSubsequence
{
	public static void main(String[] args)
	{
		String a = "alfkjalfjlkj";
		String b = "ajflaklfjlaj";
		String result = findLCS(a, b);
		System.out.println(result);
	}

	private static String findLCS(String a, String b)
	{
		int[][] memo = new int[a.length() + 1][b.length() + 1];

		for (int i = a.length() - 1; i >= 0; --i)
			for (int j = b.length() - 1; j >= 0; --j)
			{
				if (a.charAt(i) == b.charAt(j))
					memo[i][j] = memo[i + 1][j + 1] + 1;
				else
					memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
			}

		int i = 0;
		int j = 0;

		StringBuffer result = new StringBuffer();
		while (i <a.length() && j <b.length())
		{
			if (a.charAt(i)==b.charAt(j))
			{
				result.append(a.charAt(i));
				i++;
				j++;
			} else if (memo[i+1][j] > memo[i][j+1])
				i++;
			else
				j++;
		}
		return result.toString();
	}
}
