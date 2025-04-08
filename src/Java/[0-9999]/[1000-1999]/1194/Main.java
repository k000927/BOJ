import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BFS
 */

public class Main {
	static char[][] map;
	// 위치정보 + 키
	static boolean[][][] visited;
	static int N, M;
	static int startX, startY;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static Queue<Pos> queue = new ArrayDeque<>();

	static class Pos {
		int x, y, key, count;

		Pos(int x, int y, int key, int count) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}
	}

	static void bfs() {
		visited[startX][startY][0] = true;
		queue.add(new Pos(startX, startY, 0, 0));

		Pos curPos;
		int nx, ny, nKey, nCount;
		while (!queue.isEmpty()) {
			curPos = queue.poll();

			for (int i = 0; i < 4; i++) {
				nx = curPos.x + dx[i];
				ny = curPos.y + dy[i];
				nKey = curPos.key;
				nCount = curPos.count + 1;

				// OutOfBounds
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				// 벽일 경우
				if (map[nx][ny] == '#')
					continue;

				// 열쇠 칸일 경우
				if ('a' <= map[nx][ny] && map[nx][ny] <= 'f')
					nKey |= (1 << (map[nx][ny] - 'a'));

				// 문일 경우
				if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					// 열쇠가 없는 경우
					if ((nKey & (1 << (map[nx][ny] - 'A'))) == 0)
						continue;
				}

				// 방문한 경우
				if (visited[nx][ny][nKey])
					continue;

				// 출구일 경우
				if (map[nx][ny] == '1') {
					System.out.println(nCount);
					return;
				}

				// 방문 처리
				visited[nx][ny][nKey] = true;
				queue.add(new Pos(nx, ny, nKey, nCount));
			}
		}

		System.out.println(-1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64];

		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}

		bfs();
	}
}
