import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static int T;
    static int maxN = 10000001;
    static boolean[] prime;
    static boolean[] composite;
    static int[] ans;

    static void init() {
        prime = new boolean[maxN];
        composite = new boolean[maxN];
        ans = new int[maxN];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < maxN; i++) {
            if (!prime[i]) continue;
            for (int j = 2; i * j < maxN; j++) {
                prime[i * j] = false;
            }
        }

        for (int i = 100; i < maxN; i++) {
            if (prime[i]) continue;
            String num = Integer.toString(i);
            boolean flag = true;
            for (int end = num.length(); end >= 2; end--) {
                for (int start = 0; start <= end - 2; start++) {
                    if (end == num.length() && start == 0) continue;
                    if (!prime[Integer.parseInt(num.substring(start, end))]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) composite[i] = true;
        }

        int temp = -1;
        for (int i = 0; i < maxN; i++) {
            if (composite[i]) temp = i;
            ans[i] = temp;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        init();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(ans[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}