/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/ArrayNextSmallElement.php.html
*/

package com.dsalgo;

import java.util.LinkedList;

public class NextSmallInteger
{

 /**
  * given an array form another array where each element of previous array is replaced with 
  * its next minimum number in the array
  * @param args
  */
 public static void main(String[] args)
 {
  int[] input={3,4,5,2,7,5,7,3,8,2,5,7,9,1,3};
  int[]output=new int[input.length];
  LinkedList<Integer> stack=new LinkedList<Integer>();
  for(int i=input.length-1;i>=0;--i)
  {
   int currentNum=input[i];
   if(stack.peek()==null)
   {
    output[i]=0;
    stack.push(currentNum);
    continue;
   }
   while(stack.size()!=0 && stack.peek()>=currentNum)
   {
    stack.pop();
   }
   output[i]=stack.peek()==null?0:stack.peek();
   stack.push(currentNum);
  }
  for(int i=0;i < output.length;++i)
  {
   System.out.print(output[i]+",");
  }
 }

}
