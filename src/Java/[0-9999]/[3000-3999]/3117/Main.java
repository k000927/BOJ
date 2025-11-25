import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, M, MAX;
    static int[] start;
    static int[][] parseTable;

    static int query(int x) {
        for (int i = MAX; i >= 0; i--) {
            if (((M - 1) & (1 << i)) == 0)
                continue;
            x = parseTable[x][i];
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAX = (int) (Math.log10(M) / Math.log10(2));

        start = new int[N];
        parseTable = new int[K + 1][MAX + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            parseTable[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j <= MAX; j++) {
            for (int i = 1; i <= K; i++) {
                parseTable[i][j] = parseTable[parseTable[i][j - 1]][j - 1];
            }
        }

        for (int i = 0; i < N; i++) {
            ans.append(query(start[i])).append(' ');
        }

        System.out.println(ans);
    }
}
