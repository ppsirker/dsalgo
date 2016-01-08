package com.dsalgo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestKpoints {

	public static void main(String[] args) {
		/*double[][] coordinates = { { 1.2, 4 }, { 4.5, 3 }, { 1.2, 5 },
				{ 4.3, 6 }, { 0.2, 4 }, { 4.3, 3.4 }, { 5.6, 3 }, { 6.5, 2.3 },
				{ 4, 5.4 }, };*/
		double[][] coordinates = { { 1,1 }, { 4, 4 }, { 2,2 },
				{ 3,3 }, {5,5 }};
		
		Point[] points = new Point[coordinates.length];
		for (int i = 0; i < coordinates.length; ++i) {
			points[i] = new Point(coordinates[i][0], coordinates[i][1]);
		}
		Point fromPoint = new Point(3,3);
		Point[] nearPoints = findNearPoints(points, fromPoint, 4);
		for (Point p:nearPoints)
		{
			System.out.print(p);
			System.out.print(",");
		}
		System.out.println();
	}

	private static Point[] findNearPoints(Point[] points, Point fromPoint, int k) {
		DistanceComparator comparator = new DistanceComparator(fromPoint);
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, comparator);
		for (Point p : points) {
			if (maxHeap.size() < k)
				maxHeap.add(p);
			else {
				if (comparator.compare(maxHeap.peek(), p) < 0) {
					maxHeap.poll();
					maxHeap.add(p);
				}
			}
		}
		Point[] result = new Point[k];
		int index = 0;
		while (!maxHeap.isEmpty()) {
			result[index++] = maxHeap.poll();
		}
		return result;
	}

	public static class Point {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		public String toString()
		{
			return "("+this.x+","+this.y+")";
		}
	}

	public static class DistanceComparator implements Comparator<Point> {
		Point p;

		public DistanceComparator(Point p) {
			this.p = p;
		}

		@Override
		public int compare(Point o1, Point o2) {
			double distance1 = (o1.x - p.x) * (o1.x - p.x) + (o1.y - p.y)
					* (o1.y - p.y);
			double distance2 = (o2.x - p.x) * (o2.x - p.x) + (o2.y - p.y)
					* (o2.y - p.y);
			return -1*new Double(distance1).compareTo(new Double(distance2));
		}
	}
}
