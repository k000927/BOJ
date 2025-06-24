import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int m = arr[1] - arr[0];
        for (int i = 2; i < N; i++) {
            m = gcd(arr[i] - arr[0], m);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                pq.add(i);
                if (i != m / i)
                    pq.add(m / i);
            }
        }
        pq.add(m);

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            ans.append(pq.poll()).append(' ');
        }
        System.out.println(ans);
    }
}