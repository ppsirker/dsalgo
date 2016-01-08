/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/maximum-sum-along-any-path-of-binary.html
*/

package com.dsalgo;

public class MaxSumTreePathPositive
{
 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(6);
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
  if (root == null)
   return 0;
  return root.value
    + Math.max(findMaxSum(root.left), findMaxSum(root.right));
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

