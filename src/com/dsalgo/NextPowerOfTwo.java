/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/next-power-of-two.html
*/

package com.dsalgo;

public class NextPowerOfTwo
{
 public static void main(String[] args)
 {
  long num = 128;
  long result = findNextPowerOfTwo(num);
  System.out.println(result);
 }

 private static long findNextPowerOfTwo(long num)
 {
  long result = 1;
  while (num != 0)
  {
   num >>= 1;
   result <<= 1;
  }
  return result;
 }
}

        
