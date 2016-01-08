/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/MaxKUsingMinHeap.php.html
*/

package com.dsalgo;

import java.util.PriorityQueue;

public class MaxKUsingMinHeap
{
 public static void main(String[] args)
 {
  int[] arr =
  { 3, 46, 2, 56, 3, 38, 93, 45, 6, 787, 34, 76, 44, 6, 7, 86, 8, 44, 56 };
  int[] result = getTopElements(arr, 5);
  for (int i : result)
  {
   System.out.print(i + ",");
  }
 }

 public static int[] getTopElements(int[] arr, int k)
 {
  PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
  for (int i = 0; i < arr.length; ++i)
  {
   int currentNum = arr[i];
   if (minHeap.size() < k)
    minHeap.add(currentNum);
   else if (currentNum > minHeap.peek())
   {
    minHeap.poll();
    minHeap.add(currentNum);
   }
  }
  int[] result = new int[minHeap.size()];
  int index = 0;
  while (!minHeap.isEmpty())
  {
   result[index++] = minHeap.poll();
  }
  return result;
 }
}
        
