import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] parent;

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;
        else if (x < y) parent[x] = y;
        else parent[y] = x;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            }
            else{
                int parentA = find(a);
                int parentB = find(b);
                
                if(parentA == parentB) System.out.println("YES");
                else System.out.println("NO");
            }
        }


    }
}