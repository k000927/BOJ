import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 1. 슬라이딩 윈도우를 이용해서 풀이
 * 2. 첫 k-1개의 초밥들은 다시 사용해야 하므로 firstKSushi 배열에 저장해둔다.
 * 3. 윈도우의 크기가 k개가 될 때 까지 윈도우를 늘린다.
 * 		3.1. 이 때, 윈도우에 추가되는 초밥이 한 번도 선택되지 않았다면 현재 초밥의 종류를 1 늘려준다.
 * 4. 이 후 모든 입력을 읽어들일 동안 아래 연산을 실행한다.
 * 		4.1. 포인터가 가리키는 초밥을 1 줄인다. 이 때, 초밥의 가지수가 줄어든다면 반영한다.
 * 		4.2. 포인터가 가리키는 곳에 새로운 초밥을 추가한다. 이 때, 초밥의 가지수가 늘어난다면 반영한다.
 * 5. firstKSushi를 이용해 윈도우를 다시 갱신한다.
 */

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = nextInt();
		int d = nextInt();
		int k = nextInt();
		int c = nextInt();

		// 첫 k개의 배열
		int[] firstKSushi = new int[k];
		// 선택한 초밥
		int[] pick = new int[d + 1];
		// 윈도우
		int[] window = new int[k];
		// 최댓값 저장
		int maxSushi = 1;
		// 현재 초밥의 종류
		int curSushi = 1;

		// c번 스시 쿠폰 발행
		pick[c] = 1;

		// 첫번째 초밥과 마지막 초밥을 가리키는 포인터
		int sushiIndex = 0;

		// 첫 K개의 초밥으로 윈도우 구성
		for (int i = 0; i < k; i++) {
			firstKSushi[i] = nextInt();
			// 만약 초밥 업데이트가 일어난다면
			if (pick[firstKSushi[i]]++ == 0) {
				maxSushi = Math.max(maxSushi, ++curSushi);
			}
			window[sushiIndex] = firstKSushi[i];
			sushiIndex = (sushiIndex + 1) % k;
		}

		int sushiNo;
		for (int i = k; i < N; i++) {
			sushiNo = nextInt();

			// 윈도우에서 가장 오래된 초밥 제거
			if (--pick[window[sushiIndex]] == 0)
				curSushi--;

			window[sushiIndex] = sushiNo;

			// 윈도우에 초밥 추가
			if (++pick[window[sushiIndex]] == 1) {
				curSushi++;
				maxSushi = Math.max(maxSushi, curSushi);
				// 만약 최댓값에 도달한다면
				if (maxSushi == k + 1) {
					System.out.println(maxSushi);
					System.exit(0);
				}
			}

			// 인덱스 업데이트
			sushiIndex = (sushiIndex + 1) % k;
		}

		for (int i = 0; i < k - 1; i++) {
			sushiNo = firstKSushi[i];

			if (--pick[window[sushiIndex]] == 0)
				curSushi--;

			window[sushiIndex] = sushiNo;

			if (++pick[window[sushiIndex]] == 1) {
				curSushi++;
				maxSushi = Math.max(maxSushi, curSushi);
				if (maxSushi == k + 1) {
					System.out.println(maxSushi);
					System.exit(0);
				}
			}

			sushiIndex = (sushiIndex + 1) % k;
		}

		System.out.println(maxSushi);

	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
