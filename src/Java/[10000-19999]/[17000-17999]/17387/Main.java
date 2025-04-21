import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static class Point implements Comparable<Point> {
		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Point p) {
			if (this.x == p.x) {
				return Double.compare(this.y, p.y);
			}
			return Double.compare(this.x, p.x);
		}
	}

	static Point p1, p2, p3, p4;

	private static final double EPSILON = 1e-9;

	private static boolean isZero(double val) {
		return Math.abs(val) < EPSILON;
	}

	private static boolean isBetween(Point a, Point b, Point c) {
		return Math.min(a.x, b.x) <= c.x && c.x <= Math.max(a.x, b.x) && Math.min(a.y, b.y) <= c.y
				&& c.y <= Math.max(a.y, b.y);
	}

	static double line1(Point p) {
		if (p1.x == p2.x)
			return p.x - p1.x;
		else {
			return p.y - (p1.y - p2.y) / (p1.x - p2.x) * (p.x - p1.x) - p1.y;
		}
	}

	static double line2(Point p) {
		if (p3.x == p4.x)
			return p.x - p3.x;
		else {
			return p.y - (p3.y - p4.y) / (p3.x - p4.x) * (p.x - p3.x) - p3.y;
		}
	}

	public static double getDist(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		p1 = new Point(nextDouble(), nextDouble());
		p2 = new Point(nextDouble(), nextDouble());
		p3 = new Point(nextDouble(), nextDouble());
		p4 = new Point(nextDouble(), nextDouble());

		double flag1 = line1(p3);
		double flag2 = line1(p4);
		double flag3 = line2(p1);
		double flag4 = line2(p2);

		// 평행하지 않으면서 교차
		if (flag1 * flag2 < 0 && flag3 * flag4 < 0)
			System.out.println(1);

		// 두 선분이 한 직선 위에 존재한다.
		else if (isZero(flag1) && isZero(flag2) && isZero(flag3) && isZero(flag4)) {
			Point min = p1;
			Point max = p1;

			min = min.compareTo(p2) < 0 ? min : p2;
			min = min.compareTo(p3) < 0 ? min : p3;
			min = min.compareTo(p4) < 0 ? min : p4;

			max = max.compareTo(p2) > 0 ? max : p2;
			max = max.compareTo(p3) > 0 ? max : p3;
			max = max.compareTo(p4) > 0 ? max : p4;

			double dist1 = getDist(p1, p2);
			double dist2 = getDist(p3, p4);
			double dist3 = getDist(min, max);

			if (dist3 <= dist1 + dist2)
				System.out.println(1);
			else
				System.out.println(0);
		}

		// 한 점이 겹친다.
		else if (flag1 * flag2 == 0 && flag3 * flag4 == 0)
			System.out.println(1);

		// 한 점이 다른 직선 위에 존재한다.
		else if (isZero(flag1)) {
			if (isBetween(p1, p2, p3))
				System.out.println(1);
			else
				System.out.println(0);
		}

		else if (isZero(flag2)) {
			if (isBetween(p1, p2, p4))
				System.out.println(1);
			else
				System.out.println(0);
		}

		else if (isZero(flag3)) {
			if (isBetween(p3, p4, p1))
				System.out.println(1);
			else
				System.out.println(0);
		}

		else if (isZero(flag4)) {
			if (isBetween(p3, p4, p2))
				System.out.println(1);
			else
				System.out.println(0);
		}

		else
			System.out.println(0);
	}

	private static double nextDouble() throws IOException {
		st.nextToken();
		return st.nval;
	}
}
