import java.util.*;
import java.io.*;

public class Main {

    static final int N = 9;
    static int[][] map = new int[N][N];
    static ArrayList<int[]> list = new ArrayList<>(); // 빈 칸의 좌표가 들어갈 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                // 빈 칸의 좌표를 리스트에 넣음
                if (map[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        bt(0);

    }

    static void bt(int depth) {

        if (list.size() == depth) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

            // 여러 케이스가 나올 수 있으므로 return 대신
            // 시스템 종료를 통해 최초로 조합된 경우만 출력하고 끝낸다.
            System.exit(0);
        }


        int x = list.get(depth)[0];
        int y = list.get(depth)[1];

        // 이미 있는 숫자인지 체크할 배열
        boolean[] check = new boolean[10];

        // 가로 체크
        for (int i = 0; i < 9; i++) {
            if (map[x][i] != 0) {
                check[map[x][i]] = true;
            }
        }

        // 세로 체크
        for (int i = 0; i < 9; i++) {
            if (map[i][y] != 0) {
                check[map[i][y]] = true;
            }
        }

        // 네모 체크
        int firstX = (x / 3) * 3;
        int firstY = (y / 3) * 3;
        for (int i = firstX; i < firstX + 3; i++) {
            for (int j = firstY; j < firstY + 3; j++) {
                if (map[i][j] != 0) {
                    check[map[i][j]] = true;
                }
            }
        }

        // 넣을 수 있는 숫자 넣음
        for (int i = 1; i <= 9; i++) {
            if (!check[i]) {
                map[x][y] = i;
                bt(depth + 1);
                map[x][y] = 0;
            }
        }

    }

}