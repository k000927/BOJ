import java.io.*;
import java.util.*;

public class Main {
    static int n, k, ans;
    static List<List<Integer>> map;
    static boolean[] visited;
    static boolean[] apartment;

    static boolean dfs(int cur) {
        visited[cur] = true;
        boolean flag = false;

        for (Integer i : map.get(cur)) {
            if (visited[i]) continue;

            if (apartment[i]) flag = true;
            else if (dfs(i)) flag = true;
        }

        if (!flag && !apartment[cur]) return false;

        ans++;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        apartment = new boolean[n + 1];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(st.nextToken());
            apartment[a] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (apartment[i] && !visited[i]) dfs(i);
        }

        System.out.println(ans);
    }
}