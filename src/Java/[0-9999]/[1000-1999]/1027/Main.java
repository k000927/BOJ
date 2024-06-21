import java.io.*;
import java.util.*;

public class Main {
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        building = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                double dx = j - i;
                double dy = building[j] - building[i];

                Boolean flag = true;

                if(i < j) {
                    for (int k = i + 1; k < j; k++) {
                        if (!flag) break;
                        if (building[k] >= (dy / dx) * (k - i) + building[i]) flag = false;
                    }
                }
                else{
                    for (int k = j + 1; k < i; k++) {
                        if (!flag) break;
                        if (building[k] >= (dy / dx) * (k - i) + building[i]) flag = false;
                    }
                }

                if (flag) temp++;
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }
}