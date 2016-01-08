/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/MaximumSumUptoKRecursive.php.html
*/

package com.dsalgo;

public class MaximumSumUptoKRecursive
{
 public static void main(String[] args)
 {
  int[]arr={4,6,3,9};
  System.out.println(getMaxSum(arr, 14));
 }
 public static int getMaxSum(int[]arr,int k)
 {
  Integer[][]memo=new Integer[arr.length+1][k+1];
  return getMaxSum(memo,arr,0,k);
 }
 private static int getMaxSum(Integer[][]memo,int[]arr,int i,int k)
 {
  if(i==arr.length)
  {
   return 0;
  }
  if(memo[i][k]!=null)
  {
   return memo[i][k];
  }
  if(arr[i]>k)
  {
   memo[i][k]=getMaxSum(memo,arr, i+1, k);
   return memo[i][k];
  }
  memo[i][k]=Math.max(getMaxSum(memo,arr,i+1,k), getMaxSum(memo,arr,i+1,k-arr[i])+arr[i]);
  return memo[i][k];
 }

}
        
