import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d + 1];
        Arrays.fill(sushi, 0);
        sushi[c] = 1;

        int start = 0;
        int end = k - 1;

        int ans = 0;
        int temp = 0;

        for (int i = 0; i <= end; i++) {
            sushi[belt[i]]++;
        }

        for (int i = 0; i < d + 1; i++) {
            if (sushi[i] != 0) ans++;
        }

        temp = ans;

        for (int i = 0; i < n; i++) {
            int remove_sushi = belt[(start++) % n];
            int add_sushi = belt[(++end) % n];

            if (sushi[remove_sushi] == 1) {
                temp--;
            }
            sushi[remove_sushi]--;

            if (sushi[add_sushi] == 0) {
                temp++;
            }
            sushi[add_sushi]++;

            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}