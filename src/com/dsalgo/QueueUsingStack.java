/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/QueueUsingStack.php.html
*/

package com.dsalgo;

import java.util.Stack;


public class QueueUsingStack
{
 private Stack<Integer>stackPop=new Stack<Integer>();
 private Stack<Integer>stackPush=new Stack<Integer>();
 
 public void enqueue(int a)
 {
  stackPush.push(a);
 }
 public int dequeue()
 {
  if(stackPop.isEmpty())
   while(!stackPush.isEmpty())
    stackPop.push(stackPush.pop());
  return stackPop.pop();
 }
}
        
