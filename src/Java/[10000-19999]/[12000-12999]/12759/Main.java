import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int starter = Integer.parseInt(br.readLine());
        int another = starter == 1 ? 2 : 1;

        int[][] map = new int[4][4];
        int turn = 0;

        boolean isWin = false;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (i % 2 == 0) {
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = starter;
                turn = starter;
            } else {
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = another;
                turn = another;
            }

            isWin = process(map, turn);
            if (isWin) break;
        }

        System.out.println(isWin ? turn : 0);
    }

    private static boolean process(int[][] board, int t) {
        for (int i = 1; i < 4; i++) {
            if (board[i][1] == board[i][2] && board[i][2] == board[i][3] && t == board[i][1] && t == board[i][2] && t == board[i][3])
                return true;
            if (board[1][i] == board[2][i] && board[2][i] == board[3][i] && t == board[1][i] && t == board[2][i] && t == board[3][i])
                return true;
        }

        if (board[1][1] == board[2][2] && board[2][2] == board[3][3] && t == board[2][2] && t == board[1][1] && t == board[3][3])
            return true;
        if (board[3][1] == board[2][2] && board[2][2] == board[1][3] && t == board[2][2] && t == board[3][1] && t == board[1][3])
            return true;

        return false;
    }
}