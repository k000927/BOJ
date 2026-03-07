import java.io.*;
import java.util.*;

public class Main {
    static int N, S, E, C, K;
    static final boolean START = true, END = false;
    static Queue<Stop> stopQueue;

    static class Stop implements Comparable<Stop> {
        int pos, cost;
        boolean flag;

        Stop(int pos, int cost, boolean flag) {
            this.pos = pos;
            this.cost = cost;
            this.flag = flag;
        }

        @Override
        public int compareTo(Stop o) {
            if (this.pos == o.pos) {
                if (this.flag == END) return 1;
                if (this.flag == START) return -1;
                return 0;
            } else return Integer.compare(this.pos, o.pos);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        stopQueue = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            stopQueue.add(new Stop(S, C, START));
            stopQueue.add(new Stop(E, C, END));
        }

        StringBuilder ans = new StringBuilder();
        Stop s;
        int minCost = Integer.MAX_VALUE;
        int startPos = -1, count = 0, k = 0;

        while (!stopQueue.isEmpty()) {
            s = stopQueue.poll();
            if (s.flag == START) {
                if (count++ == 0)
                    startPos = s.pos;
                minCost = Math.min(minCost, s.cost);
            } else {
                if (--count == 0) {
                    ans.append(startPos).append(' ').append(s.pos).append(' ').append(minCost).append('\n');
                    k++;
                    minCost = Integer.MAX_VALUE;
                }
            }
        }

        System.out.print(k + "\n" + ans);
    }
}