/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/BinaryTreeSumChildNodes.php.html
*/

package com.dsalgo;


/*
 * In a binary tree change each node's value(except leaf node) as the sum of left and right subtree's value. 
 * 
 *  
   Constructed binary tree is:
           1
        /      \
       2        3
     /  \        \
    4   5        8
               /    \
              6       7
  

 After sum stored is in each node, binary tree is:
          35
        /    \
       9     21
     /  \       \
    4   5       13
               /   \
              6     7
  
 */
public class BinaryTreeSumChildNodes
{

 /**
  * @param args
  */
 public static void main(String[] args)
 {

  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(8);
  Node g = new Node(6);
  Node h = new Node(7);
  a.left = b;
  a.right = c;
  b.left = d;
  b.right = e;
  c.right = f;
  f.left = g;
  f.right = h;
  printNice(a);
  System.out.println();
  makeSum(a);
  printNice(a);
 }

 public static int makeSum(Node root)
 {
  if (root == null)
   return 0;
  int temp = root.value;
  int sum = makeSum(root.left) + makeSum(root.right);
  if (root.left != null || root.right != null)
   root.value = sum;
  return temp + sum;
 }

 public static void printNice(Node root)
 {
  if (root == null)
   return;
  else
  {
   System.out.print(root.value);
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
 static class Node
 {
  public Node left;
  public Node right;
  public int value;
  public Node(int value)
  {
   this.value=value;
  }
 }
}        
