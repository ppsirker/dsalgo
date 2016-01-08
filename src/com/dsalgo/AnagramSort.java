/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/sort-to-bring-anagrams-closer.html
*/

package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnagramSort
{
	public static void main(String[] args)
	{
		String[]arr={"dog","listen","tip","enlist","pit","god","man","top","pot"};
		sort(arr);
		for(String str:arr)
		{
			System.out.println(str);
		}
	}

	private static void sort(String[] arr)
	{
		List<Anagram> list=new ArrayList<Anagram>();
		for(String str:arr)
		{
			list.add(new Anagram(str));
		}
		Collections.sort(list);
		for(int i=0;i<arr.length;++i)
		{
			arr[i]=list.get(i).str;
		}
	}
	public static class Anagram implements Comparable<Anagram>
	{
		String str;
		public Anagram(String str)
		{
			this.str=str;
		}
		public String getSortedString()
		{
			char[]arr=str.toCharArray();
			Arrays.sort(arr);
			return new String(arr);
		}
		@Override
		public int compareTo(Anagram o)
		{
			return getSortedString().compareTo(o.getSortedString());
		}
	}
}
