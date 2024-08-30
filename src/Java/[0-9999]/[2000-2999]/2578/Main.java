import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static Boolean[][] bingoResult;

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int getResult() {
        int res = 0;

        for (int i = 0; i < 5; i++) {
            if (bingoResult[i][0] && bingoResult[i][1] && bingoResult[i][2] && bingoResult[i][3] && bingoResult[i][4])
                res++;
            if (bingoResult[0][i] && bingoResult[1][i] && bingoResult[2][i] && bingoResult[3][i] && bingoResult[4][i])
                res++;
        }
        if (bingoResult[0][0] && bingoResult[1][1] && bingoResult[2][2] && bingoResult[3][3] && bingoResult[4][4])
            res++;
        if (bingoResult[0][4] && bingoResult[1][3] && bingoResult[2][2] && bingoResult[3][1] && bingoResult[4][0])
            res++;

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] bingo = new int[5][5];
        bingoResult = new Boolean[5][5];
        HashMap<Integer, Pos> bingoMap = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            Arrays.fill(bingoResult[i], false);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                bingo[i][j] = num;
                bingoMap.put(num, new Pos(i, j));
            }
        }

        int ans = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ans++;
                int num = Integer.parseInt(st.nextToken());
                Pos pos = bingoMap.get(num);
                bingoResult[pos.x][pos.y] = true;

                if (getResult() >= 3) {
                    System.out.println(ans);
                    System.exit(0);
                }
            }
        }

    }
}
