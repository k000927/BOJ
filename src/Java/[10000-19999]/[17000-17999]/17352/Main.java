import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static List<List<Integer>> adj;

    static void bfs() {
        visited[1] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer next : adj.get(cur)) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new LinkedList<>());
        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visited = new boolean[N + 1];
        bfs();

        for (int i = 2; i <= N; i++) {
            if (visited[i]) continue;
            System.out.println("1 " + i);
            break;
        }
    }
}