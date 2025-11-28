import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] rideTime;

    static long getChildNum(long t) {
        long res = M;
        for (int i = 0; i < M; i++) {
            res += t / rideTime[i];
        }
        return res;
    }

    static long binarySearch() {
        long l = 0;
        long r = N * 30L;
        while (l <= r) {
            long mid = (l + r) / 2;
            long childNum = getChildNum(mid);

            if (childNum < N) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rideTime = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            rideTime[i] = Integer.parseInt(st.nextToken());
        }

        if (N <= M) {
            System.out.println(N);
            return;
        }

        long res = binarySearch();
        long child = getChildNum(res - 1);

        for (int i = 0; i < M; i++) {
            if (res % rideTime[i] == 0) {
                child++;
            }
            if (child == N) {
                System.out.println(i + 1);
                break;
            }
        }
    }


}
