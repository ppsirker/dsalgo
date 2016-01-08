/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/remove-duplicate-infinite-integer.html
*/

package com.dsalgo;
import java.util.Iterator;

public class RemoveDuplicateBST
{
	public static void main(String[] args)
	{
		System.out.println("Input\tOutput");
		Iterator<Integer> inputIterator = new InputIterator(30);
		Iterator<Integer> outputIterator = new OutputIterator(inputIterator);
		while (outputIterator.hasNext())
		{
			System.out.println("\t<<" + outputIterator.next());
		}
	}

	private static class InputIterator implements Iterator<Integer>
	{
		int count;

		public InputIterator(int count)
		{
			this.count = count;
		}

		@Override
		public boolean hasNext()
		{
			return count != 0;
		}

		@Override
		public Integer next()
		{
			int input = (int) (Math.random() * 30);
			System.out.println(">>" + input);
			count--;
			return input;
		}

		@Override
		public void remove()
		{

		}
	}

	private static class OutputIterator implements Iterator<Integer>
	{
		Iterator<Integer> inputIterator;
		Integer nextElement;
		Node root;

		public OutputIterator(Iterator<Integer> inputIterator)
		{
			this.inputIterator = inputIterator;
			if (inputIterator.hasNext())
			{
				nextElement = inputIterator.next();
				if (nextElement != null)
					add(nextElement);
			}
		}

		private boolean add(int value)
		{
			return add(root, value);
		}

		private boolean add(Node current, int value)
		{
			Node node = new Node(value);
			if (current == null)
			{
				root = node;
				return true;
			}
			if (current.value == value)
			{
				return false;
			}
			if (current.value > value)
			{
				if (current.left == null)
				{
					current.left = node;
					return true;
				} else
				{
					return add(current.left, value);
				}
			} else
			{
				if (current.right == null)
				{
					current.right = node;
					return true;
				} else
				{
					return add(current.right, value);
				}
			}
		}

		@Override
		public boolean hasNext()
		{
			return nextElement != null;
		}

		@Override
		public Integer next()
		{
			int output = nextElement;
			nextElement = null;
			while (inputIterator.hasNext())
			{
				int input = inputIterator.next();
				if (add(input))
				{
					nextElement = input;
					break;
				}
			}
			return output;
		}

		@Override
		public void remove()
		{

		}
	}

	private static class Node
	{
		int value;
		Node left;
		Node right;

		public Node(int value)
		{
			this.value = value;
		}
	}
}
