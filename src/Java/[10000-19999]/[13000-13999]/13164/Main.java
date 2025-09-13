import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans;
    static Queue<Integer> queue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            queue.add(cur - prev);
            ans += cur - prev;
            prev = cur;
        }

        for (int i = 0; i < K - 1; i++) {
            ans -= queue.poll();
        }

        System.out.println(ans);
    }
}