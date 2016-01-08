/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/count-number-of-ones-till-n-in-binary.html
*/

package com.dsalgo;

public class NumberOfOnes
{

 /**
  * given n find the total number of ones in the binary representation of
  * numbers 1,2,3,...,n
  * 
  * @param args
  */
 public static void main(String[] args)
 {
  System.out.println(getNumberOfOnes(30));
 }

 public static int getNumberOfOnes(int num)
 {
  int p = 1, cnt = 0;

  if ((num & 1) != 0)
   cnt++;

  while (1 << (p - 1) < num)
  {
   if ((num & (1 << p)) != 0)
    cnt += (1 << (p - 1)) * (p) + num % (1 << p) + 1;
   p++;
  }
  return cnt;
 }

}

