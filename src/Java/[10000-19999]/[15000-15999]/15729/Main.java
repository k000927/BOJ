import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] light = new int[n];
        int[] curLight = new int[n];
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (light[i] != curLight[i]) {
                ans++;
                curLight[i] = (curLight[i] + 1) % 2;
                if (i + 1 < n) curLight[i + 1] = (curLight[i + 1] + 1) % 2;
                if (i + 2 < n) curLight[i + 2] = (curLight[i + 2] + 1) % 2;
            }
        }

        System.out.println(ans);
    }
}
