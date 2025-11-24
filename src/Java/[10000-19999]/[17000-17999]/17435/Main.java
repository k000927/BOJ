import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, Q;

    static int[][] sparseTable;

    static void setTable() {
        for (int j = 1; j < 19; j++) {
            for (int i = 1; i <= M; i++) {
                sparseTable[i][j] = sparseTable[sparseTable[i][j - 1]][j - 1];
            }
        }
    }

    static int query(int n, int x) {
        for (int i = 18; i >= 0; i--) {
            if ((n & (1 << i)) == 0)
                continue;
            x = sparseTable[x][i];
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());

        sparseTable = new int[M + 1][19];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sparseTable[i][0] = Integer.parseInt(st.nextToken());
        }

        setTable();

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            ans.append(query(n, x)).append('\n');
        }

        System.out.print(ans);
    }
}
