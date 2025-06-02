import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int next;
        while (pq.size() != 1) {
            next = pq.poll() + pq.poll();
            pq.add(next);
            ans += next;
        }

        System.out.println(ans);
    }
}