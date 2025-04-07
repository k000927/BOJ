import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] knapsack = new int[10001];
	static int N, M, V, C, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<Integer> vList = new ArrayList<>();
		List<Integer> cList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			for (int temp = 1; K > 0; temp <<= 1) {
				int ttemp = Math.min(temp, K);
				vList.add(V * ttemp);
				cList.add(C * ttemp);
				K -= ttemp;
			}
		}

		for (int i = 0; i < vList.size(); i++) {
			V = vList.get(i);
			C = cList.get(i);
			for (int j = M; j >= V; j--) {
				knapsack[j] = Math.max(knapsack[j], knapsack[j - V] + C);
			}
		}

		System.out.println(knapsack[M]);
	}
}
