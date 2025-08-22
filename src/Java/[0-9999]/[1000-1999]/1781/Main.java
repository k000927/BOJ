import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    static Queue<Homework> homeworkQueue;
    static Queue<Integer> solvedHomework;

    static class Homework implements Comparable<Homework> {
        int dead, ramen;

        Homework(int dead, int ramen) {
            this.dead = dead;
            this.ramen = ramen;
        }

        private static final Comparator<Homework> COMPARATOR =
                Comparator.comparingInt((Homework h) -> h.dead)
                        .thenComparing(Comparator.comparingInt((Homework h) -> h.ramen).reversed());

        @Override
        public int compareTo(Homework h) {
            return COMPARATOR.compare(this, h);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        homeworkQueue = new PriorityQueue<>();
        solvedHomework = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int dead = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            homeworkQueue.add(new Homework(dead, ramen));
        }

        while (!homeworkQueue.isEmpty()) {
            Homework h = homeworkQueue.poll();

            if (solvedHomework.size() < h.dead) {
                solvedHomework.add(h.ramen);
            } else {
                if (h.ramen > solvedHomework.peek()) {
                    solvedHomework.poll();
                    solvedHomework.add(h.ramen);
                }
            }
        }

        int ans = 0;
        while (!solvedHomework.isEmpty()) {
            ans += solvedHomework.poll();
        }

        System.out.println(ans);
    }
}
