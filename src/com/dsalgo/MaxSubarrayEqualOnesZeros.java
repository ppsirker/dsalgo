/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/longest-subarray-with-equal-number-of.html
*/

package com.dsalgo;

public class MaxSubarrayEqualOnesZeros
{
 public static void main(String[] args)
 {
  int[] arr =
  { 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1,
    0, 1, 1, 0, 1, 0, 0, 0 };
  printMaxSubarray(arr);
 }

 private static void printMaxSubarray(int[] arr)
 {
  Integer[] diffMap = new Integer[arr.length * 2 + 1];
  diffMap[arr.length] = -1;
  int sum = 0;
  int maxLength = 0;
  int maxStart = -1;
  int maxEnd = -1;
  for (int i = 0; i < arr.length; ++i)
  {
   if (arr[i] == 0)
    sum -= 1;
   else
    sum += 1;
   Integer prevIndex = diffMap[arr.length + sum];
   if (prevIndex == null)
    diffMap[arr.length + sum] = i;
   else
   {
    if (i - prevIndex > maxLength)
    {
     maxLength = i - prevIndex;
     maxStart = prevIndex + 1;
     maxEnd = i;
    }
   }
  }
  System.out.println("indices (" + maxStart + "," + maxEnd + ")");
  System.out.println("length=" + maxLength);
 }
}

