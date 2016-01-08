package com.dsalgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompactBinaryTree {

	public static void main(String[] args) {

		Node a = new Node(1);
		Node b = new Node(2);
		Node bb = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node ee = new Node(5);
		Node eee = new Node(5);
		Node f = new Node(6);
		Node ff = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		Node i = new Node(9);
		a.left = b;
		b.left = e;
		b.right = f;
		a.right = c;
		c.left = d;
		c.right = bb;
		bb.left = ee;
		bb.right = ff;
		d.left = g;
		g.left = h;
		g.right = i;
		h.right = eee;
		compactTree(a);
		System.out.println("Let's see if it worked...");
		System.out.println("left child of a: "
				+ System.identityHashCode(a.left));
		System.out.println("right child of c: "
				+ System.identityHashCode(c.right));
		System.out.println("right child of h: "
				+ System.identityHashCode(h.right));
		System.out.println("left child of b: "
				+ System.identityHashCode(b.left));
	}

	static void compactTree(Node root) {
		Map< NodeHash, Node > map = new HashMap<  >();
		compactTree(root, map);
	}

	static void compactTree(Node root, Map< NodeHash, Node > map) {
		NodeHash nodeHash = new NodeHash(root);
		map.put(nodeHash, root);
		if (root.left != null) {
			NodeHash leftHash = new NodeHash(root.left);
			if (map.containsKey(leftHash)) {
				root.left = (Node) map.get(leftHash);
			} else {
				compactTree(root.left, map);
			}
		}
		if (root.right != null) {
			NodeHash rightHash = new NodeHash(root.right);
			if (map.containsKey(rightHash)) {
				root.right = (Node) map.get(rightHash);
			} else {
				compactTree(root.right, map);
			}
		}
	}

	static class Node {
		private Node left;
		private Node right;
		private int value;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			return value;
		}

		@Override
		public boolean equals(Object obj) {
			return value == ((Node) obj).value;
		}

		@Override
		public String toString() {
			return "" + value;
		}
	}

	static class NodeHash {
		List< Node > preOrderList;
		List< Node > inOrderList;

		NodeHash(Node root) {
			preOrderList = preOrder(root);
			inOrderList = inOrder(root);
		}

		@Override
		public boolean equals(Object obj) {
			NodeHash n = (NodeHash) obj;
			return preOrderList.equals(n.preOrderList)
					&& inOrderList.equals(n.inOrderList);
		}

		@Override
		public int hashCode() {
			return 31 * preOrderList.hashCode() + inOrderList.hashCode();
		}

		List< Node > preOrder(Node root) {
			List< Node > result = new ArrayList<  >();
			if (root == null)
				return result;
			result.add(root);
			result.addAll(preOrder(root.left));
			result.addAll(preOrder(root.right));
			return result;
		}

		List< Node > inOrder(Node root) {
			List< Node > result = new ArrayList<  >();
			if (root == null)
				return result;
			result.addAll(inOrder(root.left));
			result.add(root);
			result.addAll(inOrder(root.right));
			return result;
		}
	}
}
