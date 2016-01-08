/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/find-kth-smallest-element-in-binary.html
*/

package com.dsalgo;

public class KthLargestOnline
{
 public static void main(String[] args)
 {
  BST bst = new BST();
  int[] arr =
  { 12, 4, 5, 6, 2, 7, 8, 11, 2, 3 };
  for (int num : arr)
   bst.add(num);
  System.out.println(bst.getOrdered(4));
  arr = new int[]
  { 12, 1, 9, 14, 25 };
  for (int num : arr)
   bst.add(num);
  System.out.println(bst.getOrdered(6));

 }

 private static class BST
 {
  Node root;

  public void add(int num)
  {
   if (root == null)
   {
    root = new Node(num);
   } else
    add(root, num);
  }

  private void add(Node root, int num)
  {
   Node node = new Node(num);
   if (node.value < root.value)
   {
    root.leftWeight++;
    if (root.left == null)
     root.left = node;
    else
     add(root.left, num);
   } else
   {
    if (root.right == null)
     root.right = node;
    else
     add(root.right, num);
   }
  }

  public int getOrdered(int k)
  {
   return getOrdered(root, k);
  }

  private Integer getOrdered(Node root, int k)
  {
   if (root == null)
    return null;
   if (root.leftWeight > k)
   {
    return getOrdered(root.left, k);
   } else if (root.leftWeight < k)
   {
    return getOrdered(root.right, k - root.leftWeight);
   } else
   {
    return root.value;
   }
  }
 }

 private static class Node
 {
  int value;
  int leftWeight;
  Node left;
  Node right;

  public Node(int value)
  {
   this.value = value;
   this.leftWeight = 1;
  }
 }

}

