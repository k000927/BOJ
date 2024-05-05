import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Long[] road = new Long[n - 1];
        Long[] gas = new Long[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gas[i] = Long.parseLong(st.nextToken());
        }

        Long ans = 0L;
        Long min_gas = gas[0];
        for (int i = 0; i < n - 1; i++) {
            ans += road[i] * min_gas;
            min_gas = Math.min(min_gas, gas[i + 1]);
        }
        System.out.println(ans);
    }
}