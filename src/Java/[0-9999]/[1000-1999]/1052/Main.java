import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, ans, add;

    static int lastOne() {
        int index = 0;

        while (((1 << index) & N) == 0) {
            index++;
        }

        return 1 << index;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;

        while (Integer.bitCount(N) > K) {
            add = lastOne();
            ans += add;
            N += add;
        }

        System.out.println(ans);
    }
}
