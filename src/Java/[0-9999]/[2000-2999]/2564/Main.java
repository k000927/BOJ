import java.io.*;
import java.util.*;

public class Main {
    static int W, H, N, length;
    static int dong;
    static int[] dir, pos;

    static final int NORTH = 1, SOUTH = 2, WEST = 3, EAST = 4;

    static int getDist(int dir, int pos) {
        if (dir == NORTH) {
            return pos;
        } else if (dir == SOUTH) {
            return W + H + (W - pos);
        } else if (dir == WEST) {
            return W * 2 + H + (H - pos);
        } else {
            return W + pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        length = 2 * (W + H);

        N = Integer.parseInt(br.readLine());
        dir = new int[N];
        pos = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            pos[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        dong = getDist(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int store = getDist(dir[i], pos[i]);
            if (store > dong) {
                ans += Math.min(store - dong, dong + length - store);
            } else {
                ans += Math.min(length - dong + store, dong - store);
            }
        }

        System.out.println(ans);
    }
}