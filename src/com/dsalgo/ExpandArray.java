/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/expand-array.html
*/

package com.dsalgo;

public class ExpandArray
{
 public static void main(String[] args)
 {
  char[] arr = "a2b1c1d1e4f0g11                 ".toCharArray();
  expand(arr);
  for (char ch : arr)
   System.out.print(ch);
 }

 private static void expand(char[] arr)
 {
  expand(arr, 0, 0);
 }

 private static void expand(char[] arr, int startReading, int startWriting)
 {
  char ch = arr[startReading++];
  if (ch == ' ')
   return;
  int count = 0;
  while (Character.isDigit(arr[startReading]))
  {
   count = count * 10 + arr[startReading] - 48;
   startReading++;
  }
  expand(arr, startReading, startWriting + count);
  for (int i = 0; i < count; ++i)
   arr[startWriting + i] = ch;
 }
}

