import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int Q;

    static Map<String, Queue<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Q = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        long ans = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (flag == 1) {
                int k = Integer.parseInt(st.nextToken());
                if (!map.containsKey(name)) {
                    map.put(name, new PriorityQueue<>(Collections.reverseOrder()));
                }
                for (int j = 0; j < k; j++) {
                    int C = Integer.parseInt(st.nextToken());
                    map.get(name).add(C);
                }
            } else {
                Queue<Integer> queue = map.get(name);
                if (queue == null) continue;
                int b = Integer.parseInt(st.nextToken());
                for (int j = 0; j < b && !queue.isEmpty(); j++) {
                    ans += queue.poll();
                }
            }
        }

        System.out.println(ans);
    }
}
