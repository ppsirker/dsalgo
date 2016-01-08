/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/StackMinimum.php.html
*/

package com.dsalgo;

import java.util.Stack;

public class StackMinimum
{
 private Stack<Integer> stack = new Stack<Integer>();
 private Stack<Integer> minStack = new Stack<Integer>();

 public Integer push(Integer item)
 {
  if(stack.empty())
  {
   stack.push(item);
   minStack.push(item);
   return item;
  }
  Integer currentMin=minStack.peek();
  if(currentMin < item)
   minStack.push(currentMin);
  else
   minStack.push(item);
  stack.push(item);
  return item;
 }

 public Integer pop()
 {
  if(stack.size()==0)
   return null;
  minStack.pop();
  return stack.pop();
 }
 
 public Integer getMinimum()
 {
  if(minStack.empty())
   return null;
  return minStack.peek();
 }
 
 public int size()
 {
  return stack.size();
 }

}
        
