import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	private static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static int[] arr;
	static int[] prev;
	static int N;

	public static void main(String[] args) throws Exception {
		N = nextInt();
		arr = new int[N];
		prev = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = nextInt();
		}

		// LIS 저장 (값이 아닌 인덱스를 저장함)
		ArrayList<Integer> lisIndices = new ArrayList<>();
		int[] tracking = new int[N]; // lis에서 해당 인덱스가 어디 들어갔는지 저장

		lisIndices.add(0);
		tracking[0] = -1;
		prev[0] = -1;

		for (int i = 1; i < N; i++) {
			if (arr[i] > arr[lisIndices.get(lisIndices.size() - 1)]) {
				prev[i] = lisIndices.get(lisIndices.size() - 1);
				lisIndices.add(i);
			} else {
				int left = 0;
				int right = lisIndices.size() - 1;

				while (left < right) {
					int mid = (left + right) / 2;
					if (arr[lisIndices.get(mid)] >= arr[i]) {
						right = mid;
					} else {
						left = mid + 1;
					}
				}

				// 갱신
				if (arr[i] < arr[lisIndices.get(left)]) {
					lisIndices.set(left, i);
					prev[i] = (left == 0) ? -1 : lisIndices.get(left - 1);
				}
			}
		}

		// LIS 길이 출력
		System.out.println(lisIndices.size());

		// 수열 역추적
		Stack<Integer> stack = new Stack<>();
		int cur = lisIndices.get(lisIndices.size() - 1);

		while (cur != -1) {
			stack.push(arr[cur]);
			cur = prev[cur];
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
