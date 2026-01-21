import java.io.*;
import java.util.*;

public class Main {
    static int a, b, diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) break;

            diff = Math.max(a, b) - Math.min(a, b);
            ans.append(Math.min(a,b) - diff).append('\n');
        }

        System.out.print(ans);
    }
}