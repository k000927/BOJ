import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 꼬이지 않은 전깃줄은 전봇대 번호가 항상 증가함 -> LIS
 * 전체 길이에서 LIS의 길이만큼을 빼주면 정답
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = nextInt();

		int[] LIS = new int[N];

		int length = 0;
		int idx, num;
		for (int i = 0; i < N; i++) {
			num = nextInt();
			idx = binarySearch(LIS, 0, length, num) * -1 - 1;

			if (idx == length)
				LIS[length++] = num;
			else
				LIS[idx] = num;
		}

		System.out.println(N - length);
	}

	private static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid;
		}
		return -(low + 1);
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
