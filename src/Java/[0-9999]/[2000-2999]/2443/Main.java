import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder star = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            star.append(" ".repeat(i)).append("*".repeat(2 * (N - i) - 1)).append('\n');
        }

        System.out.println(star);
    }
}