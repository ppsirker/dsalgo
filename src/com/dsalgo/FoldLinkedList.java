/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/FoldLinkedList.php.html
*/

package com.dsalgo;

public class FoldLinkedList
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
  Node i = new Node(9);
  a.next = b;
  b.next = c;
  c.next = d;
  d.next = e;
  e.next = f;
  f.next = g;
  g.next = h;
  h.next = i;
  a.printLinkedList();
  foldLinkedList(a);
  a.printLinkedList();

 }

 public static void foldLinkedList(Node head)
 {
  Node slowPointer = head;
  Node fastPointer = head;
  while (fastPointer != null)
  {
   slowPointer = slowPointer.next;
   fastPointer = fastPointer.next;
   if (fastPointer != null)
    fastPointer = fastPointer.next;
  }
  Node middlePointer = slowPointer;
  Node reverseLastHalf = reverseLinkedList(slowPointer);
  while (reverseLastHalf != null && head != middlePointer)
  {
   Node tempHead = head.next;
   Node tempReverse = reverseLastHalf.next;
   reverseLastHalf.next = head.next;
   head.next = reverseLastHalf;
   head = tempHead;
   reverseLastHalf = tempReverse;
  }
  if (reverseLastHalf != null)
   reverseLastHalf.next = null;
  else
   head.next = null;
 }

 public static Node reverseLinkedList(Node head)
 {
  if (head.next == null)
   return head;
  Node newHead = reverseLinkedList(head.next);
  head.next.next = head;
  head.next = null;
  return newHead;
 }

 static class Node
 {
  public Node next;
  public int value;

  public Node(int value)
  {
   this.value = value;
  }

  public void printLinkedList()
  {
   Node head = this;
   while (head != null)
   {
    System.out.print(head.value + "->");
    head = head.next;
   }
   System.out.println();
  }

 }

}
