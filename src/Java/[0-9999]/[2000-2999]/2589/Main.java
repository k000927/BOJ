import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static int ans = Integer.MIN_VALUE;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visited;

	static class Pos {
		int x;
		int y;
		int dist;

		Pos(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static void bfs(int i, int j) {
		visited = new boolean[n][m];
		for (int x = 0; x < n; x++) {
			Arrays.fill(visited[x], false);
		}

		ArrayList<Pos> queue = new ArrayList<>();
		queue.add(new Pos(i, j, 0));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			Pos curPos = queue.remove(0);

			for (int k = 0; k < 4; k++) {
				int nx = curPos.x + dx[k];
				int ny = curPos.y + dy[k];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || map[nx][ny] == 'W')
					continue;

				queue.add(new Pos(nx, ny, curPos.dist + 1));
				visited[nx][ny] = true;
				ans = Math.max(ans, curPos.dist + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'W')
					continue;
				bfs(i, j);
			}
		}

		System.out.println(ans);

	}

}
