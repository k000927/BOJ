import java.io.*;
import java.util.*;

public class Main {
    static int N, M, pack, piece, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pack = piece = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        if (piece * 6 <= pack) ans = piece * N;
        else {
            ans = (N / 6) * pack;
            if (N % 6 * piece <= pack)
                ans += (N % 6) * piece;
            else
                ans += pack;
        }

        System.out.println(ans);
    }
}