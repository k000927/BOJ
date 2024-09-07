import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int d;
    static int c;

    static int a;
    static int b;
    static int s;

    static int[] ans;
    static List<Node>[] map;
    static HashSet<Integer> visited;

    static int maxTime;

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(c, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited.contains(curr.num)) {
                continue;
            }

            for (Node node : map[curr.num]) {
                if (ans[node.num] > ans[curr.num] + node.weight) {
                    ans[node.num] = ans[curr.num] + node.weight;
                    pq.add(new Node(node.num, ans[node.num]));
                }
            }

            visited.add(curr.num);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            visited = new HashSet<>();
            ans = new int[n + 1];
            Arrays.fill(ans, Integer.MAX_VALUE);
            map = new List[n + 1];
            for (int i = 0; i < n + 1; i++) {
                map[i] = new ArrayList<>();
            }

            maxTime = 0;

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                map[b].add(new Node(a, s));
            }

            ans[c] = 0;
            dijkstra();
            for (int an : ans) {
                if(an == Integer.MAX_VALUE) continue;
                maxTime = Math.max(maxTime, an);
            }
            System.out.println(visited.size() + " " + maxTime);
        }
    }
}