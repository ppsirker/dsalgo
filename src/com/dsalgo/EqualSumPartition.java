/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/back-to-content-array-equal-sum.html
*/

package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class EqualSumPartition
{
 public static void main(String[] args)
 {
  Integer[] arr ={ 1, 2, 3, 6, 4, 5, 7 };
  System.out.println("Original Array");
  for (Integer num : arr)
  {
   System.out.print(num + ", ");
  }
  System.out.println();

  Integer[][] parts = partition(arr);
  if (parts == null)
  {
   System.out.println("partition not possible");
   return;
  }
  System.out.println("partition");
  for (Integer num : parts[0])
   System.out.print(num + ", ");
  System.out.println();
  for (Integer num : parts[1])
   System.out.print(num + ", ");
 }

 private static Integer[][] partition(Integer[] arr)
 {
  List<Integer> list = new ArrayList<Integer>();
  List<Integer> part = new ArrayList<Integer>();

  int sum = 0;
  for (Integer num : arr)
  {
   list.add(num);
   sum += num;
  }
  if (sum % 2 == 1)
   return null;
  sum /= 2;
  int[][] memo = new int[arr.length + 1][sum + 1];
  for (int i = 1; i <= arr.length; ++i)
  {
   for (int s = 1; s <= sum; ++s)
   {
    if (arr[i - 1] > s
      || memo[i - 1][s] > arr[i - 1]
        + memo[i - 1][s - arr[i - 1]])
     memo[i][s] = memo[i - 1][s];
    else
    {
     memo[i][s] = arr[i - 1] + memo[i - 1][s - arr[i - 1]];
    }
   }
  }
  if (memo[arr.length][sum] != sum)
   return null;
  int i = arr.length;
  int s = sum;
  while (s > 0 && i > 0)
  {
   if (arr[i - 1] <= s
     && memo[i][s] == arr[i - 1] + memo[i - 1][s - arr[i - 1]])
   {
    part.add(arr[i - 1]);
    s = s - arr[i - 1];
   }
   i--;
  }
  for (Integer num : part)
   list.remove(num);
  Integer[][] result = new Integer[2][];
  result[0] = part.toArray(new Integer[] {});
  result[1] = list.toArray(new Integer[] {});
  return result;
 }

}

