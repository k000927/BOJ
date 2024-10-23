import java.util.Scanner;

public class Main {

    static int[][] shape = {
            {1, 3},
            {2, 3},
            {3, 1},
            {3, 2},
            {3, 3},
            {3, 4},
            {3, 5},
            {4, 2},
            {4, 3},
            {4, 4},
            {5, 2},
            {5, 4}
    };

    static char[][] stars;

    public static void drawStars(int x, int y, int size) {
        // 재귀 호출 대신 반복문을 사용하여 별을 한 번에 그림
        if (size == 1) {
            stars[x - 1][y - 1] = '*';
            return;
        }

        int newSize = size / 5;
        int startX = x - size;
        int startY = y - size;

        for (int[] s : shape) {
            int i = s[0], j = s[1];
            int nextX = startX + newSize * i;
            int nextY = startY + newSize * j;
            // 다음 위치에서 작은 별을 재귀적으로 그림
            drawStars(nextX, nextY, newSize);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int lenLine = (int) Math.pow(5, N);
        stars = new char[lenLine][lenLine];

        // 배열을 한 번에 초기화
        for (int i = 0; i < lenLine; i++) {
            for (int j = 0; j < lenLine; j++) {
                stars[i][j] = ' ';
            }
        }

        // 별 그리기 시작
        drawStars(lenLine, lenLine, lenLine);

        // StringBuilder를 사용하여 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenLine; i++) {
            for (int j = 0; j < lenLine; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        // 한 번에 출력
        System.out.print(sb.toString());
    }
}
