import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int m;
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true;
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (union(a, b) && !flag) {
                ans = i + 1;
                flag = true;
            }
        }
        System.out.println(ans);
    }
}