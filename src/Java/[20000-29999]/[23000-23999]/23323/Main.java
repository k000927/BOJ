import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int z = 0; z < t; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Long n = Long.parseLong(st.nextToken());
            Long m = Long.parseLong(st.nextToken());

            Long ans = 0L;

            while (n != 1L) {
                n = (long) Math.floor(n / 2);
                ans++;
            }

            System.out.println(ans + m + 1);
        }
    }
}