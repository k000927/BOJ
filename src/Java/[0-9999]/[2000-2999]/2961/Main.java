import java.io.*;
import java.util.*;

/*
1. N을 입력받는다. [N]의 크기를 가지는 신 맛과 쓴 맛의 배열 sour, bitter를 선언한다.

2. N줄을 입력받아 sour와 bitter 배열을 업데이트한다.

3. mixIngredient 메서드를 재귀 호출하며 재료들의 부분집합을 구한다.
    3.1. mixIngredient 메서드에는 ingredientIndex, bitterScore, sourScore를 매개변수로 갖는다.
        3.1.1. minIngredient: 현재 재료의 인덱스
        3.1.2. bitterScore: 현재 단계의 쓴 맛
        3.1.3. sourScore: 현재 단계의 신 맛
    3.2. ingredientIndex == n일 때 탐색을 종료한다. 하지만 bitterScore == 0. sourScore == 1이라면 아무 재료도 사용하지 않았으므로 리턴한다.
        3.2.1. bitterScore, sourScore의 차이를 현재 최솟값과 비교하여 업데이트한다.
    3.3. 현재 재료를 선택했을때, ingredientIndex+1, bitterScore+현재 쓴 맛, sourScore * 현재 신 맛으로 재귀 호출한다.
    3.6. 인덱스만을 업데이트하여 재귀호출

4. 최솟값 출력
 */
public class Main {
    // 재료의 개수
    static int n;

    // 신 맛 배열
    static int[] sour;
    // 쓴 맛 배열
    static int[] bitter;

    // 신 맛과 쓴 맛의 최소 차이
    static int minDiff = Integer.MAX_VALUE;

    static void ingredientSubSet(int ingredientIndex, int bitterScore, int sourScore) {
        // ingredientIndex == n 인덱스의 마지막까지 탐색 완료됨
        if (ingredientIndex == n) {
            // bitterScore == 0 이거나 sourScore == 1이라면 아무 재료도 추가하지 않았음
            // 최솟값 업데이트하지 않음
            if (bitterScore != 0 || sourScore != 1) {
                minDiff = Math.min(minDiff, Math.abs(bitterScore - sourScore));
            }
            return;
        }

        // 현재 재료를 추가한 경우
        ingredientSubSet(ingredientIndex + 1, bitterScore + bitter[ingredientIndex], sourScore * sour[ingredientIndex]);
        // 현재 재료를 추가하지 않은 경우
        ingredientSubSet(ingredientIndex + 1, bitterScore, sourScore);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        sour = new int[n];
        bitter = new int[n];

        for (int input = 0; input < n; input++) {
            st = new StringTokenizer(br.readLine());
            sour[input] = Integer.parseInt(st.nextToken());
            bitter[input] = Integer.parseInt(st.nextToken());
        }

        ingredientSubSet(0, 0, 1);
        System.out.println(minDiff);
    }
}