/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/rotate-array-k-times-to-left.html
*/

package com.dsalgo;


public class RotateKTimes
{
 public static void main(String[] args)
 {
  int[] array =
  { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
  printArray(array);
  rotateLeftKTimes(array, 7);
  printArray(array);
 }

 private static void rotateLeftKTimes(int[] array, int k)
 {
  reverse(array, 0, array.length - 1);
  reverse(array, 0, array.length - k - 1);
  reverse(array, array.length - k, array.length - 1);
 }

 private static void reverse(int[] array, int i, int j)
 {
  while (i < j)
  {
   int temp = array[i];
   array[i] = array[j];
   array[j] = temp;
   i++;
   j--;
  }
 }

 private static void printArray(int[] array)
 {
  for (int i : array)
   System.out.print(i + ",");
  System.out.println();

 }

}


