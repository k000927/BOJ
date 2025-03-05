import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 1. peakPoint 클래스 -> 봉우리가 x축과 만나는 부분을 나타낸다.
 * 		1.1. peakNum -> 봉우리의 인덱스
 * 		1.2. x -> 봉우리가 x축과 만나는 좌표
 * 		1.3. 하나의 봉우리에는 두 개의 peakPoint가 생긴다.
 */
public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class PeakPoint implements Comparable<PeakPoint> {
		int peakNum;
		int x;

		PeakPoint(int peakNum, int x) {
			this.peakNum = peakNum;
			this.x = x;
		}

		@Override
		public int compareTo(PeakPoint pp) {
			return Integer.compare(this.x, pp.x);
		}
	}

	public static void main(String[] args) throws IOException {

		int n = nextInt();
		Point[] points = new Point[n + 1];
		List<PeakPoint> peakPointList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			points[i] = new Point(nextInt(), nextInt());
		}
		points[n] = new Point(points[0].x, points[0].y);

		List<PeakPoint> peakStack = new ArrayList<>();

		int peakNum = 1;
		for (int i = 0; i < n; i++) {
			if (points[i].y == points[i + 1].y)
				continue;

			if (points[i].y > 0 && points[i + 1].y > 0)
				continue;
			if (points[i].y < 0 && points[i + 1].y < 0)
				continue;

			// 하강
			if (points[i].y > 0 && points[i + 1].y < 0) {
				if (peakStack.size() == 0)
					peakPointList.add(new PeakPoint(peakNum, points[i].x));
				else {
					PeakPoint tos = peakStack.remove(peakStack.size() - 1);
					PeakPoint peakPoint = new PeakPoint(tos.peakNum, points[i].x);

					peakPointList.add(tos);
					peakPointList.add(peakPoint);
				}
			}
			// 상승
			else {
				PeakPoint peakPoint = new PeakPoint(++peakNum, points[i].x);
				peakStack.add(peakPoint);
			}
		}

		if (!peakStack.isEmpty()) {
			PeakPoint peakPoint = peakStack.remove(0);
			peakPointList.add(new PeakPoint(1, peakPoint.x));
		}

		Collections.sort(peakPointList);

		int peakCount1 = 0;
		int peakCount2 = 0;

		List<Integer> peakStack2 = new ArrayList<>();

		for (PeakPoint peakPoint : peakPointList) {
			if (peakStack2.size() == 0) {
				peakCount1++;
				peakStack2.add(peakPoint.peakNum);
			} else if (peakPoint.peakNum == peakStack2.get(peakStack2.size() - 1)) {
				peakStack2.remove(peakStack2.size() - 1);
			} else {
				peakStack2.add(peakPoint.peakNum);
			}
		}

		for (int i = 0; i < peakPointList.size() - 1; i++) {
			if (peakPointList.get(i).peakNum == peakPointList.get(i + 1).peakNum)
				peakCount2++;
		}

		System.out.println(peakCount1 + " " + peakCount2);

	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
