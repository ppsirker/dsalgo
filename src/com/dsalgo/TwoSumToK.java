/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/TwoSumToK.php.html
*/

package com.dsalgo;

public class TwoSumToK
{
 public static void main(String[] args)
 {
  int[]arr={1,2,3,4,5,6,7,8,9,12,13,14,16,32,44};
  printIndexesForSumK(arr, 16);
 }
 
 public static void printIndexesForSumK(int[]arr,int k)
 {
  int startIndex=0;
  int endIndex=arr.length-1;
  while(startIndex<endIndex)
  {
   int sum=arr[startIndex]+arr[endIndex];
   if(sum==k)
   {
    System.out.println(arr[startIndex]+","+arr[endIndex]);
    startIndex++;
    endIndex--;
   }
   else if (sum<k)
    startIndex++;
   else if(sum>k)
    endIndex--;
  }
 }

}
   
