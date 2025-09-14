import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Queue<Node> pq;

    // flag == true -> 시작 노드
    static class Node implements Comparable<Node> {
        int time;
        boolean flag;

        Node(int time, boolean flag) {
            this.time = time;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time != o.time) {
                return Integer.compare(this.time, o.time);
            }

            if (!this.flag) {
                return -1;
            } else return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Node(start, true));
            pq.add(new Node(end, false));
        }

        int max = 0;
        int start = 0, end = 0, cur = 0;
        boolean isMax = false;
        while (!pq.isEmpty()) {
            Node n = pq.poll();

            if (n.flag) {
                cur++;
                if (cur > max) {
                    max = cur;
                    start = n.time;
                    isMax = true;
                } else if (cur == max && end == n.time) {
                    isMax = true;
                }
            } else {
                if (isMax) {
                    end = n.time;
                    isMax = false;
                }
                cur--;
            }
        }

        System.out.println(max + "\n" + start + " " + end);
    }
}