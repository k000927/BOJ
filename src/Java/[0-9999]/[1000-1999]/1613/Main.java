import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/*
 * 플로이드 워셜을 이용해 인접 리스트를 작성한다.
 *
 * A -> B가 가능하다면 A가 먼저 발생한 사건이다.
 * A -> B가 불가능하다면
 * 		B -> A가 가능하다면 B가 먼저 발생한 사건이다.
 * 		B -> A가 불가능하다면 두 사건은 연관이 없다.
 */

public class Main {
    static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder ans = new StringBuilder();
        int N, K, S;

        N = nextInt();
        K = nextInt();

        boolean[][] adj = new boolean[401][401];

        for (int i = 0; i < K; i++) {
            adj[nextInt()][nextInt()] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (adj[i][k]) {
                    for (int j = 1; j <= N; j++)
                        adj[i][j] = adj[i][j] || (adj[i][k] && adj[k][j]);
                }
            }
        }

        S = nextInt();
        int A, B;
        for (int i = 0; i < S; i++) {
            A = nextInt();
            B = nextInt();

            if (adj[A][B])
                ans.append(-1).append('\n');
            else if (adj[B][A])
                ans.append(1).append('\n');
            else
                ans.append(0).append('\n');

        }

        System.out.println(ans);
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}