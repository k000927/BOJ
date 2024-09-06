import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int x;

    static HashSet<Integer> visited = new HashSet<>();
    static int[] map;
    static ArrayList<Integer>[] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[n + 1];
        edge = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edge[i] = new ArrayList<>();
        }
        Arrays.fill(map, 1000000000);
        map[x] = 0;

        int src;
        int dest;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            src = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());

            edge[src].add(dest);
        }

        visited.add(0);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(x);

        while (!pq.isEmpty()) {
            int curNode = pq.poll();

            if (visited.contains(curNode)) continue;

            for (Integer i : edge[curNode]) {
                if(!visited.contains(i)) {
                    map[i] = Math.min(map[i], map[curNode] + 1);
                    pq.add(i);
                }
            }

            visited.add(curNode);
        }

        PriorityQueue<Integer> ans = new PriorityQueue<>();

        for (int i = 1; i < n + 1; i++) {
            if (map[i] == k) ans.add(i);
        }

        if(ans.isEmpty()) System.out.println(-1);
        else{
            while(!ans.isEmpty()){
                System.out.println(ans.poll());
            }
        }
    }
}