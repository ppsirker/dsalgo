/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/PostorderSuccessor.php.html
 */

package com.dsalgo;

public class PostorderSuccessor {

	public static void main(String[] args) {
		NextNode a = new NextNode(1);
		NextNode b = new NextNode(2);
		NextNode c = new NextNode(3);
		NextNode d = new NextNode(4);
		NextNode e = new NextNode(5);
		NextNode f = new NextNode(6);
		NextNode g = new NextNode(7);
		NextNode h = new NextNode(8);
		NextNode i = new NextNode(9);
		a.left = b;
		a.right = c;
		b.right = d;
		c.left = e;
		c.right = f;
		d.left = g;
		d.right = h;
		g.right = i;
		NextNode head = linkPostorderSuccessor(a);
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}

	}

	public static NextNode linkPostorderSuccessor(NextNode root) {
		NodeContainer linker = new NodeContainer();
		NodeContainer head = new NodeContainer();
		linkPostorderSuccessor(root, linker, head);
		return head.node;
	}

	private static void linkPostorderSuccessor(NextNode root,
			NodeContainer linker, NodeContainer head) {
		if (root == null)
			return;
		linkPostorderSuccessor(root.left, linker, head);
		linkPostorderSuccessor(root.right, linker, head);
		if (head.node == null && root != null)
			head.node = root;
		if (linker.node != null)
			linker.node.next = root;
		linker.node = root;

	}

	static class NextNode {
		public NextNode left;
		public NextNode right;
		public NextNode next;
		public int value;

		public NextNode(int value) {
			this.value = value;
		}
	}

	static class NodeContainer {
		public NextNode node;
	}

}
