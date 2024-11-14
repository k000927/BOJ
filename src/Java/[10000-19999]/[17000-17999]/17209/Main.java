import java.util.*;

class Main {
    static int n, res;
    static int[] C = new int[2000];
    static boolean[][] adj = new boolean[2000][2000];

    static Pair DFS(int cur, int c) {
        Pair ret = new Pair(c == 1 ? 1 : 0, c == 2 ? 1 : 0);
        C[cur] = c;
        for (int nxt = 0; nxt < n; nxt++) {
            if (adj[cur][nxt] && C[nxt] == 0) {
                Pair sub = DFS(nxt, c ^ 3);
                ret.first += sub.first;
                ret.second += sub.second;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String c = sc.next();
            for (int j = 0; j < n; j++) {
                if ((c.charAt(j) & 1) != 0) {
                    adj[i][j] = adj[j][i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (C[i] == 0) {
                Pair result = DFS(i, 1);
                res += Math.max(result.first, result.second);
            }
        }

        System.out.println(res);
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
