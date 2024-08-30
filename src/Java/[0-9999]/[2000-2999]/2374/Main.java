import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, num[i]);
        }

        long ans = 0L;
        int prevNum = max;
        for (int i = 0; i < n; i++) {
            if (prevNum > num[i]) {
                ans += prevNum - num[i];
            }
            prevNum = num[i];
        }

        System.out.println(ans);
    }
}
