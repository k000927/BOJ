import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] bomb = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(bomb[i], -1);
        }
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                if (temp.charAt(j) == 'O') {
                    bomb[i][j] = 0;
                }
            }
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        int cur_time = 1;
        while (cur_time < N) {
            cur_time++;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (bomb[i][j] != -1) {
                        continue;
                    }
                    bomb[i][j] = cur_time;
                }
            }
            if (cur_time >= N) break;
            cur_time++;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (cur_time - bomb[i][j] != 3) continue;
                    bomb[i][j] = -1;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < 0 || x >= R || y < 0 || y >= C) continue;
                        if (cur_time - bomb[x][y] == 3) continue;
                        bomb[x][y] = -1;
                    }
                }
            }
            if (cur_time >= N) break;
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
}