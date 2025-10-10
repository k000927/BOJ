import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int TC;
    static int N;
    static int M;
    static int[] inDegree;
    static boolean[][] arr;
    static Queue<Integer> queue;
    static StringBuilder ans = new StringBuilder(), sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (TC-- > 0) {
            queue = new LinkedList<>();
            N = Integer.parseInt(br.readLine());
            inDegree = new int[N + 1];
            arr = new boolean[N + 1][N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                inDegree[now] = i;
                for (int j = 1; j <= N; j++) {
                    if (j != now && !arr[j][now]) arr[now][j] = true;
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                swap(from, to);
            }

            ans.append(topology()).append("\n");
        }
        System.out.println(ans);
    }

    static void swap(int from, int to) {
        if (!arr[from][to]) {
            arr[from][to] = true;
            arr[to][from] = false;
            inDegree[from]--;
            inDegree[to]++;
        } else {
            arr[from][to] = false;
            arr[to][from] = true;
            inDegree[from]++;
            inDegree[to]--;
        }
    }

    static String topology() {
        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        for (int i = 1; i <= N; i++) {
            if (queue.isEmpty()) return "IMPOSSIBLE";
            else if (queue.size() > 1) return "?";

            int now = queue.poll();
            sb.append(now).append(" ");

            for (int j = 1; j <= N; j++) {
                if (arr[now][j]) {
                    arr[now][j] = false;
                    if (--inDegree[j] == 0) queue.add(j);
                }
            }
        }
        return sb.toString();
    }
}