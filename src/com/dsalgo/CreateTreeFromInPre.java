/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/CreateTreeFromInPre.php.html
*/

package com.dsalgo;

public class CreateTreeFromInPre
{
 public static void main(String[] args)
 {
  int[] inorder =
  { 4, 2, 5, 1, 6, 3 };
  int[] preorder =
  { 1, 2, 4, 5, 3, 6 };
  Node root = buildBinaryTree(inorder, preorder);
  printNice(root);
 }

 public static Node buildBinaryTree(int[] inorder, int[] preorder)
 {
  return buildBinaryTree(inorder, 0, inorder.length, preorder, new int[]
  { 0 });
 }

 private static Node buildBinaryTree(int[] inorder, int inStartIndex,
   int inEndIndex, int[] preorder, int[] preIndex)
 {
  if (preIndex[0] == preorder.length)
   return null;
  Node root = new Node(preorder[preIndex[0]]);
  int findIndex = -1;
  for (int i = inStartIndex; i < inEndIndex; ++i)
  {
   if (preorder[preIndex[0]] == inorder[i])
   {
    findIndex = i;
   }
  }
  if (findIndex == -1)
   return null;
  preIndex[0]++;
  root.left = buildBinaryTree(inorder, inStartIndex, findIndex, preorder,
    preIndex);
  root.right = buildBinaryTree(inorder, findIndex + 1, inEndIndex,
    preorder, preIndex);
  return root;
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
}
        
