import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] adj;
    static Node[] nodes;
    static Deque<Node> queue = new ArrayDeque<>();

    static class Node {
        int num;
        int inDegree;

        Node(int num, int inDegree) {
            this.num = num;
            this.inDegree = inDegree;
        }
    }

    static void setQueue() {
        for (int i = 1; i < n + 1; i++) {
            if (nodes[i].inDegree == 0) {
                queue.addLast(nodes[i]);
                nodes[i] = null;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        nodes = new Node[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            nodes[i] = new Node(i, 0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            nodes[b].inDegree += 1;
        }

        setQueue();
        while(!queue.isEmpty()) {
            Node curNode = queue.removeFirst();

            bw.write(curNode.num + " ");
            for (Integer dest : adj[curNode.num]) {
                nodes[dest].inDegree -= 1;
                if(nodes[dest].inDegree == 0) {
                    queue.addLast(nodes[dest]);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}