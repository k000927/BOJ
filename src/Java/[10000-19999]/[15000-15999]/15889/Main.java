import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean FLAG = true;
        if (N == 1) {
            System.out.println("권병장님, 중대장님이 찾으십니다");
            return;
        }

        int[] range = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            range[i] = Integer.parseInt(st.nextToken());
        }

        long max = 0;
        for (int i = 0; i < range.length; i++) {
            max = Math.max(max, arr[i] + range[i]);

            if (max >= arr[i + 1]) continue;
            else {
                System.out.println("엄마 나 전역 늦어질 것 같아");
                return;
            }
        }

        System.out.println("권병장님, 중대장님이 찾으십니다");

    }
}