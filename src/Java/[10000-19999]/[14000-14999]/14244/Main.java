import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int cnt = 0, node = 0;

        if (M == 2) cnt = 1;

        for (int i = 1; i < N; i++) {
            if (M > cnt) {
                System.out.printf("0 %d\n", i);
                cnt++;
            } else {
                System.out.printf("%d %d\n", node, i);
            }
            node = i;
        }
    }
}