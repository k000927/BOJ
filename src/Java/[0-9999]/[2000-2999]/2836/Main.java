import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static class Node implements Comparable<Node> {
        int pos;
        boolean flag;

        Node(int pos, boolean flag) {
            this.pos = pos;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node o) {
            if (this.pos != o.pos) return Integer.compare(this.pos, o.pos);
            else {
                if (this.flag == o.flag) return 0;
                else if (this.flag) return -1;
                else return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start <= end) continue;

            queue.add(new Node(start, true));
            queue.add(new Node(end, false));
        }

        int count = 0, start = 0;
        long ans = M;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.flag) {
                count--;
                if (count == 0) ans += (node.pos - start) * 2L;
            } else {
                if (count == 0) start = node.pos;
                count++;
            }
        }

        System.out.println(ans);
    }
}