import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Token> tokens;
	static StringTokenizer st;

	static class Token implements Comparable<Token> {
		int index;
		int num;
		boolean flag;

		Token(int index, int num, boolean flag) {
			this.index = index;
			this.num = num;
			this.flag = flag;
		}

		@Override
		public int compareTo(Token c) {
			return Integer.compare(index, c.index);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		tokens = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			tokens.add(new Token(x - r, i + 1, false));
			tokens.add(new Token(x + r, i + 1, true));
		}

		Collections.sort(tokens);

		ArrayList<Integer> stack = new ArrayList<>();
		stack.add(0);
		for (Token token : tokens) {
			if (token.flag) {
				Integer prev = stack.remove(stack.size() - 1);
				if (prev != token.num) {
					System.out.println("NO");
					System.exit(0);
				}
			} else {
				stack.add(token.num);
			}
		}

		System.out.println("YES");
	}
}
