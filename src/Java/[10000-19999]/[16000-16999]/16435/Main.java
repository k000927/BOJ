import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 입력값들을 오름차순 정렬한다.
 * 
 * 2. 배열을 순회하며 아래를 수행한다.
 * 		2.1. 현재 요소가 스네이크버드의 키보다 작거나 같다면 스네이크버드의 키를 1 늘린다.
 * 		2.2. 현재 요소가 스네이크버드의 키보다 크다면 break 한다.
 */

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] fruit = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int fruitIndex = 0; fruitIndex < N; fruitIndex++) {
			fruit[fruitIndex] = Integer.parseInt(st.nextToken());
		}

		// fruit 오름차순 정렬
		Arrays.sort(fruit);
		for (int fruitIndex = 0; fruitIndex < N; fruitIndex++) {
			// 과일을 먹을 수 있을 때
			if (L >= fruit[fruitIndex])
				L++;
			// 먹을 수 없다면 break
			else
				break;
		}

		System.out.println(L);
	}
}
