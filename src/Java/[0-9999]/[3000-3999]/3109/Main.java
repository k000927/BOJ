import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 0번 열의 0~R-1행의 C-1행까지의 경로를 순서대로 탐색한다. 
 * 
 * 2. 다음 노드를 선택할 때 우선순위는 오른쪽 위 > 오른쪽 > 오른쪽 아래로 한다.
 * 
 * 3. canPiped[][]에 파이프를 설치 가능한지 기록한다. true일 때 해당 노드에 빌딩과 파이프가 존재하지 않음을 나타낸다.
 * 
 * 4. pipingIn(int r, int c) -> O(3^C)=
 * 		4.2. c == C-1일 때 파이프 설치가 완료됐으므로 isPiped = true를 기록하고 리턴한다.
 * 		4.3. (r-1, c+1), (r, c+1), (r+1, c+1)을 순서대로 탐색하며 아래를 실행한다.
 * 			4.3.0. 인덱스가 배열의 범위를 벗어났는지 확인한다.
 * 			4.3.1. canPiped[nr][nc] == true라면 continue
 * 			4.3.2. canPiped[nr][nc] = true 기록
 * 			4.3.3. pipingIn(nr, nc) 호출
 * 			4.3.4. 만약 isPiped == true라면 리턴한다. (이미 파이프 설치 완료됨)
 * 
 * 5. 0 <= r < R 범위의 pipingIn(r, 0) 호출, isPiped == true일 때 정답변수 +1
 */

public class Main {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 입력 행 수
	static int R;

	// 입력 열 수
	static int C;

	// 파이프 연결 성공 여부
	static boolean isPiped;

	// 파이프 연결 가능 여부
	static boolean[][] canPiped;

	// 델타 배열
	static int[] dr = { -1, 0, 1 };

	// 파이프 연결 메서드 => (rIndex, cIndex) 위치에서 파이프 연결
	static void pipingIn(int rIndex, int cIndex) {

		// 파이프 연결이 성공했을 때
		if (cIndex == C - 1) {
			isPiped = true;
			return;
		}

		for (int dIndex = 0; dIndex < 3; dIndex++) {
			int nextR = rIndex + dr[dIndex];

			// 배열의 범위를 벗어나거나 파이프를 설치할 수 없는 곳일 때
			if (nextR < 0 || nextR >= R || !canPiped[nextR][cIndex + 1])
				continue;

			canPiped[nextR][cIndex + 1] = false;
			pipingIn(nextR, cIndex + 1);
			// 이미 파이프가 연결된 경우
			// 탐색한 노드는 연결 불가 or 이미 연결된 파이프이므로 원상복구할 필요 없음
			if (isPiped)
				return;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		int pipingCount = 0;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		canPiped = new boolean[R][C];

		for (int rIndex = 0; rIndex < R; rIndex++) {
			String line = br.readLine();
			for (int cIndex = 0; cIndex < C; cIndex++) {
				// 파이프를 설치할 수 있다면 true
				canPiped[rIndex][cIndex] = line.charAt(cIndex) == '.';
			}
		}

		for (int rIndex = 0; rIndex < R; rIndex++) {
			// isPiped 초기화
			isPiped = false;

			pipingIn(rIndex, 0);

			// 파이프 설치가 완료되었다면 정답 변수 +1
			if (isPiped)
				pipingCount++;
		}

		System.out.println(pipingCount);
	}
}
