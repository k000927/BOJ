import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = 0;
        long answer = 0;
        int[] ct = new int[100_001];
        while (l <= n) {
            while (r + 1 <= n && ct[arr[r + 1]] == 0) {
                r++;
                ct[arr[r]]++;
            }

            answer += r - l + 1;
            ct[arr[l++]]--;
        }

        System.out.println(answer);
    }
}