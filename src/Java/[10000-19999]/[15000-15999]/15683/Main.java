import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 1. 백트래킹을 이용하여 풀이
 *
 * 2. watch(cctvIndex, curRoom)
 * 		2.1. cctvIndex == cctvNum일 때 전부 탐색했으므로, 사각지대 수를 구하고 최댓값 갱신
 * 		2.2. curCCTV = cctvList[cctvIndex], 이 CCTV의 번호에 따라 감시 후 watch 호출
 */

public class Main {
    static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    // 방의 크기
    static int N, M;
    // cctv의 개수
    static int cctvNum;
    // cctv 배열
    static CCTV[] cctvList = new CCTV[8];
    // 방 상황
    static int[][] room;

    static class CCTV {
        int x, y;
        int type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    // 사각지대 최소 개수
    static int minBlindSpot = Integer.MAX_VALUE;

    // 각각 비트는 순서대로 상우하좌를 가리킨다.
    static int[][] cctvDir = {{}, {0b0001, 0b0010, 0b0100, 0b1000}, {0b1010, 0b0101},
            {0b1100, 0b0110, 0b0011, 0b1001}, {0b1110, 0b1101, 0b1011, 0b0111}, {0b1111}};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int temp;

    static void watch(int cctvIndex, long curRoom, int blindSpot) {
        // 만약 모든 cctv를 순회하였다면
        if (cctvIndex == cctvNum) {
            minBlindSpot = Math.min(minBlindSpot, blindSpot);
            return;
        }

        CCTV cur = cctvList[cctvIndex];
        for (int i = 0; i < cctvDir[cur.type].length; i++) {
            temp = 0;
            watch(cctvIndex + 1, checkRoom(curRoom, cctvDir[cur.type][i], cur.x, cur.y), blindSpot - temp);
        }
    }

    // 현재 방의 상태, cctv의 위치와 방향을 파라미터로 받아 감시 후의 방 상태를 리턴하는 메서드
    static long checkRoom(long curRoom, int cctvDir, int x, int y) {
        for (int d = 0; d < 4; d++) {
            if ((cctvDir & (1 << d)) == 0)
                continue;

            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[d];
                ny += dy[d];

                // out of bounds
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    break;

                // 벽을 마주한다면
                if (room[nx][ny] == 6)
                    break;

                if (curRoom != (curRoom |= (1L << ((N - nx - 1) * M + (M - ny - 1)))))
                    temp++;
            }
        }
        return curRoom;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = nextInt();
        M = nextInt();

        long curRoom = 0L;
        room = new int[N][M];
        int cnt = N * M;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = nextInt();
                curRoom <<= 1;

                if (room[i][j] != 0) {
                    curRoom |= 1;
                    cnt--;
                }

                if (room[i][j] >= 1 && room[i][j] <= 5)
                    cctvList[cctvNum++] = new CCTV(i, j, room[i][j]);
            }
        }

        watch(0, curRoom, cnt);

        System.out.println(minBlindSpot);
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}