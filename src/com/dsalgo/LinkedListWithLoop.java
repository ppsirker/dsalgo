/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-loop-in-linked-list.html
*/

package com.dsalgo;


public class LinkedListWithLoop
{
 public static void main(String[] args)
 {
  Node head = new Node(1);
  Node middle = head.append(2).append(3).append(4).append(5);
  Node tail = middle.append(6).append(7).append(8).append(9).append(10)
    .append(11);
  tail.next = middle;
  findLoopInformation(head);
 }

 private static void findLoopInformation(Node head)
 {
  Node slowPointer = head;
  Node fastPointer = head;
  boolean isLooped = false;
  while (fastPointer != null && fastPointer.next != null)
  {
   slowPointer = slowPointer.next;
   fastPointer = fastPointer.next.next;
   if (slowPointer == fastPointer)
   {
    isLooped = true;
    break;
   }
  }
  if (isLooped)
  {
   System.out.println("Linkedlist is looped");
   fastPointer = fastPointer.next;
   int count = 1;
   while (slowPointer != fastPointer)
   {
    fastPointer = fastPointer.next;
    count++;
   }
   System.out.println("Loop length = " + count);
   slowPointer = head;
   fastPointer = head;
   while (count-- > 0)
   {
    fastPointer = fastPointer.next;
   }
   while (slowPointer != fastPointer)
   {
    slowPointer = slowPointer.next;
    fastPointer = fastPointer.next;
   }
   System.out.println("Loop starting point = " + slowPointer.value);
  } else
  {
   System.out.println("Linkedlist is NOT looped");
  }
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
