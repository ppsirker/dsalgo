/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-path-of-node-from-root.html
*/

package com.dsalgo;
import java.util.ArrayList;
import java.util.List;

public class FindPathFromRoot
{
	public static void main(String[] args)
	{
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;
		f.left = g;
		f.right = h;

		List<Node> path = findPath(a, d);
		for (Node node : path)
			System.out.println(node.value);
	}

	private static List<Node> findPath(Node root, Node node)
	{
		if (root == null)
			return null;
		List<Node> path = new ArrayList<Node>();
		if (root == node)
		{
			path.add(root);
			return path;
		}
		List<Node> leftPath = findPath(root.left, node);
		List<Node> rightPath = findPath(root.right, node);
		if (leftPath != null)
		{
			leftPath.add(0, root);
			return leftPath;
		}
		if (rightPath != null)
		{
			rightPath.add(0, root);
			return rightPath;
		}
		return null;
	}

	static class Node
	{
		Node left;
		Node right;
		int value;

		public Node(int value)
		{
			this.value = value;
		}
	}
}
