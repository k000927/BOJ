import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        p = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Double.parseDouble(st.nextToken());
        }

        double ans = Arrays.stream(p).sum();
        for (int i = 1; i < N; i++) {
            ans += p[i - 1] * (1 - p[i]) + (1 - p[i - 1]) * p[i];
        }

        System.out.println(ans);
    }
}