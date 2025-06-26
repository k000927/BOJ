import java.io.*;
import java.math.BigInteger;

public class Main {
    static int N;
    static StringBuilder ans;

    static void hanoi(int from, int to, int size) {
        if (size == 0) return;
        else {
            hanoi(from, 6 - from - to, size - 1);
            ans.append(from).append(' ').append(to).append('\n');
            hanoi(6 - from - to, to, size - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        ans.append(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE)).append('\n');

        if (N <= 20) {
            hanoi(1, 3, N);
        }
        System.out.print(ans);
    }
}