/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/linked-list-y-shape.html
*/

package com.dsalgo;


public class LinkedListYShape
{

 public static void main(String[] args)
 {
  Node head1 = new Node(1);
  Node middle1 = head1.append(2).append(3).append(4);
  middle1.append(6).append(7).append(8).append(9);
  Node head2 = new Node(10);
  Node middle2 = head2.append(3).append(5).append(6).append(11)
    .append(24);
  middle2.next = middle1;
  findIntersection(head1, head2);

 }

 private static void findIntersection(Node head1, Node head2)
 {
  int count1 = 0;
  int count2 = 0;
  Node ptr1 = head1;
  Node ptr2 = head2;

  while (true)
  {
   if (ptr1.next == null)
    break;
   ptr1 = ptr1.next;
   count1++;
  }
  while (true)
  {
   if (ptr2.next == null)
    break;
   ptr2 = ptr2.next;
   count2++;
  }
  boolean isMerged = ptr1 == ptr2;
  if (isMerged)
  {
   System.out.println("The linked lists are merged");
   Node longer = head1;
   Node shorter = head2;
   if (count1 < count2)
   {
    longer = head2;
    shorter = head1;
   }
   int diff = Math.abs(count1 - count2);
   while (diff-- > 0)
   {
    longer = longer.next;
   }
   while (longer != shorter)
   {
    longer = longer.next;
    shorter = shorter.next;
   }
   System.out.println("Common Node = " + longer.value);
  } else
  {
   System.out.println("The linked lists are NOT merged");
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

   
