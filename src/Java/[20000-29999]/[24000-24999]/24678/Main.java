import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int even = 0;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if ((x & 1) == 0) even++;
            if ((y & 1) == 0) even++;
            if ((z & 1) == 0) even++;

            if (even >= 2) ans.append('R').append('\n');
            else ans.append('B').append('\n');
        }

        System.out.print(ans);
    }
}