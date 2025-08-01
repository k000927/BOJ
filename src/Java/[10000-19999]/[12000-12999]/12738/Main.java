import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, lengthOfLIS;
    static int[] seq, LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        seq = new int[N];
        LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            int key = seq[i];

            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            } else {
                // Lower Bound 이분탐색을 진행한다.
                int lo = 0;
                int hi = lengthOfLIS;
                while (lo < hi) {
                    int mid = (lo + hi) >>> 1;

                    if (LIS[mid] < key) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }

                }
                LIS[lo] = key;
            }
        }
        System.out.println(lengthOfLIS);
    }
}