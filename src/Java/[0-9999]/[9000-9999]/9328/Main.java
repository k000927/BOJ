import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, w, h;
	static char[][] map = new char[100][100];
	static boolean[][] visited = new boolean[100][100];
	static boolean[] key = new boolean[26];
	static int ans;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Pos> deque = new ArrayDeque<>();

	static boolean bfs(int x, int y) {
		boolean flag = false;

		if ('A' <= map[x][y] && map[x][y] <= 'Z') {
			if (!key[map[x][y] - 'A'])
				return false;
		}

		if ('a' <= map[x][y] && map[x][y] <= 'z') {
			key[map[x][y] - 'a'] = true;
			map[x][y] = '.';
			flag = true;
		}

		if (map[x][y] == '$') {
			ans++;
			map[x][y] = '.';
			flag = true;
		}

		deque.add(new Pos(x, y));
		visited[x][y] = true;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				visited[i][j] = false;
			}
		}

		Pos cur;
		int nx, ny;
		while (!deque.isEmpty()) {
			cur = deque.poll();

			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w)
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] == '*')
					continue;

				if ('a' <= map[nx][ny] && map[nx][ny] <= 'z') {
					key[map[nx][ny] - 'a'] = true;
					map[nx][ny] = '.';
					flag = true;
				}

				if ('A' <= map[nx][ny] && map[nx][ny] <= 'Z') {
					if (!key[map[nx][ny] - 'A'])
						continue;
					map[nx][ny] = '.';
					flag = true;
				}

				if (map[nx][ny] == '$') {
					ans++;
					map[nx][ny] = '.';
					flag = true;
				}

				deque.add(new Pos(nx, ny));
				visited[nx][ny] = true;
			}
		}

		return flag;
	}

	static boolean solve() {
		for (int j = 0; j < w; j++) {
			if (map[0][j] != '*')
				if (bfs(0, j))
					return true;
		}

		for (int i = 1; i < h - 1; i++) {
			if (map[i][0] != '*')
				if (bfs(i, 0))
					return true;

			if (map[i][w - 1] != '*')
				if (bfs(i, w - 1))
					return true;
		}

		for (int j = 0; j < w; j++) {
			if (map[h - 1][j] != '*')
				if (bfs(h - 1, j))
					return true;
		}

		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			ans = 0;

			Arrays.fill(key, false);

			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			String keys = br.readLine();

			if (!keys.equals("0"))
				for (int i = 0; i < keys.length(); i++) {
					key[keys.charAt(i) - 'a'] = true;
				}

			while (true) {
				if (!solve())
					break;
			}

			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
