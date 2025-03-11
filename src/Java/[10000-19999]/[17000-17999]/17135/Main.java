import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/*
 * 1. 병사를 배치한다.
 *
 * 2. 게임을 진행한다.
 *      2.1. 병사의 사거리 안에 있는 적을 공격한다.
 *          2.1.1. 그러한 적이 여러 명이라면 왼쪽 적을 우선한다.
 *      2.2. 쓰러트린 적의 수만큼 count를 더해준다.
 *      2.3. 병사들을 한 칸 전진시킨다.
 */

public class Main {
    static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    // 격자판의 행의 수, 열의 수, 궁수의 사거리
    static int N, M, D;

    // 격자판의 상태
    static int[][] board;

    // 격자판 임시 배열
    static int[][] tempBoard;

    // 제거할 수 있는 적의 최댓값
    static int maxEliminateCount = 0;

    // 궁수들의 위치
    static int[] archerPos;

    // 처치된 적 저장하는 배열
    static int[][] eliminatedArray;

    // 해당 위치의 적을 사살할 수 있는지 판단하는 메서드
    // -1 -> 범위를 벗어났거나 해당 칸에 적이 없음
    // 0 -> 이미 사살한 적을 사살
    // 1 -> 적 사살 성공
    static int isEliminated(int i, int j, int round) {
        // OutOfBounds
        if (i < 0 || j < 0 || i >= N || j >= M) return -1;

        // 해당 위치에 적이 없음
        if (board[i][j] == 0) return -1;

        // 사살 가능한 적
        if (eliminatedArray[i][j] == 0) {
            eliminatedArray[i][j] = round;
            return 1;
        }

        // 이전 라운드에 사살된 상태
        else if (eliminatedArray[i][j] < round) return -1;

            // 해당 위치에 적이 있지만 이번 라운드에 이미 사살된 상태
        else return 0;
    }

    // 적 처치 메서드, 파라미터는 현재 궁수의 위치, 적 처치 성공 시 1 반환
    static int shoot(int i, int j, int round) {
        // 궁수 사거리별 반복
        int eliminateFlag = 0;

        for (int range = 1; range <= D; range++) {

            for (int dx = 1; dx < range; dx++) {
                eliminateFlag = isEliminated(i - dx, j - (range - dx), round);
                if (eliminateFlag == 0) return 0;
                else if (eliminateFlag == 1) return 1;
            }

            eliminateFlag = isEliminated(i - range, j, round);
            if (eliminateFlag == 0) return 0;
            else if (eliminateFlag == 1) return 1;

            for (int dx = range - 1; dx >= 1; dx--) {
                eliminateFlag = isEliminated(i - dx, j + (range - dx), round);
                if (eliminateFlag == 0) return 0;
                else if (eliminateFlag == 1) return 1;
            }
        }

        return 0;
    }

    // 게임 시작 메서드
    static int simulateGame() {
        int score = 0;

        eliminatedArray = new int[N][M];

        tempBoard = new int[N][M];
        for (int r = 0; r < N; r++) {
            tempBoard[r] = Arrays.copyOf(board[r], board[r].length);
        }

        for (int round = 1; round <= N; round++) {
            for (int archerIndex = 0; archerIndex < 3; archerIndex++) {
                score += shoot(N - round + 1, archerPos[archerIndex], round);
            }
        }

        return score;
    }

    // 궁수를 배치하는 메서드, 파라미터는 각각 배치할 위치, 궁수의 넘버
    static void placeArcher(int pos, int archerIndex) {
        // 만약 모든 궁수를 배치했다면
        if (archerIndex == 3) {
            maxEliminateCount = Math.max(maxEliminateCount, simulateGame());
            return;
        }

        // 만약 궁수를 배치하지 못했다면
        if (pos == M)
            return;

        placeArcher(pos + 1, archerIndex);

        archerPos[archerIndex] = pos;
        placeArcher(pos + 1, archerIndex + 1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = nextInt();
        M = nextInt();
        D = nextInt();

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = nextInt();
            }
        }

        archerPos = new int[3];
        placeArcher(0, 0);

        System.out.println(maxEliminateCount);
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}


