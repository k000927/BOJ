import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long[] arr;
    static Queue<Long> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(st.nextToken());

            arr[i] = num;
            queue.add(num);
        }

        long num = 0;
        while (K-- > 0) {
            num = queue.poll();

            for (int i = 0; i < N; i++) {
                long next = num * arr[i];
                if (next > (long) Math.pow(2, 31)) break;
                queue.add(next);

                if (num % arr[i] == 0) break;
            }
        }

        System.out.println(num);
    }
}