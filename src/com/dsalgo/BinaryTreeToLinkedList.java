/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/BinaryTreeToLinkedList.php.html
*/

package com.dsalgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeToLinkedList
{

 public static void main(String[] args)
 {
  BinaryTreeNode a=new BinaryTreeNode(1);
  BinaryTreeNode b=new BinaryTreeNode(2);
  BinaryTreeNode c=new BinaryTreeNode(3);
  BinaryTreeNode d=new BinaryTreeNode(4);
  BinaryTreeNode e=new BinaryTreeNode(5);
  BinaryTreeNode f=new BinaryTreeNode(6);
  BinaryTreeNode g=new BinaryTreeNode(7);
  BinaryTreeNode h=new BinaryTreeNode(8);
  BinaryTreeNode i=new BinaryTreeNode(9);
  a.left=b;
  a.right=c;
  b.right=d;
  c.left=e;
  c.right=f;
  d.left=g;
  d.right=h;
  g.right=i;
  
  List<LinkedNode> result=getLinkedListFromEachLevel(a);
  for(LinkedNode head:result)
   printLinkedList(head);
  
 }
 
 static List<LinkedNode> getLinkedListFromEachLevel(BinaryTreeNode root)
 {
  List<LinkedNode> result=new ArrayList<LinkedNode>();
  if(root==null)
   return result;
  LinkedList<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
  queue.add(root);
  BinaryTreeNode marker=new BinaryTreeNode(-1);
  queue.add(marker);
  LinkedNode head=null;
  LinkedNode prev=null;
  while(!queue.isEmpty())
  {
   BinaryTreeNode btNode=queue.poll();
   if(btNode==marker)
   {
    result.add(head);
    head=null;
    
    if(!queue.isEmpty())
    {
     queue.add(marker);
    }
    continue;
   }
   if(head==null)
   {
    head=new LinkedNode(btNode.value);
    prev=head;
   }
   else
   {
    prev.next=new LinkedNode(btNode.value);
    prev=prev.next;
   }
   if(btNode.left!=null)
    queue.add(btNode.left);
   if(btNode.right!=null)
    queue.add(btNode.right);
   
  }
  return result;
 }
 static class BinaryTreeNode
 {
  public BinaryTreeNode left;
  public BinaryTreeNode right;
  public int value;
  public BinaryTreeNode(int value)
  {
   this.value=value;
  }
 }
 
 static class LinkedNode
 {
  public LinkedNode next;
  public int value;
  public LinkedNode(int value)
  {
   this.value=value;
  }
 }
 
 static void printLinkedList(LinkedNode head)
 {
  while(head!=null)
  {
   System.out.print(head.value);
   System.out.print("->");
   head=head.next;
  }
  System.out.println();
 }

}
        
