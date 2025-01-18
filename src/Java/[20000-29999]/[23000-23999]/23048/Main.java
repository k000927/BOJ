import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int color = 1;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N + 1];
        number[1] = color;

        for (int i = 2; i <= N; i++) {
            if (number[i] != 0) continue;
            color++;
            for (int j = 1; i * j <= N; j++) {
                number[i * j] = color;
            }
        }

        StringBuilder sb = new StringBuilder();

        System.out.println(color);
        for (int i = 1; i <= N; i++) sb.append(number[i]).append(" ");
        System.out.println(sb);
    }
}