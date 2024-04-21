import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    static int v;
    static int e;
    static ArrayList<Node> nodeList;
    static int[] parents;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parents = new int[v + 1];
        nodeList = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList.add(new Node(from, to, cost));
        }

        Collections.sort(nodeList);

        make();

        int sum = 0;
        int cnt = 0;
        for (Node n : nodeList) {
            if (union(n.from, n.to)) {
                sum += n.cost;
                cnt++;

                if (cnt == e - 1) break;
            }
        }
        System.out.println(sum);
    }

    private static void make() {
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
    }

    private static Boolean union(int from, int to) {
        int fromRoot = findSet(from);
        int toRoot = findSet(to);

        if (fromRoot == toRoot) return false;
        else parents[toRoot] = fromRoot;
        return true;
    }

    private static int findSet(int v) {
        if (parents[v] == v) return v;
        else return parents[v] = findSet(parents[v]);
    }
}