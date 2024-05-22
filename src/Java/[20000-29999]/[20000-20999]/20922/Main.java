import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int start = 0;

        int[] num = new int[100001];
        Arrays.fill(num, 0);

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int cur_num = arr[i];

            num[cur_num]++;
            if (num[cur_num] > k) {
                while (num[cur_num] != k) {
                    num[arr[start++]]--;
                }
            }
            ans = Math.max(ans, i - start + 1);
        }

        System.out.println(ans);
    }
}