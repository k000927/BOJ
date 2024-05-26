import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] rain = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            rain[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 1; i <= h; i++) {
            Boolean flag = false;
            int water = 0;

            for (int j = 0; j < w; j++) {
                if (rain[j] >= i) {
                    if (flag) {
                        ans += water;
                        water = 0;
                    } else {
                        flag = true;
                    }
                } else {
                    if (flag) {
                        water++;
                    } else continue;
                }
            }
        }

        System.out.println(ans);
    }
}