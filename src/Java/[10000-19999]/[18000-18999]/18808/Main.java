import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, R, C;
    static boolean[][] notebook;
    static boolean[][] sticker;

    static boolean isAttachable(int x, int y) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (notebook[x + i][y + j] && sticker[i][j]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j]) {
                    notebook[x + i][y + j] = true;
                }
            }
        }

        return true;
    }

    static void rotate() {
        int nextR = C;
        int nextC = R;

        boolean[][] nextSticker = new boolean[nextR][nextC];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                nextSticker[j][R - i - 1] = sticker[i][j];
            }
        }

        sticker = nextSticker;
        R = nextR;
        C = nextC;
    }

    static void attach() {
        for (int tc = 0; tc < 4; tc++) {
            for (int i = 0; i < N - R + 1; i++) {
                for (int j = 0; j < M - C + 1; j++) {
                    if (isAttachable(i, j)) {
                        return;
                    }
                }
            }
            rotate();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        notebook = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(notebook[i], false);
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticker = new boolean[R][C];

            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    sticker[r][c] = st.nextToken().equals("1");
                }
            }

            attach();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}