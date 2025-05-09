import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) / 3;

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (N - i - j > 0)
                    ans += 1;
            }
        }
        System.out.println(ans);
    }
}