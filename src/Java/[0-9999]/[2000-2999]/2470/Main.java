import java.io.*;
import java.util.*;

public class Main {
    static int min, left, right;
    static List<Integer> liq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        liq = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liq.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(liq);

        min = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            if (min > Math.abs(liq.get(0) + liq.get(i))) {
                min = Math.abs(liq.get(0) + liq.get(i));
                left = liq.get(0);
                right = liq.get(i);
            }
        }

        for (int i = 1; i < N; i++) {
            binSearch(i + 1, N - 1, liq.get(i));
        }

        System.out.println(left + " " + right);
    }

    static int mid, mix;

    public static void binSearch(int start, int end, int value) {

        while (start <= end) {
            mid = (start + end) / 2;
            mix = value + liq.get(mid);

            if (mix < -min) {
                start = mid + 1;
            } else if (mix > min) {
                end = mid - 1;
            } else {
                min = Math.abs(mix);
                left = value;
                right = liq.get(mid);

                if (mix < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
    }
}