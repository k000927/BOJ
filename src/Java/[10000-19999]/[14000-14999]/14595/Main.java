import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] walls = new int[N + 1];
        int x;
        int y;
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            walls[x] += 1;
            walls[y] -= 1;
        }

        for (int i = 1; i <= N; i++) {
            walls[i] += walls[i - 1];
        }

        int room = 0;
        for (int i = 1; i <= N; i++) {
            if (walls[i] == 0) room++;
        }

        System.out.println(room);
    }
}