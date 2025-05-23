import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] ans = new long[101];
        ans[5] = 1;
        for (int i = 6; i < 101; i++) {
            ans[i] = ans[i-1] * i / (i-5);
        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(ans[N]);
    }
}