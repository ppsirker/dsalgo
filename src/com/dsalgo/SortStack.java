/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/sort-stack.html
*/

package com.dsalgo;

import java.util.Stack;

public class SortStack
{
	public static void main(String[] args)
	{
		Stack<Integer>stack=new Stack<Integer>();
		System.out.println("Number of elements: ");
		
		Scanner input = new Scanner(System.in);
        	int n = input.nextInt();
        	System.out.println("Enter the elements");
        	for(int i=0 ;i<n; i++){
       		     int input1 = input.nextInt();
       		     stack.push(input1);
        	}
	   	System.out.println("Sorted elements");
		sort(stack);
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}

	static void sort(Stack<Integer> stack)
	{
		if (stack.isEmpty())
			return;
		Integer top = stack.pop();
		sort(stack);
		insertSorted(top, stack);
		return;
	}

	static void insertSorted(Integer top, Stack<Integer> stack)
	{
		if (stack.isEmpty() || stack.peek() > top)
		{
			stack.push(top);
			return;
		}
		Integer smaller = stack.pop();
		insertSorted(top, stack);
		stack.push(smaller);
	}
}
