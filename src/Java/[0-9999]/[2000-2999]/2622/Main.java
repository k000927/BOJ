import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int edge1;
        if (n % 2 == 0) {
            edge1 = n / 2 - 1;
        } else {
            edge1 = (n - 1) / 2;
        }
        int edge2 = edge1;
        int edge3 = n - (edge1 + edge2);

        int ans = 0;

        while (edge2 >= 1) {
            while (edge2 >= edge3) {
                ans++;
                edge2--;
                edge3++;
            }
            edge1--;
            edge2 = edge1;
            edge3 = n - (edge1 + edge2);
        }

        System.out.println(ans);
    }
}
