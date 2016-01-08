/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/LeastDifference.php.html
*/

package com.dsalgo;

import java.util.Arrays;


public class LeastDifference
{
 public static void main(String[] args)
 {
  int[]arr={64,57,2,78,43,73,53,86};
  Arrays.sort(arr);
  int minDiff=Integer.MAX_VALUE;
  for(int i=0;i < arr.length-1;++i)
  {
   int diff=Math.abs(arr[i]-arr[i+1]);
   if(diff < minDiff)
    minDiff=diff;
  }
  System.out.println(minDiff);
 }
}
      
