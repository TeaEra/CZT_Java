package czt.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

import czt.learn.leetcode.resources.Point;

public class MaxPointsOnALine {

	// ???
	public static int maxPoints(Point[] points) {
		//
		if (points == null || points.length == 0) {
			return 0;
		}

		int maxPoints = 0;
		for (int i=0; i<points.length; ++i) {
			Point p1 = points[i];
			Map<String, Integer> slopes = new HashMap<String, Integer>();
			int samePoints = 0;
			int iMax = 0;
			for (int j=0; j<points.length; ++j) {
				Point p2 = points[j];
				
				if (p1.x == p2.x && p1.y == p2.y) {
					samePoints++;
				}
				else {
					String slopeKey;
					if (p1.x == p2.x) {
						slopeKey = "infinite";
					}
					else {
						// The type cast here is very important!
						slopeKey = 
							String.valueOf((p2.y - p1.y) / (double)(p2.x - p1.x));
					}
					
					if (slopes.containsKey(slopeKey)) {
						slopes.put(slopeKey, 
								Integer.valueOf(slopes.get(slopeKey).intValue() + 1));
					}
					else {
						slopes.put(slopeKey, Integer.valueOf(1));
					}
					iMax = slopes.get(slopeKey).intValue() > iMax
							? slopes.get(slopeKey).intValue() : iMax;
				}
			}
			
			maxPoints = iMax + samePoints > maxPoints ? iMax + samePoints
					: maxPoints;
		}

		return maxPoints;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point[] points = new Point[] { 
				new Point(84,250), 
				new Point(0, 0),
				new Point(1, 0),
				new Point(0,-70),
				new Point(0,-70),
				new Point(1, -1),
				new Point(21,10),
				new Point(42,90),
				new Point(-42, -230)
				};
		System.out.println(MaxPointsOnALine.maxPoints(points));
	}

}
