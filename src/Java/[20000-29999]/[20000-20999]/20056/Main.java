import java.io.*;
import java.util.*;

class Main {
    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;

        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static class Map {
        ArrayList<Integer> balls;

        Map() {
            balls = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<FireBall> fb = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fb.add(new FireBall(r, c, m, s, d));
        }

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        Map[][] map = new Map[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new Map();
            }
        }
        int curMove = 0;
        while (curMove++ < K) {
            ArrayList<FireBall> next_fb = new ArrayList<>();
            for (int i = 0; i < fb.size(); i++) {
                FireBall fireBall = fb.get(i);
                int nextR = (fireBall.r + N + fireBall.s % N * dx[fireBall.d]) % N;
                int nextC = (fireBall.c + N + fireBall.s % N * dy[fireBall.d]) % N;
                map[nextR][nextC].balls.add(i);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].balls.size() == 0) continue;
                    if (map[i][j].balls.size() == 1) {
                        FireBall f = fb.get(map[i][j].balls.get(0));
                        next_fb.add(new FireBall(i, j, f.m, f.s, f.d));
                    } else {
                        int next_m = 0;
                        int next_s = 0;
                        Boolean allEven = true;
                        Boolean allOdd = true;
                        for (int k : map[i][j].balls) {
                            FireBall f = fb.get(k);
                            next_m += f.m;
                            next_s += f.s;
                            if (f.d % 2 != 0) {
                                allEven = false;
                            } else {
                                allOdd = false;
                            }
                        }
                        next_m = (int) Math.floor(next_m / 5);
                        next_s = (int) Math.floor(next_s / map[i][j].balls.size());
                        if (next_m == 0)
                            continue;
                        int next_d = 1;
                        if (allEven || allOdd) next_d = 0;
                        for (int k = 0; k < 4; k++) {
                            next_fb.add(new FireBall(i, j, next_m, next_s, next_d + 2 * k));
                        }
                    }
                }
            }
            fb = next_fb;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].balls.size() > 0) {
                        map[i][j].balls.clear();
                    }
                }
            }
        }

        int ans = 0;
        for (FireBall f : fb) {
            ans += f.m;
        }
        System.out.println(ans);
    }
}