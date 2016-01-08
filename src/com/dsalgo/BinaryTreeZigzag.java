/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/BinaryTreeZigzag.php.html
 */

package com.dsalgo;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeZigzag {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		Node i = new Node(9);

		a.left = b;
		a.right = c;
		b.right = d;
		c.left = e;
		c.right = f;
		d.left = g;
		d.right = h;
		g.right = i;

		printZigzag(a);

	}

	public static void printZigzag(Node root) {
		LinkedList<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		if (root == null)
			return;
		Node marker = new Node(-1);
		boolean printOrder = true;
		queue.add(root);
		queue.add(marker);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node == marker) {
				if (!printOrder) {
					while (stack.size() > 0) {
						Node printNode = stack.pop();
						System.out.println(printNode.value);

					}

				}
				printOrder = !printOrder;
				if (!queue.isEmpty())
					queue.add(marker);
				continue;
			}
			if (printOrder) {
				System.out.println(node.value);
			} else {
				stack.push(node);
			}
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);

		}

	}

	static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			this.value = value;
		}
	}

}
