import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()) - 1;

        int exp = 2;
        int temp = 1;
        while (K - exp >= 0) {
            K -= exp;
            exp <<= 1;
            temp++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = temp - 1; i >= 0; i--) {
            if((K & (1 << i)) == 0)
                ans.append(4);
            else
                ans.append(7);
        }

        System.out.println(ans);
    }
}
