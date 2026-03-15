import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double ans = 0;
        for (int i = 0; i < N; i++) {
            ans += (double) N / (N-i);
        }

        System.out.println(ans);
    }
}
