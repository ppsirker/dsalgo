/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/CalculatePower.php.html
*/

package com.dsalgo;

public class CalculatePower
{
 public static void main(String[] args)
 {
  int x = 4;
  int y = 10;
  long power = x;
  long answer = 1;
  while (y != 0)
  {
   if ((y & 1) == 1)
   {
    answer *= power;
   }
   y >>= 1;
   power *= power;
  }
  System.out.println(answer);
 }
}
     
