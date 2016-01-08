/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/distributed-circular-linked-list-sum.html
*/

package com.dsalgo;

class DistributedCircularListSum
{
 public static volatile boolean startFlag = false;
 private static Boolean flag = false;

 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  a.next = b;
  b.next = c;
  c.next = d;
  d.next = e;
  e.next = a;
  startFlag = true;
 }

 private static class Node
 {
  Node next;
  int value;
  Integer data;

  public Node(int value)
  {
   this.value = value;
   new Thread(new NodeRunner(this, value)).start();
  }

  public synchronized void send(int data)
  {
   this.data = data;
  }

 }

 private static class NodeRunner implements Runnable
 {
  Node node;
  int id;

  public NodeRunner(Node node, int id)
  {
   this.node = node;
   this.id = id;
  }

  @Override
  public void run()
  {
   while (!startFlag)
   {
   }

   boolean isFirst = false;
   synchronized (flag)
   {
    if (flag == false)
    {
     flag = true;
     isFirst = true;
    }
   }
   if (isFirst)
    node.next.send(node.value);
   else
   {
    while (node.data == null)
    {
     try
     {
      Thread.sleep(10);
     } catch (InterruptedException e)
     {

     }
    }
    int sum = node.value + node.data;
    node.data = null;
    node.next.send(sum);
   }
   while (node.data == null)
   {
    try
    {
     Thread.sleep(10);
    } catch (InterruptedException e)
    {

    }
   }
   System.out.println("id:" + id + "sum:" + node.data);
   node.next.send(node.data);
  }
 }
}

