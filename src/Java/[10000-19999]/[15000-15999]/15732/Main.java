import java.io.*;
import java.util.*;

public class Main {
    static int N, K, D;
    static Rule[] rules;

    static class Rule {
        int A, B, C;

        Rule(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        rules = new Rule[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            rules[i] = new Rule(A, B, C);
        }

        int left = 1, right = N;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long count = 0;

            for (Rule rule : rules) {
                if (rule.A > mid) continue;
                if (rule.B <= mid) {
                    count += (rule.B - rule.A) / rule.C + 1;
                    continue;
                }

                count += (mid - rule.A) == 0 ? 1 : (mid - rule.A) / rule.C + 1;
            }

            if (count >= D) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left);
    }
}