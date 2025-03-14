import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static StringBuilder ans = new StringBuilder();
	static boolean monkeyFlag;

	static void print(int repeat) {
		if (repeat == 0)
			return;
		for (int i = 0; i < repeat; i++) {
			ans.append(monkeyFlag ? 'A' : 'B');
		}

		monkeyFlag = !monkeyFlag;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		queue.add(-1);

		int teamCount = 0;
		monkeyFlag = true;
		while (teamCount < 7) {
			int num = queue.poll();

			if (num == -1) {
				queue.add(-1);
				ans.append("\n");
				teamCount++;
			} else if (num % 2 == 0) {
				queue.add(num / 2);
				queue.add(num / 2);

				print(num / 2);
				print(num / 2);
			} else {
				queue.add(num / 2);
				queue.add(num / 2 + 1);

				print(num / 2);
				print(num / 2 + 1);
			}
		}

		System.out.println(ans);
	}
}
