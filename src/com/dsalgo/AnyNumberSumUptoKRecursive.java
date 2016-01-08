/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/AnyNumberSumUptoKRecursive.php.html
*/

package com.dsalgo;

public class AnyNumberSumUptoKRecursive
{
 public static void main(String[] args)
 {
  int [] arr={3,5,6,2};
  System.out.println(isSumPossible(arr, 13));
 }
 
 public static boolean isSumPossible(int[]arr, int k)
 {
  Boolean [][]memo=new Boolean[arr.length+1][k+1];
  return isSumPossible(memo,arr,0,k);
 }
 
 private static boolean isSumPossible(Boolean[][]memo, int[]arr,int i,int k)
 {
  if(memo[i][k]!=null)
   return memo[i][k];
  if(i==arr.length-1)
  {
   if(arr[i]==k||k==0)
    return true;
   else
    return false;
  }
  if(arr[i]>k)
  {
   memo[i][k]=isSumPossible(memo,arr,i+1,k);
   return memo[i][k];
  }
  memo[i][k]=isSumPossible(memo,arr,i+1,k-arr[i])||isSumPossible(memo,arr, i+1, k);
  return memo[i][k];
 }

}
        
