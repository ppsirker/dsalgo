/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/swap-without-temp.html
*/

package com.dsalgo;

public class SwapWithoutTemp
{
 public static void main(String[] args)
 {
  int a = 5;
  int b = 6;
  a = a ^ b;
  b = a ^ b;
  a = a ^ b;
  System.out.println(a);
  System.out.println(b);
 }
}

