import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L;
    static List<Integer> oasis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        oasis = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            oasis.add(Integer.parseInt(st.nextToken()));
        }

        oasis.add(L);
        Collections.sort(oasis);

        int left = 0, right = L;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0, prev = 0;
            for (Integer dist : oasis) {
                int diff = dist - prev - 1;
                if (mid != 0 && diff > 0) count += (diff / mid);
                prev = dist;
            }

            if (mid == 0 || count > M)
                left = mid + 1;
            else
                right = mid;
        }

        System.out.println(left);
    }
}

/*
2 98 100
1 100
1
 */