import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long N, P, Q;
    static Map<Long, Long> map;

    static long query(long N) {
        if (N == 0)
            return 1L;

        if (map.containsKey(N))
            return map.get(N);

        long left = query(N / P);
        long right = query(N / Q);

        map.put(N / P, left);
        map.put(N / Q, right);

        map.put(N, left + right);
        return left + right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(query(N));
    }
}