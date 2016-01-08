/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-kth-largest-element-in-sorted.html
*/

package com.dsalgo;


public class KthLargestSortedMatrix
{
 public static void main(String[] args)
 {
  int[][] matrix =
  {
  { 5, 7, 8, 9 },
  { 6, 9, 10, 13 },
  { 7, 11, 12, 15 },
  { 8, 13, 16, 17 } };
  int result = findKthLargest(matrix, 8);
  System.out.println(result);
 }

 private static int findKthLargest(int[][] matrix, int k)
 {
  for (int i = 0; i < k - 1; ++i)
   reArrange(matrix, matrix.length - 1, matrix[0].length - 1);
  return matrix[matrix.length - 1][matrix[0].length - 1];
 }

 private static void reArrange(int[][] matrix, int row, int col)
 {
  int newRow = 0;
  int newCol = 0;
  if (row == 0 && col == 0)
  {
   matrix[row][col] = Integer.MIN_VALUE;
   return;
  } else if (row == 0)
  {
   newRow = row;
   newCol = col - 1;
  } else if (col == 0)
  {
   newRow = row - 1;
   newCol = col;
  } else if (matrix[row][col - 1] > matrix[row - 1][col])
  {
   newRow = row;
   newCol = col - 1;
  } else
  {
   newRow = row - 1;
   newCol = col;
  }
  matrix[row][col] = matrix[newRow][newCol];
  reArrange(matrix, newRow, newCol);
 }

}

        
