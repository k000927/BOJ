import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] fibo = new long[91];

        fibo[0] = 0L;
        fibo[1] = 1L;

        for (int i = 2; i <= 90; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[n]);
    }
}