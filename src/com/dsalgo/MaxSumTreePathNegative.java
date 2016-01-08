/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/maximum-sum-along-any-tree-path-with.html
*/

package com.dsalgo;

public class MaxSumTreePathNegative
{
 public static void main(String[] args)
 {
  Node a = new Node(4);
  Node b = new Node(-2);
  Node c = new Node(-1);
  Node d = new Node(6);
  Node e = new Node(-5);
  Node f = new Node(-2);
  Node g = new Node(7);
  Node h = new Node(8);
  a.left = b;
  a.right = c;
  b.left = d;
  c.left = e;
  c.right = f;
  f.left = g;
  f.right = h;
  int maxSum = findMaxSum(a);
  System.out.println(maxSum);
 }

 private static int findMaxSum(Node root)
 {
  int[] localMax = new int [1];
  int[] globalMax = new int [1];
  findMaxSum(root, localMax, globalMax);
  return globalMax[0];
 }

 private static void findMaxSum(Node root, int[] localMax, int[] globalMax)
 {
  if (root == null)
  {
   localMax[0]=0;
   return;
  }
  localMax[0]=0;
  findMaxSum(root.left, localMax, globalMax);
  int leftLocal=localMax[0];
  localMax[0]=0;
  findMaxSum(root.right, localMax, globalMax);
  int rightLocal=localMax[0];
  int maxLocal=Math.max(leftLocal,rightLocal);
  if(maxLocal+root.value > 0)
  {
   localMax[0]=maxLocal+root.value;
   if(globalMax[0] < localMax [0])
    globalMax[0] = localMax [0];
  }
  else
  {
   localMax[0]=0;
  }
 }

 static class Node
 {
  Node left;
  Node right;
  int value;

  public Node(int value)
  {
   this.value = value;
  }
 }

}

