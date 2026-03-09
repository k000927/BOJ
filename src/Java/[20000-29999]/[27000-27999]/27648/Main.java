import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringBuilder ans = new StringBuilder();
        if(K >= N + M - 1) {
            ans.append("YES").append('\n');
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    ans.append(i + j).append(' ');
                }
                ans.append('\n');
            }
        }
        else {
            ans.append("NO").append('\n');
        }

        System.out.print(ans);

    }
}