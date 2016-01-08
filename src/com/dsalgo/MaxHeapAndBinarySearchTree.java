/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/max-heap-and-bst-in-same-structure.html
*/

package com.dsalgo;


import java.util.ArrayList;
import java.util.List;


public class MaxHeapAndBinarySearchTree
{
 public static void main(String[] args)
 {
  List<Node> list = new ArrayList<Node>();
  for (int i = 0; i < 10; ++i)
  {
   list.add(new Node((int) (30 * Math.random()),
     (int) (30 * Math.random())));
  }
  Node root=createHeapAndBST(list);
  printNice(root);
 }

 private static Node createHeapAndBST(List<Node> list)
 {
  if(list.size()==0)
   return null;
  Node top=list.get(0);
  for(Node node:list)
  {
   if(node.heapValue>top.heapValue)
    top=node;
  }
  list.remove(top);
  List<Node> leftList=new ArrayList<Node>();
  List<Node> rightList=new ArrayList<Node>();
  for(Node node:list)
  {
   if(node.treeValue<=top.treeValue)
    leftList.add(node);
   else
    rightList.add(node);
  }
  top.left=createHeapAndBST(leftList);
  top.right=createHeapAndBST(rightList);
  return top;
 }

 static class Node
 {
  public Node left;
  public Node right;
  public int heapValue;
  public int treeValue;

  public Node(int heapValue, int treeValue)
  {
   this.heapValue = heapValue;
   this.treeValue = treeValue;
  }
 }

 public static void printNice(Node root)
 {
  if (root == null)
   return;
  else
  {
   System.out.print("(" + root.heapValue + "," + root.treeValue + ")");
   if (root.left != null)
   {
    System.out.print("L->[");
    printNice(root.left);
    System.out.print("]");
   }
   if (root.right != null)
   {
    System.out.print("R->[");
    printNice(root.right);
    System.out.print("]");
   }
  }
 }
}


