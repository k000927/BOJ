import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0, count = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            count++;
            ans = Math.max(ans, x * count);
        }

        System.out.println(ans);
    }
}