/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/maximum-sum-submatrix.html
*/

package com.dsalgo;

public class LargestSumSubMatrix
{
 public static void main(String[] args)
 {
  int[][] arr =
  {
  { 1, -2, -7, 0 },
  { -6, 2, 9, 2 },
  { -4, -2, -1, 4 },
  { -1, -8, 0, -4 } };
  int[] leftRightTopBottom = new int[4];
  int maxsum = findMaximumSumSubMatrix(arr, leftRightTopBottom);
  System.out.println("max sum: " + maxsum);
  System.out.println("indices left right top bottom");
  for (int index : leftRightTopBottom)
   System.out.print(index + ",");
 }

 private static int findMaximumSumSubMatrix(int[][] arr,
   int[] leftTopRightBottom)
 {
  leftTopRightBottom[0] = 0;
  leftTopRightBottom[1] = 0;
  leftTopRightBottom[2] = 0;
  leftTopRightBottom[3] = 0;
  int rows = arr.length;
  int cols = arr[0].length;
  int[] sum = new int[cols];
  int[] pos = new int[cols];
  int localMax;
  int maxSum = arr[0][0];
  int[][] verticalSum = new int[rows][cols];

  for (int iRow = 0; iRow < rows; iRow++)
  {
   for (int jCol = 0; jCol < cols; jCol++)
   {
    if (jCol == 0)
    {
     verticalSum[jCol][iRow] = arr[jCol][iRow];
    } else
    {
     verticalSum[jCol][iRow] = arr[jCol][iRow]
       + verticalSum[jCol - 1][iRow];
    }
   }
  }

  for (int iRow = 0; iRow < rows; iRow++)
  {
   for (int k = iRow; k < rows; k++)
   {
    for (int index = 0; index < cols; index++)
    {
     sum[index] = 0;
     pos[index] = 0;
    }
    localMax = 0;
    int tmp = 0;
    if (iRow > 0)
    {
     tmp = verticalSum[iRow - 1][0];
    }
    sum[0] = verticalSum[k][0] - tmp;
    for (int j = 1; j < cols; j++)
    {
     tmp = 0;
     if (iRow > 0)
     {
      tmp = verticalSum[iRow - 1][j];
     }
     if (sum[j - 1] > 0)
     {
      sum[j] = sum[j - 1] + verticalSum[k][j] - tmp;
      pos[j] = pos[j - 1];
     } else
     {
      sum[j] = verticalSum[k][j] - tmp;
      pos[j] = j;
     }
     if (sum[j] > sum[localMax])
     {
      localMax = j;
     }
    }
    if (sum[localMax] > maxSum)
    {
     maxSum = sum[localMax];
     leftTopRightBottom[0] = pos[localMax];
     leftTopRightBottom[1] = localMax;
     leftTopRightBottom[2] = iRow;
     leftTopRightBottom[3] = k;
    }
   }
  }
  return maxSum;
 }
}

