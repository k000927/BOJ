import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        if (x == y) {
            System.out.println(0);
            System.exit(0);
        }

        for (long i = 1; ; i++) {
            long k = (i + 1) * i;
            if (k >= y - x) {
                if (k - i < y - x) System.out.println(i * 2);
                else System.out.println(i * 2 - 1);
                System.exit(0);
            }
        }
    }
}