import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] ans = new int[1000001];

        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;

        for (int i = 3; i < 1000001; i++) {
            ans[i] = ((ans[i - 1]) % 15746 + (ans[i - 2] ) % 15746) % 15746;
        }

        System.out.println(ans[Integer.parseInt(bufferedReader.readLine())]);
    }
}
