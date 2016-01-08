/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/does-any-path-adds-up-to-given-sum.html
*/

package com.dsalgo;

public class SumPossibleAlongPathBinaryTree
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
  a.left = b;
  a.right = c;
  b.left = d;
  c.left = e;
  c.right = f;
  f.left = g;

  boolean result = isSumPossibleAlongAnyPath(a, 18);
  System.out.println(result);
 }

 private static boolean isSumPossibleAlongAnyPath(Node a, int k)
 {
  return isSumPossibleAlongAnyPath(a, k, k);
 }

 private static boolean isSumPossibleAlongAnyPath(Node a, int k,int originalK)
 {
  if (k == 0)
   return true;
  if (a == null)
   return false;
  return isSumPossibleAlongAnyPath(a.left, k - a.value,originalK)
    || isSumPossibleAlongAnyPath(a.right, k - a.value,originalK)
    || isSumPossibleAlongAnyPath(a.left,originalK,originalK)
    || isSumPossibleAlongAnyPath(a.right, originalK,originalK);
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


