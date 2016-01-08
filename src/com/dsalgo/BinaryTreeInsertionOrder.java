/*

For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/binary-search-tree-with-insertion-order.html
*/

package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInsertionOrder
{
	public static void main(String[] args)
	{
		BinaryTree bt = new BinaryTree();
		bt.add(4).add(5).add(2).add(9).add(14).add(6).add(3);
		List<Integer> list = bt.getSortedOrder();
		for (Integer num : list)
			System.out.print(num + ", ");
		System.out.println();
		list = bt.getInsertionOrder();
		for (Integer num : list)
			System.out.print(num + ", ");
		System.out.println();
	}

	private static class BinaryTree
	{
		Node root;
		Node head;
		Node last;

		public BinaryTree add(int num)
		{
			if (root == null)
			{
				root = new Node(num);
				head = root;
				last = root;
			} else
			{
				Node node = new Node(num);
				add(root, node);
				last.next = node;
				last = node;
			}
			return this;
		}

		private void add(Node root, Node node)
		{
			if (node.value < root.value)
			{
				if (root.left == null)
					root.left = node;
				else
					add(root.left, node);
			} else
			{
				if (root.right == null)
					root.right = node;
				else
					add(root.right, node);
			}

		}

		public List<Integer> getInsertionOrder()
		{
			Node current = head;
			List<Integer> list = new ArrayList<Integer>();
			while (current != null)
			{
				list.add(current.value);
				current = current.next;
			}
			return list;
		}

		public List<Integer> getSortedOrder()
		{
			List<Integer> list = new ArrayList<Integer>();
			inorder(root, list);
			return list;
		}

		private void inorder(Node root, List<Integer> list)
		{
			if (root == null)
				return;
			inorder(root.left, list);
			list.add(root.value);
			inorder(root.right, list);
		}

	}

	private static class Node
	{
		int value;
		Node left;
		Node right;
		Node next;

		public Node(int value)
		{
			this.value = value;
		}

	}
}
