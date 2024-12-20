import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int n;
    static int[] num;

    static HashSet<Integer> sum = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sum.contains(num[i] - num[j])) {
                    ans++;
                    break;
                }
            }

            for (int j = 0; j <= i; j++) {
                sum.add(num[i] + num[j]);
            }
        }

        System.out.println(ans);
    }
}