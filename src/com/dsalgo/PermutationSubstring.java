/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/permutation-of-string-as-substring-of.html
*/

package com.dsalgo;
import java.util.HashMap;

public class PermutationSubstring
{
	public static void main(String[] args)
	{
		String a = "encyclopedia";
		String b = "dope";
		System.out.println(isPermutationSubstring(a, b));
	}

	private static boolean isPermutationSubstring(String a, String b)
	{
		if (a.length() < b.length())
			return false;
		int sameLetterPositive = b.length();
		int sameLetterNegative = 0;
		int otherLetter = 0;
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (char ch : b.toCharArray())
		{
			if (hashMap.containsKey(ch))
			{
				hashMap.put(ch, hashMap.get(ch) + 1);
			} else
			{
				hashMap.put(ch, 1);
			}
		}
		for (int i = 0; i < b.length(); ++i)
		{
			char ch = a.charAt(i);
			if (hashMap.containsKey(ch))
			{
				int count = hashMap.get(ch);
				hashMap.put(ch, count - 1);
				if (count == 0)
					sameLetterNegative++;
				else
					sameLetterPositive--;
			} else
			{
				otherLetter--;
			}
		}
		if (sameLetterPositive == 0 && sameLetterNegative == 0
				&& otherLetter == 0)
			return true;
		for (int i = b.length(); i < a.length(); ++i)
		{
			char inclusion = a.charAt(i);
			char exclusion = a.charAt(i - b.length());
			if (hashMap.containsKey(exclusion))
			{
				int count = hashMap.get(exclusion);
				hashMap.put(exclusion, count + 1);
				if (count == -1)
					sameLetterNegative--;
				else
					sameLetterPositive++;
			} else
			{
				otherLetter++;
			}
			if (hashMap.containsKey(inclusion))
			{
				int count = hashMap.get(inclusion);
				hashMap.put(inclusion, count - 1);
				if (count == 0)
					sameLetterNegative++;
				else
					sameLetterPositive--;
			} else
			{
				otherLetter--;
			}
			if (sameLetterPositive == 0 && sameLetterNegative == 0
					&& otherLetter == 0)
				return true;
		}
		return false;
	}
}
