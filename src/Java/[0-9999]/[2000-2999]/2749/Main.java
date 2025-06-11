import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger N;
    static List<Integer> fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = new BigInteger(br.readLine());
        fibo = new ArrayList<>();

        fibo.add(0);
        fibo.add(1);

        int cur, prev, pisano;
        prev = 1;
        while (true) {
            cur = (fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2)) % 1000000;
            if (prev == 0 && cur == 1) {
                pisano = fibo.size() - 1;
                break;
            }
            fibo.add(cur);
            prev = cur;
        }
        
        N = N.mod(BigInteger.valueOf(pisano));
        System.out.println(fibo.get(N.intValue()));
    }
}