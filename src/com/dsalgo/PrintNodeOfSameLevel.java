/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/print-nodes-of-given-level.html
*/

package com.dsalgo;


public class PrintNodeOfSameLevel
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

  printLevelofDepth(a, 5);
 }

 private static void printLevelofDepth(Node a, int depth)
 {
  if (a == null)
   return;
  if (depth == 1)
  {
   System.out.println(a.value);
   return;
  }
  printLevelofDepth(a.left, depth - 1);
  printLevelofDepth(a.right, depth - 1);
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


        
