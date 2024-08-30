import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Homework implements Comparable<Homework>{
        int d;
        int t;

        Homework(int d, int t) {
            this.d = d;
            this.t = t;
        }

        @Override
        public int compareTo(Homework o) {
            return Integer.compare(o.t, this.t);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Homework> homework = new PriorityQueue<>();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            ans = Math.max(ans, t);
            homework.add(new Homework(d, t));
        }

        while (!homework.isEmpty()) {
            Homework curHomework = homework.poll();

            if (ans >= curHomework.t) ans = curHomework.t - curHomework.d;
            else{
                ans -= curHomework.d;
            }
        }

        System.out.println(ans);
    }
}
