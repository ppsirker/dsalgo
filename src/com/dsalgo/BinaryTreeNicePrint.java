package com.dsalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeNicePrint {

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(8);
		Node g = new Node(6);
		Node h = new Node(7);
		Node i = new Node(9);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = i;
		c.right = f;
		f.left = g;
		f.right = h;
		nicePrint(a);
	}

	public static void nicePrint(Node root) {
		List< StringPoint > result = getStrings((getWidth(root) + 1) / 2, 0, root);
		TreeMap< Integer, List< StringPoint > > lines = new TreeMap<  >();
		for (StringPoint s : result) {
			if (lines.get(s.y) != null) {
				lines.get(s.y).add(s);
			} else {
				List< StringPoint > l = new ArrayList<  >();
				l.add(s);
				lines.put(s.y, l);
			}
		}
		for (List< StringPoint > l : lines.values()) {
			System.out.println(flatten(l));
		}
	}

	private static String flatten(List< StringPoint > l) {
		int x = 0;
		StringBuilder sb = new StringBuilder();
		for (StringPoint s : l) {
			sb.append(new String(new char[s.x - x]).replace('\0', ' '));
			sb.append(s.value);
			x = sb.length();
		}
		return sb.toString();
	}

	private static int getWidth(Node root) {
		int width = 0;
		if (root.left != null) {
			width += getWidth(root.left);
		}
		if (root.right != null) {
			width += getWidth(root.right);
		}
		width += ("" + root.value).length();
		return width;
	}

	private static List< StringPoint > getStrings(int x, int y, Node root) {
		List< StringPoint > result = new ArrayList< StringPoint >();
		result.add(new StringPoint(x - ("" + root.value).length() / 2, y, ""
				+ root.value));
		if (root.left != null) {
			int width = getWidth(root.left);
			int i = 0;
			for (; i <  (width + 1) / 2; ++i)
				result.add(new StringPoint(x - i - 1, y + i + 1, "/"));
			result.addAll(getStrings(x - i - 1, y + i + 1, root.left));
		}
		if (root.right != null) {
			int width = getWidth(root.right);
			int i = 0;
			for (; i <  (width + 1) / 2; ++i)
				result.add(new StringPoint(x + i + 1, y + i + 1, "\\"));
			result.addAll(getStrings(x + i + 1, y + i + 1, root.right));
		}
		return result;
	}

	static class StringPoint {
		Integer x;
		Integer y;
		String value;

		StringPoint(int x, int y, String value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + "," + value + ")";
		}
	}

	static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}
}
