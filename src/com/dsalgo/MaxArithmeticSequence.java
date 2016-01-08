/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/04/maximum-arithmetic-sequence-in-array.html
*/
package com.dsalgo;

public class MaxArithmeticSequence {

	public static void main(String[] args) {
		int[]arr={2,5,3,6,9,12,15,34,23};
		findMaxArithmeticSequence(arr);
	}

	private static void findMaxArithmeticSequence(int[] arr) {
		int maxLength=0;
		int currentLength=0;
		int prevDiff=0;
		for(int i=1;i<arr.length;++i)
		{
			if(i==1)
			{
				prevDiff=arr[i]-arr[0];
				currentLength=maxLength=2;
				continue;
			}
			if(prevDiff==arr[i]-arr[i-1])
			{
				currentLength++;
				if(currentLength>maxLength)
					maxLength=currentLength;
			}
			else
			{
				currentLength=2;
				prevDiff=arr[i]-arr[i-1];
			}
		}
		System.out.println("max arithmetic sequence length = "+maxLength);
	}

}
