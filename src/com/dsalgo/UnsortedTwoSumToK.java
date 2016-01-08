/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/UnsortedTwoSumToK.php.html
*/

package com.dsalgo;

import java.util.HashSet;


public class UnsortedTwoSumToK
{
 public static void main(String[] args)
 {
  int[]arr={6,7,8,9,1,16,2,3,14,13,4,5,12,32,44};
  printIndexesForSumK(arr, 16);
 }
 
 public static void printIndexesForSumK(int[]arr,int k)
 {
  HashSet<Integer> hashSet=new HashSet<Integer>();
  for(int num:arr)
  {
   if(hashSet.contains(k-num))
    System.out.println(num+","+(k-num));
   hashSet.add(num);
  }
 }

}
      
