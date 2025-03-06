import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 1. 현재 학생 수 curStudent가 N이 될 때까지 반복한다.
 * 		1.1. 현재 라벨 curLabel = 1부터 시작한다.
 * 		1.2. curLabel에 L이 없다면 curStudent++, curLabel++ 후 계속
 * 		1.3. curLabel에 L이 있다면 curLabel++ 후 계속
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	// label에 L이 포함되었는지 반환하는 메서드
	static boolean isContainsL(int label, int L) {
		return String.valueOf(label).contains(String.valueOf(L));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = nextInt();
		int L = nextInt();

		int curStudent = 0;
		int curLabel = 1;

		while (curStudent < N) {
			// L이 포함되지 않았다면 다음 학생으로 넘어감
			if (!isContainsL(curLabel, L))
				curStudent++;
			curLabel++;
		}

		// 마지막 라벨은 사용되지 않았으므로 -1 출력
		System.out.println(curLabel - 1);
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
