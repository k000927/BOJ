import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] pendulum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pendulum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pendulum[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pendulum);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + 1 < pendulum[i]) {
                break;
            }

            sum += pendulum[i];
        }

        System.out.println(sum + 1);
    }
}