import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		double dist = Math.sqrt(x * x + y * y);
		double minTime = dist;

		if (dist < d) {
			minTime = Math.min(minTime, 2 * t);
			minTime = Math.min(minTime, t + d - dist);
		}

		else if (dist == d) {
			minTime = Math.min(minTime, t);
		}

		else {
			minTime = Math.min(minTime, t * firstLargerCount(dist, d));
			minTime = Math.min(minTime,
					t * (firstLargerCount(dist, d) - 1) + dist - d * (firstLargerCount(dist, d) - 1));
		}

		System.out.println(minTime);
	}

	// x * cnt >= y이 되는 가장 작은 cnt
	static int firstLargerCount(double dist, double d) {
		int cnt = 0;
		while (d * cnt < dist) {
			cnt++;
		}
		return cnt;
	}
}
