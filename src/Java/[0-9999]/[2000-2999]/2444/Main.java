import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            ans.append(" ".repeat(N - i - 1)).append("*".repeat(2 * i + 1)).append("\n");
        }

        for (int i = N - 2; i >= 0; i--) {
            ans.append(" ".repeat(N - i - 1)).append("*".repeat(2 * i + 1)).append("\n");
        }

        System.out.print(ans);
    }
}