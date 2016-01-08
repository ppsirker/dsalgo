/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/print-binary-tree-from-bottom-to-top.html
*/

package com.dsalgo;

import java.util.LinkedList;
import java.util.Stack;

public class PrintBinartyTreeBottomToTopContinuous
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

  printLevelFromBottomToTop(a);
 }

 
 private static void printLevelFromBottomToTop(Node root)
 {
  LinkedList<Node> queue=new LinkedList<Node>();
  Stack<Node> stack=new Stack<Node>();
  queue.add(root);
  while(!queue.isEmpty())
  {
   Node node=queue.poll();
   stack.push(node);
   if(node.right!=null)
   {
    queue.add(node.right);
   }
   if(node.left!=null)
   {
    queue.add(node.left);
   }
  }
  while(!stack.isEmpty())
  {
   System.out.print(stack.pop().value+", ");
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
        
