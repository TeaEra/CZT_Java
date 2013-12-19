package czt.learn.LeetCode;

import czt.learn.LeetCode.resources.Point;

public class MaxPointsOnALine {

	// ???
	public static int maxPoints(Point[] points) {
		//
		if (points == null || points.length == 0) {
			return 0;
		}
		// Only 1 point;
		if (points.length == 1) {
			return 1;
		}


		int max = 0;

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point[] points = new Point[] { new Point(1, 1), new Point(1, 1),
				new Point(1, 1) };
		System.out.println(MaxPointsOnALine.maxPoints(points));
	}

}
