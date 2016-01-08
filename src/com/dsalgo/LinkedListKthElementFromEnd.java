/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-kth-node-from-end-in-linked-list.html
*/

package com.dsalgo;


public class LinkedListKthElementFromEnd
{
 public static void main(String[] args)
 {
  Node head = new Node(1);
  head.append(2).append(3).append(4).append(5).append(6).append(7)
    .append(8).append(9);
  Node result = findKFromEnd(head, 3);
  System.out.println(result.value);
 }

 private static Node findKFromEnd(Node head, int k)
 {
  Node ahead = head;
  while (k-- > 0)
   ahead = ahead.next;
  while (ahead != null)
  {
   head = head.next;
   ahead = ahead.next;
  }
  return head;
 }

 private static class Node
 {
  public Node next;
  public int value;

  public Node(int value)
  {
   this.value = value;
  }

  public Node append(int value)
  {
   Node node = new Node(value);
   next = node;
   return node;
  }
 }

}

   
