/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/AnyNumberSumUptoK.php.html
*/

package com.dsalgo;

public class AnyNumberSumUptoK
{

 public static void main(String[] args)
 {
  int[]arr={4,6,2,8};
  System.out.println(isSumPossible(arr,22));
 }

 public static boolean isSumPossible(int[] arr, int k)
 {
  boolean[][] memo=new boolean[arr.length+1][k+1];
  for(int i=1;i<=arr.length;++i)
  {
   for(int w=1;w<=k;++w)
   {
    if(w==arr[i-1])
     memo[i][w]=true;
    else if(w>arr[i-1])
     memo[i][w]=memo[i-1][w]||memo[i-1][w-arr[i-1]];
    else
     memo[i][w]=memo[i-1][w];
   }
  }
  return memo[arr.length][k];
 }
}
        
