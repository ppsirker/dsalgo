/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/QueueMinUsingStackMin.php.html
*/

package com.dsalgo;

/*
 * Implement a queue in which push_rear(), pop_front() and get_min() are all constant time operations. 
 * 
 * first solution using two stacks
 */
public class QueueMinUsingStack
{

 static StackMinimum stackMinimum1=new StackMinimum();
 static StackMinimum stackMinimum2=new StackMinimum();
 public static void enqueue(int a)
 {
  stackMinimum1.push(a);
 }
 
 public static int dequeue()
 {
  if(stackMinimum2.size()==0)
  {
   while(stackMinimum1.size()!=0)
    stackMinimum2.push(stackMinimum1.pop());
  }
  return stackMinimum2.pop();
 }
 
 public int getMinimum()
 {
  return Math.min(
                stackMinimum1.size()==0?Integer.MAX_VALUE:stackMinimum1.getMinimum(),
                stackMinimum2.size()==0?Integer.MAX_VALUE:stackMinimum2.getMinimum()
        );
 }
}
        
